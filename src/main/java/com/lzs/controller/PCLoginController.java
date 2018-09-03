package com.lzs.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.lzs.service.PCLoginService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/pclogin")
@RestController
public class PCLoginController {
	@Autowired
	PCLoginService pcLoginService;
	
	@RequestMapping("/login")
	public ReturnResult login(String userName,String passWord){
		if(StringUtils.isEmpty(userName)){
			return ReturnResult.error("用户名不能为空！");
		}
		if(StringUtils.isEmpty(passWord)){
			return ReturnResult.error("密码不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("nick_name", userName);
		paramMap.put("openid", passWord);
		String user_id = pcLoginService.login(paramMap);
		if(user_id==null){
			return ReturnResult.error("用户名密码不正确！");
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("user_id", user_id);
		returnMap.put("role", 3);
		return ReturnResult.success(returnMap);
	}
}
