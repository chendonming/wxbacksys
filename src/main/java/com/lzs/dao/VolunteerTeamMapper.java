package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.VolunteerTeam;

public interface VolunteerTeamMapper {
	/**
	 * 新增志愿者团队
	 */
	public int addVolunteerTeam(VolunteerTeam volunteerTeam);
	
	/**
	 * 查询志愿者团队列表
	 */
	public List<Map<String,Object>> queryVolunteerTeamList(Map<String,Object> paramMap);
	
	/**
	 * 查询志愿者团队详情
	 */
	public VolunteerTeam queryVolunteerTeam(String uuid);
	
	/**
	 * 修改志愿者团队详情
	 */
	public int updateVolunteerTeam(VolunteerTeam volunteerTeam);
	
	/**
	 * 根据用户查询管理团队类型 
	 */
	public List<Map<String,Object>> queryTypeByUser(String user_id);
	
	/**
	 * 根据服务类型查询志愿者团队详情
	 */
	public VolunteerTeam queryVolunteerTeamByType(String type);
	
	/**
	 * 查询我的志愿者团队列表
	 */
	public List<Map<String,Object>> queryVolunteerTeamListForMy(String user_id);
}
