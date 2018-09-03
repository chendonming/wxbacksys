package com.lzs.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzs.model.WxUser;
import com.lzs.service.XcxLoginService;
import com.lzs.utils.ReturnResult;

@RestController
@RequestMapping("/xcxlogin")
public class XcxLoginController {
	@Autowired
	private XcxLoginService xcxLoginService;
	
	/**
	 * 小程序登陆
	 */
	@RequestMapping("/login")
	public ReturnResult login(WxUser wxUser){
		try{
			Map<String,Object> returnMap = xcxLoginService.login(wxUser);
			return ReturnResult.success(returnMap);
		} catch(Exception e){
			return ReturnResult.error(e.getMessage());
		}
	}
	
}
