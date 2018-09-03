package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//昵称
	private String nick_name;
	
	//真实姓名
	private String real_name;
	
	//头像
	private String head_url;
	
	//性别（1：男 2：女）
	private Integer sex;
	
	//手机号码
	private String phone;
	
	//身份证号码
	private String card_number;
	
	//出生日期
	private String birthday;
	
	//居住地
	private String domicile;
	
	//职业
	private String vocation;
	
	//所属行业
	private String industry;
	
	//小程序openId
	private String openid;
	
	//应用id
	private String appid;
	
	//角色（1：普通用户  2：志愿者团队管理员  3:社区管理员）
	private Integer role;
	
	//是否实名认证（1：是 2：否）
	private Integer is_authentication;
	
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

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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

	public String getHead_url() {
		return head_url;
	}

	public void setHead_url(String head_url) {
		this.head_url = head_url;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getIs_authentication() {
		return is_authentication;
	}

	public void setIs_authentication(Integer is_authentication) {
		this.is_authentication = is_authentication;
	}
}
