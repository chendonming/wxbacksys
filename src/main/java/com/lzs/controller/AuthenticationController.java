package com.lzs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lzs.exception.BusinessException;
import com.lzs.model.User;
import com.lzs.service.AuthenticationService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/authentication")
@RestController
public class AuthenticationController extends BaseController{
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping("/addAuthentication")
	public ReturnResult addAuthentication(String name,String card_number){
		User user = this.getUser();
		Integer is_authentication =user.getIs_authentication();
		if(is_authentication==1){
			return ReturnResult.error("已实名认证过，无需再进行实名认证！");
		}
		String user_id = user.getUuid();
		try{
			int i = authenticationService.addAuthentication(name,card_number,user_id);
		} catch(BusinessException e){
			return ReturnResult.error(e.getMessage());
		}
		return ReturnResult.success();
	}
}
