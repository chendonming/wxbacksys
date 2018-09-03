package com.lzs.service;

import java.util.List;
import java.util.Map;

import com.lzs.model.BookingService;

public interface BookingServiceService {
	/**
	 * 新增预约服务
	 */
	public int addBookingService(BookingService bookingService);
	
	/**
	 * 查询预约服务列表
	 */
	public List<Map<String,Object>> queryBookingServiceListByParam(Map<String,Object> paramMap);
	
	/**
	 * 查询预约详情
	 */
	public Map<String,Object> queryBookingService(String uuid);
	
	/**
	 * 修改预约状态
	 */
	public int updateBookingServiceStatus(Map<String,Object> paramMap);
}
