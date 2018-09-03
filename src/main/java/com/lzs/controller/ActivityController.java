package com.lzs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.Activity;
import com.lzs.model.User;
import com.lzs.service.ActivityRegistrationService;
import com.lzs.service.ActivityService;
import com.lzs.utils.ReturnResult;

@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController{
	private Logger log = Logger.getLogger(ActivityController.class);
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityRegistrationService activityRegistrationService;
	
	/**
	 * 发布活动
	 */
	@RequestMapping("/addActivity")
	public ReturnResult addActivity(Activity activity){
		int number = activityService.addActivity(activity);
		return ReturnResult.success(number);
	}
	
	/**
	 * 根据志愿者团队查询活动列表
	 */
	@RequestMapping("/queryActivityListByVolunteerTeam")
	public ReturnResult  queryActivityListByVolunteerTeam(String volunteer_team_id,int pageNum,int pageSize){
		if(StringUtils.isEmpty(volunteer_team_id)){
			return ReturnResult.error("志愿者团体id不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("volunteer_team_id", volunteer_team_id);
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list =activityService.queryActivityListByParam(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	/**
	 * 查询活动详情
	 */
	@RequestMapping("/queryActivity")
	public ReturnResult queryActivity(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("活动id不能为空！");
		}
		Map<String,Object> map = activityService.queryActivity(uuid);
		Integer total = activityRegistrationService.queryActivityRegistrationTotalPeople(uuid);
		if(total==null){
			total = 0;
		}
		List<Map<String,Object>> nameList = activityRegistrationService.queryActivityRegistrationList(uuid);
		if(nameList==null){
			nameList = new ArrayList<Map<String,Object>>();
		}
		map.put("total", total);
		map.put("nameList",nameList);
		return ReturnResult.success(map);
	}
	
	/**
	 * 删除活动
	 */
	@RequestMapping("/deleteActivity")
	public ReturnResult deleteActivity(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("活动id不能为空！");
		}
		int i =  activityService.deleteActivity(uuid);
		return ReturnResult.success(i);
	}
	
	/**
	 * 修改活动
	 */
	@RequestMapping("/updateActivity")
	public ReturnResult updateActivity(Activity activity){
		String uuid = activity.getUuid();
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("活动id不能为空！");
		}
		int i = activityService.updateActivity(activity);
		return ReturnResult.success(i);
	}
	
	/**
	 * 我参与的活动
	 */
	@RequestMapping("/queryActivityForMyself")
	public ReturnResult queryActivityForMyself(int pageNum,int pageSize){
		User user = this.getUser();
		String user_id = user.getUuid();
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = activityService.queryActivityForMyself(user_id);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	/**
	 * 活动管理列表
	 */
	@RequestMapping("/queryActivityForManager")
	public ReturnResult queryActivityForManager(int pageNum,int pageSize,String volunteer_team_id){
		User user = this.getUser();
		String user_id = user.getUuid();
		Page page = PageHelper.startPage(pageNum, pageSize);

		Map<String,String> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("volunteer_team_id", volunteer_team_id);

		List<Map<String,Object>> list = activityService.queryActivityForManager(map);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
}
