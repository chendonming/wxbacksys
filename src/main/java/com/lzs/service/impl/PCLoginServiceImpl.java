package com.lzs.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lzs.dao.UserMapper;
import com.lzs.service.PCLoginService;

@Service
public class PCLoginServiceImpl implements PCLoginService{
	@Autowired
	private UserMapper userMapper;
	/**
	 * pc端登陆
	 */
	public String login(Map<String,Object> paramMap){
		Map<String,Object> userMap = userMapper.queryUserByOpenidAndName(paramMap);
		if(userMap==null || userMap.size()==0){
			return null;
		} else {
			return userMap.get("uuid").toString();
		}
	}
}
