package com.lzs.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lzs.dao.ActivityRegistrationMapper;
import com.lzs.model.ActivityRegistration;
import com.lzs.service.ActivityRegistrationService;
import com.lzs.utils.IDUtils;

@Service
public class ActivityRegistrationServiceImpl implements ActivityRegistrationService{
	@Autowired
	private ActivityRegistrationMapper activityRegistrationMapper;
	
	/**
	 * 活动报名
	 */
	public int addActivityRegistration(ActivityRegistration activityRegistration){
		String uuid = IDUtils.genId();
		activityRegistration.setUuid(uuid);
		return activityRegistrationMapper.addActivityRegistration(activityRegistration);
	}
	
	/**
	 * 查询活动报名总人数
	 */
	public Integer queryActivityRegistrationTotalPeople(String activity_id){
		return activityRegistrationMapper.queryActivityRegistrationTotalPeople(activity_id);
	}
	
	
	/**
	 * 活动报名名称列表
	 */
	public List<Map<String,Object>> queryActivityRegistrationList(String activity_id){
		return activityRegistrationMapper.queryActivityRegistrationList(activity_id);
	}
	
	/**
	 * 查看报名用户的详情
	 */
	public Map<String,Object> queryActivityRegistration(String uuid){
		return activityRegistrationMapper.queryActivityRegistration(uuid);
	}
}
