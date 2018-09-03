package com.lzs.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lzs.dao.MessageMapper;
import com.lzs.model.Message;
import com.lzs.service.MessageService;
import com.lzs.utils.IDUtils;

@Service
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageMapper messageMapper;
	
	/**
	 * 添加消息
	 */
	public int addMessage(Message message){
		String uuid = IDUtils.genId();
		message.setUuid(uuid);
		return messageMapper.addMessage(message);
	}
	
	/**
	 * 查询消息列表
	 */
	public List<Map<String,Object>> queryMessageListByParam(Map<String,Object> paramMap){
		return messageMapper.queryMessageListByParam(paramMap);
	}
	
	/**
	 * 查询消息详情
	 */
	public Map<String,Object> queryMessage(String uuid){
		return messageMapper.queryMessage(uuid);
	}
	
	/**
	 * 修改消息状态 
	 */
	public int updateMessageFlag(Map<String,Object> paramMap){
		return messageMapper.updateMessageFlag(paramMap);
	}
}
