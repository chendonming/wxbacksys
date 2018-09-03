package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	private Integer star_level;
	
	private String content;
	
	private String user_id;
	
	private String volunteer_team_id;
	
	private Date create_time;
	
	private Date update_time;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getStar_level() {
		return star_level;
	}

	public void setStar_level(Integer star_level) {
		this.star_level = star_level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
