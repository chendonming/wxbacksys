package com.lzs.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookingService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String uuid;
	
	//预约类型
	private String type;
	
	//预约类别
	private String book_type;
	
	//预约地点
	private String address;
	
	//预约时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date booking_time; 
	
	//联系电话
	private String phone;
	
	//备注
	private String remark;
	
	//预约人
	private String user_id;
	
	//状态 1：已读 2：未读
	private Integer status;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(Date booking_time) {
		this.booking_time = booking_time;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getBook_type() {
		return book_type;
	}

	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
}
