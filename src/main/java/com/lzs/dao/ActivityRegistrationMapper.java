package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.ActivityRegistration;

public interface ActivityRegistrationMapper {
	/**
	 * 活动报名
	 */
	public int addActivityRegistration(ActivityRegistration activityRegistration);
	
	/**
	 * 查询活动报名总人数
	 */
	public Integer queryActivityRegistrationTotalPeople(String activity_id);
	
	
	/**
	 * 活动报名名称列表
	 */
	public List<Map<String,Object>> queryActivityRegistrationList(String activity_id);
	
	/**
	 * 查看报名用户的详情
	 */
	public Map<String,Object> queryActivityRegistration(String uuid);
}
