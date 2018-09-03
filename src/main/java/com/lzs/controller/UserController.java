package com.lzs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.User;
import com.lzs.service.UserService;
import com.lzs.utils.ReturnResult;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 新增用户
	 */
	@RequestMapping("/addUser")
	public ReturnResult addUser(User user){
		String openid = user.getOpenid();
		if(StringUtils.isEmpty(openid)){
			return ReturnResult.error("小程序openid不能为空！");
		}
		int size = userService.addUser(user);
		return ReturnResult.success(size);
	}
	
	/**
	 * 查询用户列表
	 */
	@RequestMapping("/queryUserList")
	public ReturnResult queryUserList(String nick_name,String real_name,String phone,Integer sex,String card_number,Integer role,Integer is_authentication,int pageSize,int pageNum){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("nick_name", nick_name);
		paramMap.put("real_name", real_name);
		paramMap.put("phone", phone);
		paramMap.put("sex", sex);
		paramMap.put("card_number", card_number);
		paramMap.put("role", role);
		paramMap.put("is_authentication", is_authentication);
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = userService.queryUserList(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages());
	}
	
	/**
	 * 查询用户详情
	 */
	@RequestMapping("/queryUser")
	public ReturnResult queryUser(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("用户uuid不能为空！");
		}
		Map<String,Object> user = userService.queryUser(uuid);
		return ReturnResult.success(user);
	}
	
	/**
	 * 修改用户信息
	 */
	@RequestMapping("/updateUser")
	public ReturnResult updateUser(User user){
		if(StringUtils.isEmpty(user.getUuid())){
			return ReturnResult.error("用户uuid不能为空！"); 
		}
		int size = userService.updateUser(user);
		return ReturnResult.success(size);
	}
}
