package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

public class VolunteerTeamPicture implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//志愿者团队uuid
	private String volunteer_team_id;
	
	//图片名称
	private String name;
	
	//图片url地址
	private String url;
	
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

	public String getVolunteer_team_id() {
		return volunteer_team_id;
	}

	public void setVolunteer_team_id(String volunteer_team_id) {
		this.volunteer_team_id = volunteer_team_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
