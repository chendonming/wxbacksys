package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzs.dao.ActivityMapper;
import com.lzs.model.Activity;
import com.lzs.service.ActivityService;
import com.lzs.utils.IDUtils;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityMapper activityMapper;
	
	/**
	 * 发布活动
	 */
	public int addActivity(Activity activity){
		String uuid = IDUtils.genId();
		activity.setUuid(uuid);
		return activityMapper.addActivity(activity);
	}
	
	/**
	 * 查询活动列表
	 */
	public List<Map<String,Object>> queryActivityListByParam(Map<String,Object> paramMap){
		return activityMapper.queryActivityListByParam(paramMap);
	}
	
	/**
	 * 查询活动详情
	 */
	public  Map<String,Object> queryActivity(String uuid){
		return activityMapper.queryActivity(uuid);
	}
	
	/**
	 * 删除活动
	 */
	public int deleteActivity(String uuid){
		return activityMapper.deleteActivity(uuid);
	}
	
	/**
	 * 修改活动
	 */
	public  int  updateActivity(Activity activity){
		return activityMapper.updateActivity(activity);
	}
	
	/**
	 * 我参与的活动
	 */
	public List<Map<String,Object>> queryActivityForMyself(String user_id){
		return activityMapper.queryActivityForMyself(user_id);
	}
	
	/**
	 * 活动管理列表
	 */
	public List<Map<String,Object>> queryActivityForManager(Map map){
		return activityMapper.queryActivityForManager(map);
	}
}
