package com.lzs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.User;
import com.lzs.service.MessageService;
import com.lzs.utils.ReturnResult;

@RestController
@RequestMapping("/message")
public class MessageController extends BaseController{
	private Logger log = Logger.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageService;
	
	/**
	 * 根据用户id查询消息列表
	 */
	@RequestMapping("/queryMessageList")
	public ReturnResult queryMessageList(int pageSize,int pageNum){
		User user = this.getUser();
		String user_id = user.getUuid();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("user_id", user_id);
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = messageService.queryMessageListByParam(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	/**
	 * 查询消息列表详情
	 */
	@RequestMapping("/queryMessage")
	public ReturnResult queryMessage(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("消息id不能为空！");
		}
		Map<String,Object> map = messageService.queryMessage(uuid);
		return ReturnResult.success(map);
	}
	
	/**
	 * 消息修改为已读
	 */
	@RequestMapping("/updateMessageForRead")
	public ReturnResult updateMessageForRead(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("消息id不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("flag", 2);
		int number =messageService.updateMessageFlag(paramMap);
		return ReturnResult.success(number);
	}
}
