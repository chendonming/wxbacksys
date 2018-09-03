package com.lzs.model;

import java.io.Serializable;

public class WxUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//获取openid使用的code
	private String code;
	
	//微信昵称
	private String nickName;
	
	//微信性别
	private Integer gender;
	
	//微信头像
	private String avatarUrl;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
}
