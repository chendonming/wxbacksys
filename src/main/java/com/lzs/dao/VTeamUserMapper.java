package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.VTeamUser;

public interface VTeamUserMapper {
	/**
	 * 设置成为管理员
	 */
	public int addVTeamUser(VTeamUser vTeamUser);
	
	/**
	 * 根据团队和用户查询团队管理员
	 */
	public Map<String,Object>  queryVTeamUserByUserAndTeam(Map<String,Object> paramMap);
	
	/**
	 * 删除志愿者管理员
	 */
	public int deleteVTeamUser(Map<String,Object> paramMap);
	
	/**
	 * 根据用户id查询管理关系
	 */
	public List<Map<String,Object>> queryVTeamUserListByUser(String user_id);
	
	/**
	 * 根据志愿者团队查询管理员
	 */
	public List<Map<String,Object>> queryVTeamUserList(String volunteer_team_id);
}
