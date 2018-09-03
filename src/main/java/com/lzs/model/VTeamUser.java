package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

public class VTeamUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//志愿者团队id
	private String volunteer_team_id;
	
	//用户id
	private String user_id;
		
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

	public String getVolunteer_team_id() {
		return volunteer_team_id;
	}

	public void setVolunteer_team_id(String volunteer_team_id) {
		this.volunteer_team_id = volunteer_team_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
