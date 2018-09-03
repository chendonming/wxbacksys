package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.Volunteer;

public interface VolunteerMapper {
	/**
	 * 申请成为志愿者
	 */
	public int addVolunteer(Volunteer volunteer);
	
	/**
	 * 志愿者列表查询
	 */
	public List<Map<String,Object>> queryVolunteerListByParam(Map<String,Object> paramMap);
	
	/**
	 * 查询志愿者详情
	 */
	public Map<String,Object> queryVolunteer(String uuid);
	
	/**
	 * 查询是否已申请过志愿者
	 */
	public int queryVolunteerCount(Map<String,Object> paramMap);
	
	
	/**
	 * 修改志愿者状态
	 */
	public int updateVolunteerStauts(Map<String,Object> paramMap);
}
