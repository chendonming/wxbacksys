package com.lzs.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lzs.dao.ResidentMapper;
import com.lzs.model.Resident;
import com.lzs.service.ExcelService;
import com.lzs.utils.CheckUtils;
import com.lzs.utils.IDUtils;

@Service
public class ExcelServiceImpl implements ExcelService {

	protected final Logger logger = LoggerFactory.getLogger(ExcelServiceImpl.class);

	@Autowired
	private ResidentMapper residentMapper;
	
	/**
	 * 导出excel
	 * @throws Exception 
	 * 
	 * @throws IOException
	 */
	@Override
	public XSSFWorkbook exportExcel() throws Exception{
		XSSFWorkbook wb = null;
		InputStream fi =null;
		try {
				Map<String,Object> paramMap = new HashMap<String,Object>();
				List<Map<String,Object>> residentList =residentMapper.queryResidentList(paramMap);
				Resource fileResource = new ClassPathResource("dataFile/jmyh.xlsx");
				fi = fileResource.getInputStream();
				wb = new XSSFWorkbook(fi);
				if(residentList!=null&& residentList.size()>0){
					exportResident(wb, residentList);
				}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(fi !=null){
				fi.close();
			}
		}

		return wb;
	}

	/**
	 * 导出居民用户
	 */
	private void exportResident(XSSFWorkbook wb,List<Map<String,Object>> list){
		// 读取了模板内所有sheet内容
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFDataFormat format = wb.createDataFormat();
		XSSFCellStyle styleCell = wb.createCellStyle();
		styleCell.setDataFormat(format.getFormat("@"));
		
		for(int i=0;i<list.size(); i++){
			Map<String,Object> temMap = list.get(i);
			// 在相应的单元格进行赋值
			int rowIndex = i+2;
			XSSFRow row = sheet.getRow(rowIndex);
			if (null == row) {
				row = sheet.createRow(rowIndex);
			}
			XSSFCell cell0 = row.getCell(0);
			if (null == cell0) {
				cell0 = row.createCell(0);
				cell0.setCellStyle(styleCell);
			}
			if(temMap.get("name")!=null){
				cell0.setCellValue(temMap.get("name").toString());
			}

			XSSFCell cell1 = row.getCell(1);
			if (null == cell1) {
				cell1 = row.createCell(1);
				cell1.setCellStyle(styleCell);
			}
			if(temMap.get("sex")!=null){
				int sex = Integer.valueOf(temMap.get("sex").toString());
				if(sex==1){
					cell1.setCellValue("男");
				} else{
					cell1.setCellValue("女");
				}
			}
			
			XSSFCell cell2 = row.getCell(2);
			if (null == cell2) {
				cell2 = row.createCell(2);
				cell2.setCellStyle(styleCell);
			}
			if(temMap.get("phone")!=null){
				cell2.setCellValue(temMap.get("phone").toString());
			}

			XSSFCell cell3 = row.getCell(3);
			if (null == cell3) {
				cell3 = row.createCell(3);
				cell3.setCellStyle(styleCell);
			}
			if(temMap.get("card_number")!=null){
				cell3.setCellValue(temMap.get("card_number").toString());
			}
			rowIndex++;
		}
	}
	
	
	/**
	 * 导入excel
	 * 
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor={Exception.class, RuntimeException.class})
	public void importExcel(Map<String, Object> paramMap) throws Exception {
		InputStream input = null;
		int k = 0;
		boolean mbFlag = false;
		try {
			MultipartFile file = (MultipartFile) paramMap.get("file");
			input = file.getInputStream();
			XSSFWorkbook workBook = new XSSFWorkbook(input);
			XSSFSheet sheet = workBook.getSheetAt(0);
			XSSFRow row1 = sheet.getRow(0);
			String title = row1.getCell(0).toString().trim();
			if (sheet != null) {
				for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
					k = i+1;
					XSSFRow row = sheet.getRow(i);
					if("居民用户".equals(title)){
							updateResident(row, paramMap);
					} else{
						mbFlag = true;
						throw new Exception("模板不正确！");
					}
				}
			}
		} catch (Exception e) {
			if(mbFlag){
				throw new Exception(e.getMessage());
			} else {
				throw new Exception("第"+k+"行："+e.getMessage());
			}
			
		}finally {
			input.close();
		}
	}

	/**
	 * 更新居民用户
	 * 
	 * @throws Exception
	 */
	private void updateResident(XSSFRow row, Map<String, Object> paramMap) throws Exception{
		Resident resident = new Resident();
		if(checkCell(row.getCell(0))){
			resident.setName(row.getCell(0).toString());
		}else{
			throw new Exception("名称不能为空！");
		}
		if(checkCell(row.getCell(1))){
			if ("男".equals(row.getCell(1).toString())) {
				resident.setSex(1);
			} else if("女".equals(row.getCell(1).toString())){
				resident.setSex(2);
			}
		}
		if(checkCell(row.getCell(2))){
			if(CheckUtils.isMobile(row.getCell(2).toString())){
				resident.setPhone(row.getCell(2).toString());
			}else {
				throw new Exception("电话号码格式不合法！");
			}
		}
		if(checkCell(row.getCell(3))){
			if(CheckUtils.isIdcard(row.getCell(3).toString())){
				resident.setCard_number(row.getCell(3).toString());
			} else {
				throw new Exception("身份证号码格式不合法！");
			}
			
		}
		Map<String, Object> comMap = new HashMap<String, Object>();
		comMap.put("card_number", resident.getCard_number());
		Resident resident1  = residentMapper.queryResidentByNameAndCard(comMap);
		if (resident1 !=null) {
			residentMapper.updateResidentByNameAndCard(resident);
		} else {
			String uuid = IDUtils.genId();
			resident.setUuid(uuid);
			residentMapper.addResident(resident);
		}
	}
	
	
	/**
	 * 检查excel单元是否为null或者空，如果不为null和空返回为true，否则为false
	 * @param xSSFRow
	 */
	private boolean checkCell(XSSFCell xSSFCell){
		if(xSSFCell!=null && !"".equals(xSSFCell.toString())){
			return true;
		}
		return false;
	}
}
