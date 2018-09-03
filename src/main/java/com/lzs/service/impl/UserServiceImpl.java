package com.lzs.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.lzs.dao.UserMapper;
import com.lzs.model.User;
import com.lzs.service.UserService;
import com.lzs.utils.IDUtils;

@Service
public class UserServiceImpl implements UserService{
	@Value("${appId}")
	private String appId;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 新增用户
	 */
	public int addUser(User user){
		String uuid = IDUtils.genId();
		user.setUuid(uuid);
		user.setAppid(appId);
		return userMapper.addUser(user);
	}
	
	/**
	 * 查询用户列表
	 */
	public List<Map<String,Object>> queryUserList(Map<String,Object> paramMap){
		return userMapper.queryUserList(paramMap);
	}
	
	/**
	 * 查询用户详情
	 */
	public Map<String,Object> queryUser(String uuid){
		return userMapper.queryUser(uuid);
	}
	
	/**
	 * 修改用户信息
	 */
	public int updateUser(User user){
		return userMapper.updateUser(user);
	}
	
	/**
	 * 查询用户详情
	 */
	public User queryUserToUser(String uuid){
		return userMapper.queryUserToUser(uuid);
	}
}
