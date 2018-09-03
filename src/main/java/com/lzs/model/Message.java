package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//标题
	private String title;
	
	//内容
	private String content;
	
	//用户user_id
	private String user_id;
	
	//状态（1：未读 2：已读)
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
