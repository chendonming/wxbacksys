package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

public class Authentication implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//用户ID
	private String user_id;
	
	//居民id
	private String resident_id;
	
	//认证姓名
	private String name;
	
	//认证身份证号码
	private String card_number;
	
	//创建时间
	private Date create_time;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getResident_id() {
		return resident_id;
	}

	public void setResident_id(String resident_id) {
		this.resident_id = resident_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
}
