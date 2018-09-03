package com.lzs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VolunteerTeam implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//名称
	private String name;
	
	//类型
	private String type;
	
	//类型名称
	private String type_name;
	
	//服务类型
	private String service_type;
	
	//招募开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date recruit_starttime;
	
	//招募结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date recruit_endtime;
	
	//服务时间
	private String service_time;
	
	//加入方式
	private String join_type;
	
	//简介
	private String introduction;
	
	//创建时间
	private Date create_time;
	
	//修改时间
	private Date update_time;
	
	//图片集合
	private List<VolunteerTeamPicture> pictureList;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getRecruit_starttime() {
		return recruit_starttime;
	}

	public void setRecruit_starttime(Date recruit_starttime) {
		this.recruit_starttime = recruit_starttime;
	}

	public Date getRecruit_endtime() {
		return recruit_endtime;
	}

	public void setRecruit_endtime(Date recruit_endtime) {
		this.recruit_endtime = recruit_endtime;
	}

	public String getService_time() {
		return service_time;
	}

	public void setService_time(String service_time) {
		this.service_time = service_time;
	}

	public String getJoin_type() {
		return join_type;
	}

	public void setJoin_type(String join_type) {
		this.join_type = join_type;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

	public List<VolunteerTeamPicture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<VolunteerTeamPicture> pictureList) {
		this.pictureList = pictureList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
}
