package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.Resident;

public interface ResidentMapper {
	/**
	 * 根据姓名和身份证查询居民
	 */
	public Resident queryResidentByNameAndCard(Map<String,Object> paramMap);
	
	/**
	 * 新增居民用户
	 */
	public int addResident(Resident resident);
	
	/**
	 * 查询居民用户列表
	 */
	public List<Map<String,Object>> queryResidentList(Map<String,Object> paramMap);
	
	/**
	 * 根据姓名和身份证修改居民
	 */
	public int updateResidentByNameAndCard(Resident resident);
	
	/**
	 * 查询居民信息
	 */
	public Map<String,Object> queryResident(String uuid);
}
