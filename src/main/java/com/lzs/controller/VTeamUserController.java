package com.lzs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.util.StringUtils;
import com.lzs.model.VTeamUser;
import com.lzs.service.VTeamUserService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/vteamuser")
@RestController
public class VTeamUserController extends BaseController{
	@Autowired
	private VTeamUserService vTeamUserService;
	
	@RequestMapping("/addVTeamUser")
	public ReturnResult addVTeamUser(VTeamUser vTeamUser){
		String volunteer_team_id = vTeamUser.getVolunteer_team_id();
		String user_id = vTeamUser.getUser_id();
		if(StringUtils.isEmpty(volunteer_team_id)){
			return ReturnResult.error("志愿者团队id不能为空！");
		}
		if(StringUtils.isEmpty(user_id)){
			return ReturnResult.error("用户id不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("volunteer_team_id", volunteer_team_id);
		paramMap.put("user_id", user_id);
		Map<String,Object> map = vTeamUserService.queryVTeamUserByUserAndTeam(paramMap);
		if(map!=null && map.size()>0){
			return ReturnResult.error("已经是该志愿者团队管理员了！");
		}
		int i = vTeamUserService.addVTeamUser(vTeamUser);
		return ReturnResult.success(i);
	}
	
	@RequestMapping("/deleteVTeamUser")
	public ReturnResult deleteVTeamUser(String volunteer_team_id,String user_id){
		if(StringUtils.isEmpty(volunteer_team_id)){
			return ReturnResult.error("志愿者团队id不能为空！");
		}
		if(StringUtils.isEmpty(user_id)){
			return ReturnResult.error("用户id不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("volunteer_team_id", volunteer_team_id);
		paramMap.put("user_id", user_id);
		int i =vTeamUserService.deleteVTeamUser(paramMap);
		return ReturnResult.success();
	}
	
	@RequestMapping("/queryVTeamUserList")
	public ReturnResult queryVTeamUserList(String volunteer_team_id){
		if(StringUtils.isEmpty(volunteer_team_id)){
			return ReturnResult.error("志愿者团队id不能为空！");
		}
		List<Map<String,Object>> list = vTeamUserService.queryVTeamUserList(volunteer_team_id);
		return ReturnResult.success(list);
	}
	
}
