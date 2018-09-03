package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

public class Resident implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//姓名
	private String name;
	
	//联系电话
	private String phone;
	
	//身份证号码
	private String card_number;
	
	//(性别 1：男 2：女)
	private Integer sex;
	
	//是否有效（1：有效 2：无效）
	private Integer flag;
	
	//创建时间
	private Date create_time;
	
	//修改时间
	private Date update_time;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
}
