package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 活动
 */
public class Activity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//活动名称
	private String name;
	
	//活动封面
	private String cover;
	
	//活动开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date activity_starttime;
	
	//活动结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date activity_endtime;
	
	//报名开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sign_starttime;
	
	//报名结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sign_endtime;
	
	//人数限制
	private String limit_people;
	
	//活动地点
	private String activity_place;
	
	//活动详情
	private String activity_detail;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Date getActivity_starttime() {
		return activity_starttime;
	}

	public void setActivity_starttime(Date activity_starttime) {
		this.activity_starttime = activity_starttime;
	}

	public Date getActivity_endtime() {
		return activity_endtime;
	}

	public void setActivity_endtime(Date activity_endtime) {
		this.activity_endtime = activity_endtime;
	}

	public Date getSign_starttime() {
		return sign_starttime;
	}

	public void setSign_starttime(Date sign_starttime) {
		this.sign_starttime = sign_starttime;
	}

	public Date getSign_endtime() {
		return sign_endtime;
	}

	public void setSign_endtime(Date sign_endtime) {
		this.sign_endtime = sign_endtime;
	}

	public String getLimit_people() {
		return limit_people;
	}

	public void setLimit_people(String limit_people) {
		this.limit_people = limit_people;
	}

	public String getActivity_place() {
		return activity_place;
	}

	public void setActivity_place(String activity_place) {
		this.activity_place = activity_place;
	}

	public String getActivity_detail() {
		return activity_detail;
	}

	public void setActivity_detail(String activity_detail) {
		this.activity_detail = activity_detail;
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
