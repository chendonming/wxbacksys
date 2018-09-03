package com.lzs.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.Evaluate;
import com.lzs.model.User;
import com.lzs.service.EvaluateService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/evaluate")
@RestController
public class EvaluateController extends BaseController{
	@Autowired
	private EvaluateService evaluateService;
	
	@RequestMapping("/addEvaluate")
	public ReturnResult addEvaluate(Evaluate evaluate){
		User user = this.getUser();
		evaluate.setUser_id(user.getUuid());
		int i = evaluateService.addEvaluate(evaluate);
		return ReturnResult.success(i);
	}
	
	@RequestMapping("/queryEvaluateList")
	public ReturnResult queryEvaluateList(String volunteer_team_id,int pageNum ,int pageSize){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("volunteer_team_id", volunteer_team_id);
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list =evaluateService.queryEvaluateListByParam(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	@RequestMapping("/queryEvaluate")
	public ReturnResult queryEvaluate(String uuid){
		Map<String,Object>  map = evaluateService.queryEvaluate(uuid);
		return ReturnResult.success(map);
	}
	
	@RequestMapping("/queryMarkForTeam")
	public ReturnResult queryMarkForTeam(String volunteer_team_id){
		if(StringUtils.isEmpty(volunteer_team_id)){
			return ReturnResult.error("志愿者团队id不能为空！");
		}
		Map<String,Object> map =evaluateService.queryStarNumberByTeam(volunteer_team_id);
		Integer star_levels = map.get("star_levels")==null?0:Integer.valueOf(map.get("star_levels").toString());
		Integer number = map.get("number")==null?0:Integer.valueOf(map.get("number").toString());
		if(number==0){
			return ReturnResult.success(100);
		}
		double f1 = new BigDecimal((float)star_levels/number).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
		f1 = f1*20;
		return ReturnResult.success(f1);
	}
}
