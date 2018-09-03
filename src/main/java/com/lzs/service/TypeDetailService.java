package com.lzs.service;

import java.util.List;
import java.util.Map;

import com.lzs.model.TypeDetail;

public interface TypeDetailService {
	/**
	 * 新增类型明细
	 */
	public int addTypeDetail(TypeDetail typeDetail);
	
	/**
	 * 查询类型明细列表
	 */
	public List<Map<String,Object>> queryTypeDetailByParam(Map<String,Object> paramMap);
	
	/**
	 * 修改类型明细
	 */
	public int updateTypeDetail(TypeDetail typeDetail);
	
	/**
	 * 删除类型明细
	 */
	public int deleteTypeDetail(String uuid);
	
	/**
	 * 查询类型明细
	 */
	public Map<String,Object> queryTypeDetail(String uuid);
	
	/**
	 * 根据类型编码查询类型明细
	 */
	public List<Map<String,Object>> queryTypeDetailByTypeCode(String code);
}
