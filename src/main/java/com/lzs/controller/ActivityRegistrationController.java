package com.lzs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.lzs.model.ActivityRegistration;
import com.lzs.model.User;
import com.lzs.service.ActivityRegistrationService;
import com.lzs.service.ActivityService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/activityregistration")
@RestController
public class ActivityRegistrationController extends BaseController{
	@Autowired
	private ActivityRegistrationService activityRegistrationService;
	@Autowired
	private ActivityService activityService;
	
	/**
	 * 活动报名
	 */
	@RequestMapping("/addActivityRegistration")
	public ReturnResult  addActivityRegistration(ActivityRegistration activityRegistration){
		Integer people_number = activityRegistration.getPeople_number();
		String activity_id = activityRegistration.getActivity_id();
		if(StringUtils.isEmpty(activity_id)){
			return ReturnResult.error("活动id不能为空！");
		}
		Integer numbers = activityRegistrationService.queryActivityRegistrationTotalPeople(activity_id);
		if(numbers==null){
			numbers=0;
		}
		Map<String,Object> activityNap =activityService.queryActivity(activity_id);
		int limit_people =Integer.valueOf(activityNap.get("limit_people").toString());
		if((people_number+numbers)>limit_people){
			return ReturnResult.error("超过人数限制不能报名！");
		}
		User user = this.getUser();
		activityRegistration.setUser_id(user.getUuid());
		int i = activityRegistrationService.addActivityRegistration(activityRegistration);
		return ReturnResult.success(i);
	}
	
	/**
	 * 查看报名用户的详情
	 */
	@RequestMapping("/queryActivityRegistration")
	public ReturnResult  queryActivityRegistration(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("报名id不能为空！");
		}
		Map<String,Object> map = activityRegistrationService.queryActivityRegistration(uuid);
		return ReturnResult.success(map);
	}
	
	/**
	 * 查询活动报名用户
	 */
	@RequestMapping("/queryActivityRegistrationList")
	public ReturnResult queryActivityRegistrationList(String activity_id){
		if(StringUtils.isEmpty(activity_id)){
			return ReturnResult.error("活动id不能为空！");
		}
		List<Map<String,Object>> list= activityRegistrationService.queryActivityRegistrationList(activity_id);
		return ReturnResult.success(list);
	}
}
