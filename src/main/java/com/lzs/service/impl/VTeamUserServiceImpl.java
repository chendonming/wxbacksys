package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.UserMapper;
import com.lzs.dao.VTeamUserMapper;
import com.lzs.model.User;
import com.lzs.model.VTeamUser;
import com.lzs.service.VTeamUserService;
import com.lzs.utils.IDUtils;

@Service
public class VTeamUserServiceImpl implements VTeamUserService{
	@Autowired
	private VTeamUserMapper vTeamUserMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 设置成为管理员
	 */
	@Transactional
	public int addVTeamUser(VTeamUser vTeamUser){
		String uuid = IDUtils.genId();
		vTeamUser.setUuid(uuid);
		User user = new User();
		user.setUuid(vTeamUser.getUser_id());
		user.setRole(2);
		userMapper.updateUser(user);
		return vTeamUserMapper.addVTeamUser(vTeamUser);
	}
	
	/**
	 * 根据团队和用户查询团队管理员
	 */
	public Map<String,Object>  queryVTeamUserByUserAndTeam(Map<String,Object> paramMap){
		return vTeamUserMapper.queryVTeamUserByUserAndTeam(paramMap);
	}
	
	/**
	 * 删除志愿者管理员
	 */
	public int deleteVTeamUser(Map<String,Object> paramMap){
		int i =vTeamUserMapper.deleteVTeamUser(paramMap);
		String user_id = paramMap.get("user_id").toString();
		List<Map<String,Object>> list = vTeamUserMapper.queryVTeamUserListByUser(user_id);
		if(list==null || list.size()==0){
			User user = new User();
			user.setUuid(user_id);
			user.setRole(1);
			userMapper.updateUser(user);
		}
		return i;
	}
	
	/**
	 * 根据志愿者团队查询管理员
	 */
	public List<Map<String,Object>> queryVTeamUserList(String volunteer_team_id){
		return vTeamUserMapper.queryVTeamUserList(volunteer_team_id);
	}
}
