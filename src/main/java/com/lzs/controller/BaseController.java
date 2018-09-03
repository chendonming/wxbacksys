package com.lzs.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lzs.model.User;
import com.lzs.service.UserService;

public class BaseController {
	@Autowired
	private UserService userService;


	public  User getUser(){
		 ServletRequestAttributes attr = (ServletRequestAttributes)
	                RequestContextHolder.currentRequestAttributes();
	        HttpServletRequest request = attr.getRequest();
		String uuid = request.getHeader("user_id");
		User user = userService.queryUserToUser(uuid);
		return user;
	}
}
