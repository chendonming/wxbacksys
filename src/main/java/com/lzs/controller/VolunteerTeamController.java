package com.lzs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.User;
import com.lzs.model.VolunteerTeam;
import com.lzs.service.VolunteerTeamService;
import com.lzs.utils.ReturnResult;

@RestController
@RequestMapping("/volunteerTeam")
public class VolunteerTeamController extends BaseController{
	@Autowired
	private VolunteerTeamService volunteerTeamService;
	
	/**
	 * 新增志愿者团队
	 */
	@RequestMapping("/addVolunteerTeam")
	public ReturnResult addVolunteerTeam(@RequestBody VolunteerTeam volunteerTeam){
		String type = volunteerTeam.getType();
		if(StringUtils.isEmpty(type)){
			return ReturnResult.error("志愿者团队类型不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("type", type);
		List<Map<String,Object>> list = volunteerTeamService.queryVolunteerTeamList(paramMap);
		if(list.size()>0){
			return ReturnResult.error("该类型的志愿者团队已存在！");
		}
		int i = volunteerTeamService.addVolunteerTeam(volunteerTeam);
		return ReturnResult.success(i);
	}
	
	/**
	 * 查询志愿者团队列表
	 */
	@RequestMapping("/queryVolunteerTeamList")
	public ReturnResult queryVolunteerTeamList(String name,Integer type,int pageSize,int pageNum){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("name", name);
		paramMap.put("type", type);
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = volunteerTeamService.queryVolunteerTeamList(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	
	/**
	 * 查询志愿者团队详情
	 */
	@RequestMapping("/queryVolunteerTeam")
	public ReturnResult queryVolunteerTeam(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("志愿者团队uuid不能为空！");
		}
		VolunteerTeam volunteerTeam = volunteerTeamService.queryVolunteerTeam(uuid);
		return ReturnResult.success(volunteerTeam);
	}
	
	/**
	 * 修改志愿者团队详情
	 */
	@RequestMapping("/updateVolunteerTeam")
	public ReturnResult updateVolunteerTeam(@RequestBody VolunteerTeam volunteerTeam){
		int i =volunteerTeamService.updateVolunteerTeam(volunteerTeam);
		return ReturnResult.success(i);
	}
	
	/**
	 * 根据服务类型查询志愿者团队详情
	 */
	@RequestMapping("/queryVolunteerTeamByType")
	public ReturnResult queryVolunteerTeamByType(String type){
		if(StringUtils.isEmpty(type)){
			return ReturnResult.error("类型id不能为空！");
		}
		VolunteerTeam volunteerTeam =volunteerTeamService.queryVolunteerTeamByType(type);
		return ReturnResult.success(volunteerTeam);
	}
	
	/**
	 * 查询我的志愿者团队
	 */
	@RequestMapping("/queryVolunteerTeamListForMy")
	public ReturnResult queryVolunteerTeamListForMy(int pageSize,int pageNum){
		User user = this.getUser();
		String user_id = user.getUuid();
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = volunteerTeamService.queryVolunteerTeamListForMy(user_id);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
}
