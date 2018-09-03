package com.lzs.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ExcelService {
	/**
	 * 导入excel
	 * @throws Exception 
	 */
	public void importExcel(Map<String,Object> paramMap) throws Exception;
	
	/**
	 * 导出excel
	 * @throws Exception 
	 */
	public XSSFWorkbook exportExcel() throws Exception;
	
}
