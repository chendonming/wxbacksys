package com.lzs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.lzs.service.HotlineService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/hotline")
@RestController
public class HotlineController {
	  @Autowired
	  private HotlineService hotlineService;
	  
	  
	  @RequestMapping("/queryHotline")
	  public ReturnResult queryHotline(){
		 Map<String,Object> map = hotlineService.queryHotline();
		 return ReturnResult.success(map);
	  }
	  
	  @RequestMapping("/updateHotline")
	  public ReturnResult updateHotline(String uuid,String phone){
		  if(StringUtils.isEmpty(uuid)){
			  return ReturnResult.error("热线的id不能为空！");
		  }
		  if(StringUtils.isEmpty(phone)){
			  return ReturnResult.error("热线号码不能为空！");
		  }
		  Map<String,Object> paramMap = new HashMap<String,Object>();
		  paramMap.put("uuid", uuid);
		  paramMap.put("phone", phone);
		  int i = hotlineService.updateHotline(paramMap);
		  return ReturnResult.success(i);
	  }
}
