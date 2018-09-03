package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lzs.dao.EvaluateMapper;
import com.lzs.model.Evaluate;
import com.lzs.service.EvaluateService;
import com.lzs.utils.IDUtils;

@Service
public class EvaluateServiceImpl implements EvaluateService{
	@Autowired
	private EvaluateMapper evaluateMapper;
	
	/**
	 * 发布评价
	 */
	public int addEvaluate(Evaluate evaluate){
		String uuid = IDUtils.genId();
		evaluate.setUuid(uuid);
		return evaluateMapper.addEvaluate(evaluate);
	}
	
	/**
	 * 查询评价列表
	 */
	public List<Map<String,Object>> queryEvaluateListByParam(Map<String,Object> paramMap){
		return evaluateMapper.queryEvaluateListByParam(paramMap);
	}
	
	/**
	 * 查询评价详情
	 */
	public Map<String,Object> queryEvaluate(String uuid){
		return evaluateMapper.queryEvaluate(uuid);
	}
	
	/**
	 * 统计志愿者团队星数
	 */
	public Map<String,Object> queryStarNumberByTeam(String volunteer_team_id){
		return evaluateMapper.queryStarNumberByTeam(volunteer_team_id);
	}
}
