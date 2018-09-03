package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzs.dao.TypeDetailMapper;
import com.lzs.model.TypeDetail;
import com.lzs.service.TypeDetailService;
import com.lzs.utils.IDUtils;

@Service
public class TypeDetailServiceImpl implements TypeDetailService{
	@Autowired
	private TypeDetailMapper typeDetailMapper;
	
	/**
	 * 新增类型明细
	 */
	public int addTypeDetail(TypeDetail typeDetail){
		String uuid = IDUtils.genId();
		typeDetail.setUuid(uuid);
		return typeDetailMapper.addTypeDetail(typeDetail);
	}
	
	/**
	 * 查询类型明细列表
	 */
	public List<Map<String,Object>> queryTypeDetailByParam(Map<String,Object> paramMap){
		return typeDetailMapper.queryTypeDetailByParam(paramMap);
	}
	
	/**
	 * 修改类型明细
	 */
	public int updateTypeDetail(TypeDetail typeDetail){
		return typeDetailMapper.updateTypeDetail(typeDetail);
	}
	
	/**
	 * 删除类型明细
	 */
	public int deleteTypeDetail(String uuid){
		return typeDetailMapper.deleteTypeDetail(uuid);
	}
	
	/**
	 * 查询类型明细
	 */
	public Map<String,Object> queryTypeDetail(String uuid){
		return typeDetailMapper.queryTypeDetail(uuid);
	}
	
	/**
	 * 根据类型编码查询类型明细
	 */
	public List<Map<String,Object>> queryTypeDetailByTypeCode(String code){
		return typeDetailMapper.queryTypeDetailByTypeCode(code);
	}
}
