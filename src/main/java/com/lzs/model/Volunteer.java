package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 志愿者
 */
public class Volunteer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	//用户id
	private String user_id;
	
	//志愿者姓名
	private String name;
	
	//性别（1：男 2 女）
	private Integer sex;
	
	//出生日期
	private String birthday;
	
	//教育程度(1:中专及以下  2：大专 3：本科 4：本科以上)
	private Integer educational_level;
	
	//身份(1:学生 2：在职 3：待业 4其他)
	private Integer identity;
	
	//学校名称
	private String school_name;
	
	//专业/班级
	private String major_class;
	
	//所属行业
	private String industry;
	
	//是否参与义务服务（1：有  2 否）
	private Integer is_duty;
	
	//服务时间(1:工作日 2：周末)
	private Integer service_time;
	
	//联系电话
	private String phone;
	
	//居住地
	private String domicile;
	
	//状态（1：待审批  2：已加入  3：失败 4：退出待审核 5：已退出）
	private Integer stauts;
	
	//所属志愿者团队
	private String volunteer_team_id;
	
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getEducational_level() {
		return educational_level;
	}

	public void setEducational_level(Integer educational_level) {
		this.educational_level = educational_level;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getMajor_class() {
		return major_class;
	}

	public void setMajor_class(String major_class) {
		this.major_class = major_class;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getIs_duty() {
		return is_duty;
	}

	public void setIs_duty(Integer is_duty) {
		this.is_duty = is_duty;
	}

	public Integer getService_time() {
		return service_time;
	}

	public void setService_time(Integer service_time) {
		this.service_time = service_time;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public Integer getStauts() {
		return stauts;
	}

	public void setStauts(Integer stauts) {
		this.stauts = stauts;
	}

	public String getVolunteer_team_id() {
		return volunteer_team_id;
	}

	public void setVolunteer_team_id(String volunteer_team_id) {
		this.volunteer_team_id = volunteer_team_id;
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
