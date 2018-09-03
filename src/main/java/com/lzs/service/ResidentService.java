package com.lzs.service;

import java.util.List;
import java.util.Map;

import com.lzs.model.Resident;

public interface ResidentService {
	/**
	 * 新增居民用户
	 * @throws Exception 
	 */
	public int addResident(Resident resident) throws Exception;
	
	/**
	 * 查询居民用户列表
	 */
	public List<Map<String,Object>> queryResidentList(Map<String,Object> paramMap);
	
	/**
	 * 查询居民信息
	 */
	public Map<String,Object> queryResident(String uuid);
	
	/**
	 * 根据身份证修改居民
	 */
	public int updateResident(Resident resident);
}
