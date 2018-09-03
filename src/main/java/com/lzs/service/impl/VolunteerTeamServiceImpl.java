package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.VolunteerTeamMapper;
import com.lzs.dao.VolunteerTeamPictureMapper;
import com.lzs.model.VolunteerTeam;
import com.lzs.model.VolunteerTeamPicture;
import com.lzs.service.VolunteerTeamService;
import com.lzs.utils.IDUtils;

@Service
public class VolunteerTeamServiceImpl implements VolunteerTeamService{
	@Autowired
	private VolunteerTeamMapper volunteerTeamMapper;
	@Autowired
	private VolunteerTeamPictureMapper volunteerTeamPictureMapper;
	
	/**
	 * 新增志愿者团队
	 */
	@Transactional
	public int addVolunteerTeam(VolunteerTeam volunteerTeam){
		String uuid = IDUtils.genId();
		volunteerTeam.setUuid(uuid);
		int i = volunteerTeamMapper.addVolunteerTeam(volunteerTeam);
		List<VolunteerTeamPicture> pictureList = volunteerTeam.getPictureList();
		if(pictureList!=null && pictureList.size()>0){
			for(VolunteerTeamPicture volunteerTeamPicture:pictureList){
				String pictureUuid = IDUtils.genId();
				volunteerTeamPicture.setUuid(pictureUuid);
				volunteerTeamPicture.setVolunteer_team_id(uuid);
				volunteerTeamPictureMapper.addVolunteerTeamPicture(volunteerTeamPicture);
			}
		}
		return i;
	}
	
	/**
	 * 查询志愿者团队列表
	 */
	public List<Map<String,Object>> queryVolunteerTeamList(Map<String,Object> paramMap){
		return volunteerTeamMapper.queryVolunteerTeamList(paramMap);
	}
	
	/**
	 * 查询志愿者团队详情
	 */
	public VolunteerTeam queryVolunteerTeam(String uuid){
		return volunteerTeamMapper.queryVolunteerTeam(uuid);
	}
	
	/**
	 * 修改志愿者团队详情
	 */
	@Transactional
	public int updateVolunteerTeam(VolunteerTeam volunteerTeam){
		int i = volunteerTeamMapper.updateVolunteerTeam(volunteerTeam);
		List<VolunteerTeamPicture> pictureList = volunteerTeam.getPictureList();
		volunteerTeamPictureMapper.deleteVolunteerTeamPicture(volunteerTeam.getUuid());
		if(pictureList!=null && pictureList.size()>0){
			for(VolunteerTeamPicture volunteerTeamPicture:pictureList){
				String pictureUuid = IDUtils.genId();
				volunteerTeamPicture.setUuid(pictureUuid);
				volunteerTeamPicture.setVolunteer_team_id(volunteerTeam.getUuid());
				volunteerTeamPictureMapper.addVolunteerTeamPicture(volunteerTeamPicture);
			}
		}
		return i;
	}
	
	/**
	 * 根据用户查询管理团队类型 
	 */
	public List<Map<String,Object>> queryTypeByUser(String user_id){
		return volunteerTeamMapper.queryTypeByUser(user_id);
	}
	
	/**
	 * 根据服务类型查询志愿者团队详情
	 */
	public VolunteerTeam queryVolunteerTeamByType(String type){
		return volunteerTeamMapper.queryVolunteerTeamByType(type);
	}
	
	/**
	 * 查询我的志愿者团队列表
	 */
	public List<Map<String,Object>> queryVolunteerTeamListForMy(String user_id){
		return volunteerTeamMapper.queryVolunteerTeamListForMy(user_id);
	}
}
