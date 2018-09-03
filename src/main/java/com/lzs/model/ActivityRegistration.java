package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

public class ActivityRegistration implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//活动id
	private String activity_id;
	
	//用户id
	private String user_id;
	
	//姓名
	private String name;
	
	//年龄
	private String age;
	
	//住址
	private String address;
	
	//电话号码
	private String phone;
	
	//人数
	private Integer people_number;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPeople_number() {
		return people_number;
	}

	public void setPeople_number(Integer people_number) {
		this.people_number = people_number;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}