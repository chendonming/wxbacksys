package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzs.dao.MessageMapper;
import com.lzs.dao.VolunteerMapper;
import com.lzs.model.Message;
import com.lzs.model.Volunteer;
import com.lzs.service.VolunteerService;
import com.lzs.utils.IDUtils;

@Service
public class VolunteerServiceImpl implements VolunteerService{
	@Autowired
	private VolunteerMapper volunteerMapper;
	@Autowired
	private MessageMapper messageMapper;
	/**
	 * 申请成为志愿者
	 */
	public int addVolunteer(Volunteer volunteer){
		String uuid = IDUtils.genId();
		volunteer.setUuid(uuid);
		volunteer.setStauts(1);
		return volunteerMapper.addVolunteer(volunteer);
	}
	
	/**
	 * 志愿者列表查询
	 */
	public List<Map<String,Object>> queryVolunteerListByParam(Map<String,Object> paramMap){
		return volunteerMapper.queryVolunteerListByParam(paramMap);
	}
	
	/**
	 * 查询志愿者详情
	 */
	public Map<String,Object> queryVolunteer(String uuid){
		return volunteerMapper.queryVolunteer(uuid);
	}
	
	/**
	 * 修改志愿者状态
	 */
	@Transactional
	public int updateVolunteerStauts(Map<String,Object> paramMap){
		String user_id = paramMap.get("user_id").toString();
		String stauts = paramMap.get("stauts").toString();
		String old_stauts = paramMap.get("old_stauts").toString();
		String team_name = paramMap.get("team_name").toString();
		String uuid = IDUtils.genId();
		Message message = new Message();
		message.setUuid(uuid);
		message.setFlag(1);
		message.setUser_id(user_id);
		if("2".equals(stauts)&& "1".equals(old_stauts)){
			message.setTitle("志愿者申请");
			message.setContent("恭喜你，"+team_name+"审批通过！");
		} else if("2".equals(stauts)&& "4".equals(old_stauts)){
			message.setTitle("志愿者退出申请");
			message.setContent("对不起，"+team_name+"拒绝了您的申请！");
		} else if("3".equals(stauts)){
			message.setTitle("志愿者申请");
			message.setContent("对不起，"+team_name+"拒绝了您的加入！");
		} else if("5".equals(stauts)){
			message.setTitle("志愿者退出申请");
			message.setContent("您好，"+team_name+"已成功退出！");
		}
		if(!"4".equals(stauts)){
			messageMapper.addMessage(message);
		}
		return volunteerMapper.updateVolunteerStauts(paramMap);
	}
	
	/**
	 * 查询是否已申请过志愿者
	 */
	public int queryVolunteerCount(Map<String,Object> paramMap){
		return volunteerMapper.queryVolunteerCount(paramMap);
	}
}
