package com.lzs.service;

import java.util.Map;

public interface HotlineService {
	/**
	 * 查询热线
	 */
	public Map<String,Object> queryHotline();
	
	/**
	 * 修改热线
	 */
	public int updateHotline(Map<String,Object> paramMap);
}
