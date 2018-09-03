package com.lzs.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzs.dao.HotlineMapper;
import com.lzs.service.HotlineService;

@Service
public class HotlineServiceImpl implements HotlineService{
	@Autowired
	private HotlineMapper hotlineMapper;
	
	/**
	 * 查询热线
	 */
	public Map<String,Object> queryHotline(){
		return hotlineMapper.queryHotline();
	}
	
	/**
	 * 修改热线
	 */
	public int updateHotline(Map<String,Object> paramMap){
		return hotlineMapper.updateHotline(paramMap);
	}
}
