package com.lzs.service;

import java.util.List;
import java.util.Map;

import com.lzs.model.User;

public interface UserService {
	/**
	 * 新增用户
	 */
	public int addUser(User user);
	
	/**
	 * 查询用户列表
	 */
	public List<Map<String,Object>> queryUserList(Map<String,Object> paramMap);
	
	/**
	 * 查询用户详情
	 */
	public Map<String,Object> queryUser(String uuid);
	
	/**
	 * 修改用户信息
	 */
	public int updateUser(User user);
	
	/**
	 * 查询用户详情
	 */
	public User queryUserToUser(String uuid);
}
