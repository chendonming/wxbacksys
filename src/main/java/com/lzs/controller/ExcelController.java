package com.lzs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lzs.service.ExcelService;
import com.lzs.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/excel")
@Api(description = "excel导入导出")
public class ExcelController{
	private Logger log = Logger.getLogger("ExcelController.class");
	@Autowired
	private ExcelService excelService;
	
	
	@ApiOperation(value = "excel导入", notes = "excel导入")
	@RequestMapping(value = "/importExcel.do", method = RequestMethod.POST)	
	public ReturnResult importExcel(@RequestParam MultipartFile file) {
		try{
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("file", file);
			excelService.importExcel(paramMap);	
		}catch(Exception e){
			e.printStackTrace();
			return ReturnResult.exception(e.getMessage());
		}
		return ReturnResult.success();
	}

	@ApiOperation(value = "excel导出", notes = "excel导出")
	@RequestMapping(value = "/exportExcel.do", method = RequestMethod.GET)
	public ReturnResult exportExcel(HttpServletResponse response) {
		ServletOutputStream sout = null;
		try {
		XSSFWorkbook workbook = excelService.exportExcel();
		String fileName = "jmyh";
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition","attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "UTF-8"));
		sout = response.getOutputStream();
		workbook.write(sout);
		} catch(Exception e){
			e.printStackTrace();
			ReturnResult.exception(e.getMessage());
		}finally{
			if(sout != null){
				try{
					sout.flush();
					sout.close();
				}catch(Exception e1){
					e1.printStackTrace();
					return	ReturnResult.exception(e1.getMessage());
				}
			}
			return ReturnResult.success();
		}
	}
}
