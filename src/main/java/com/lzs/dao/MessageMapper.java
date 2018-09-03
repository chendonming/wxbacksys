package com.lzs.dao;

import java.util.List;
import java.util.Map;

import com.lzs.model.Message;

public interface MessageMapper {
	/**
	 * 添加消息
	 */
	public int addMessage(Message message);
	
	/**
	 * 查询消息列表
	 */
	public List<Map<String,Object>> queryMessageListByParam(Map<String,Object> paramMap);
	
	/**
	 * 查询消息详情
	 */
	public Map<String,Object> queryMessage(String uuid);
	
	/**
	 * 修改消息状态 
	 */
	public int updateMessageFlag(Map<String,Object> paramMap);
}
