package com.lzs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.User;
import com.lzs.model.Volunteer;
import com.lzs.service.VolunteerService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/volunteer")
@RestController
public class VolunteerController extends BaseController{
	@Autowired
	private VolunteerService volunteerService;
	
	@RequestMapping("/addVolunteer")
	public ReturnResult addVolunteer(Volunteer volunteer){
		User user = this.getUser();
		String user_id = user.getUuid();
		volunteer.setUser_id(user_id);
		String volunteer_team_id = volunteer.getVolunteer_team_id();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("user_id", user_id);
		paramMap.put("volunteer_team_id", volunteer_team_id);
		int size = volunteerService.queryVolunteerCount(paramMap);
		if(size>0){
			return ReturnResult.error("已存在或已申请该志愿者团队！");
		}
		int i = volunteerService.addVolunteer(volunteer);
		return ReturnResult.success(i);
	}
	
	@RequestMapping("/queryVolunteerList")
	public ReturnResult queryVolunteerList(String volunteer_team_id, String stautss,int pageSize,int pageNum){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("volunteer_team_id", volunteer_team_id);
		if(!StringUtils.isEmpty(stautss)){
			paramMap.put("stautss", stautss.split(","));
		}
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = volunteerService.queryVolunteerListByParam(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	@RequestMapping("/queryVolunteer")
	public ReturnResult queryVolunteer(String uuid){
		Map<String,Object> map=volunteerService.queryVolunteer(uuid);
		return ReturnResult.success(map);
	}
	
	/**
	 * 志愿者申请审批通过
	 */
	@RequestMapping("/updateVolunteerStatusForPass")
	public ReturnResult updateVolunteerStatusForPass(String uuid,String team_name,String old_stauts){
		User user = this.getUser();
		String user_id = user.getUuid();
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("志愿者id不能为空!");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("stauts", 2);
		paramMap.put("old_stauts", old_stauts);
		paramMap.put("user_id", user_id);
		paramMap.put("team_name", team_name);
		int i = volunteerService.updateVolunteerStauts(paramMap);
		return ReturnResult.success(i);
	}
	
	/**
	 * 志愿者申请审批拒绝
	 */
	@RequestMapping("/updateVolunteerStatusForRefuse")
	public ReturnResult updateVolunteerStatusForRefuse(String uuid,String team_name,String old_stauts){
		User user = this.getUser();
		String user_id = user.getUuid();
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("志愿者id不能为空!");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("stauts", 3);
		paramMap.put("old_stauts", old_stauts);
		paramMap.put("user_id", user_id);
		paramMap.put("team_name", team_name);
		int i = volunteerService.updateVolunteerStauts(paramMap);
		return ReturnResult.success(i);
	}
	
	/**
	 * 志愿者申请退出
	 */
	@RequestMapping("/updateVolunteerStatusForBack")
	public ReturnResult updateVolunteerStatusForBack(String uuid,String team_name,String old_stauts){
		User user = this.getUser();
		String user_id = user.getUuid();
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("志愿者id不能为空!");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("stauts", 4);
		paramMap.put("old_stauts", old_stauts);
		paramMap.put("user_id", user_id);
		paramMap.put("team_name", team_name);
		int i = volunteerService.updateVolunteerStauts(paramMap);
		return ReturnResult.success(i);
	}
	
	/**
	 * 志愿者申请退出审批通过
	 */
	@RequestMapping("/updateVolunteerStatusForBackPass")
	public ReturnResult updateVolunteerStatusForBackPass(String uuid,String team_name,String old_stauts){
		User user = this.getUser();
		String user_id = user.getUuid();
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("志愿者id不能为空!");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("stauts", 5);
		paramMap.put("old_stauts", old_stauts);
		paramMap.put("user_id", user_id);
		paramMap.put("team_name", team_name);
		int i = volunteerService.updateVolunteerStauts(paramMap);
		return ReturnResult.success(i);
	}
	
	/**
	 * 志愿者申请退出审批拒绝
	 */
	@RequestMapping("/updateVolunteerStatusForBackRefuse")
	public ReturnResult updateVolunteerStatusForBackRefuse(String uuid,String team_name,String old_stauts){
		User user = this.getUser();
		String user_id = user.getUuid();
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("志愿者id不能为空!");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("stauts", 2);
		paramMap.put("old_stauts", old_stauts);
		paramMap.put("user_id", user_id);
		paramMap.put("team_name", team_name);
		int i = volunteerService.updateVolunteerStauts(paramMap);
		return ReturnResult.success(i);
	}
}
