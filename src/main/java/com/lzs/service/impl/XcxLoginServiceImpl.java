package com.lzs.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lzs.dao.UserMapper;
import com.lzs.exception.BusinessException;
import com.lzs.model.User;
import com.lzs.model.WxUser;
import com.lzs.service.XcxLoginService;
import com.lzs.utils.HttpClientUtil;
import com.lzs.utils.IDUtils;

import net.sf.json.JSONObject;

@Service
public class XcxLoginServiceImpl implements XcxLoginService{
	@Value("${appId}")
	private String appId;
	@Value("${secret}")
	private String secret;
	@Autowired
	private UserMapper userMapper;
	
	public Map<String,Object> login(WxUser wxUser) throws BusinessException {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		String code=wxUser.getCode();
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code";
		String data = HttpClientUtil.doGet(url, null);
		//解析相应内容（转换成json对象）
        JSONObject  json = JSONObject.fromObject(data);
        //用户的唯一标识（openid）
        String openid =String.valueOf(json.get("openid"));
        if(openid==null|| "".equals(openid)||"null".equals(openid)){
        	 throw new BusinessException("获取openid失败！");
        }
        Map<String,Object> userMap = userMapper.queryUserByOpenid(openid);
        if(userMap==null || userMap.size()==0){
        	User user = new User();
        	String uuid = IDUtils.genId();
        	user.setUuid(uuid);
        	user.setNick_name(wxUser.getNickName());
        	user.setHead_url(wxUser.getAvatarUrl());
        	user.setSex(wxUser.getGender());
        	user.setOpenid(openid);
        	user.setAppid(appId);
        	userMapper.addUser(user);
        	returnMap.put("user_id", uuid);
        	returnMap.put("role", 1);
        	returnMap.put("is_authentication", 2);
        } else{
        	returnMap.put("user_id", userMap.get("uuid").toString());
        	returnMap.put("role", userMap.get("role").toString());
        	returnMap.put("is_authentication", Integer.valueOf(userMap.get("is_authentication").toString()));
        }
        return returnMap; 
	}
}
