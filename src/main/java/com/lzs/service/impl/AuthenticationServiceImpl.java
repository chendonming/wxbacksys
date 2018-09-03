package com.lzs.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.AuthenticationMapper;
import com.lzs.dao.ResidentMapper;
import com.lzs.dao.UserMapper;
import com.lzs.exception.BusinessException;
import com.lzs.model.Authentication;
import com.lzs.model.Resident;
import com.lzs.model.User;
import com.lzs.service.AuthenticationService;
import com.lzs.utils.IDUtils;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	private AuthenticationMapper authenticationMapper;
	@Autowired
	private ResidentMapper residentMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 新增实名认证
	 * @throws BusinessException 
	 */
	@Transactional
	public int addAuthentication(String name,String card_number,String user_id) throws BusinessException{
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("name", name);
		paramMap.put("card_number", card_number);
		Resident resident =residentMapper.queryResidentByNameAndCard(paramMap);
		if(resident==null){
			throw new BusinessException("该用户不存在居民用户消息中！");
		}
		String resident_id = resident.getUuid();
		//修改用户信息
		User user = new User();
		user.setUuid(user_id);
		user.setReal_name(name);
		user.setCard_number(card_number);
		user.setIs_authentication(1);
		userMapper.updateUser(user);
		
		//新增实名认证关系
		String uuid = IDUtils.genId();
		Authentication authentication = new Authentication();
		authentication.setUuid(uuid);
		authentication.setCard_number(card_number);
		authentication.setName(name);
		authentication.setUser_id(user_id);
		authentication.setResident_id(resident_id);
		return authenticationMapper.addAuthentication(authentication);
	}
}
