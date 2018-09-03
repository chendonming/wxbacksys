package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.Activity;

public interface ActivityMapper {
	/**
	 * 发布活动
	 */
	public int addActivity(Activity activity);
	
	/**
	 * 查询活动列表
	 */
	public List<Map<String,Object>> queryActivityListByParam(Map<String,Object> paramMap);
	
	/**
	 * 查询活动详情
	 */
	public  Map<String,Object> queryActivity(String uuid);
	
	/**
	 * 删除活动
	 */
	public int deleteActivity(String uuid);
	
	/**
	 * 修改活动
	 */
	public  int  updateActivity(Activity activity);
	
	/**
	 * 我参与的活动
	 */
	public List<Map<String,Object>> queryActivityForMyself(String user_id);
	
	/**
	 * 活动管理列表
	 */
	public List<Map<String,Object>> queryActivityForManager(Map map);
}
