package com.lzs.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.util.StringUtils;
import com.lzs.service.TypeDetailService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/typedetail")
@RestController
public class TypeDetailController {
	@Autowired
	private TypeDetailService typeDetailService;
	
	@RequestMapping("/queryTypeDetailByTypeCode")
	public ReturnResult queryTypeDetailByTypeCode(String code){
		if(StringUtils.isEmpty(code)){
			return ReturnResult.error("类型编码不能为空！");
		}
		List<Map<String,Object>>  typeDetailList =typeDetailService.queryTypeDetailByTypeCode(code);
		return ReturnResult.success(typeDetailList);
	}
	
}
