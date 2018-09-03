package com.lzs.service;

import java.util.List;
import java.util.Map;

import com.lzs.model.Evaluate;

public interface EvaluateService {
	/**
	 * 发布评价
	 */
	public int addEvaluate(Evaluate evaluate);
	
	/**
	 * 查询评价列表
	 */
	public List<Map<String,Object>> queryEvaluateListByParam(Map<String,Object> paramMap);
	
	/**
	 * 查询评价详情
	 */
	public Map<String,Object> queryEvaluate(String uuid);
	
	/**
	 * 统计志愿者团队星数
	 */
	public Map<String,Object> queryStarNumberByTeam(String volunteer_team_id);
}
