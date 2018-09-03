package com.lzs.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzs.dao.BookingServiceMapper;
import com.lzs.model.BookingService;
import com.lzs.service.BookingServiceService;
import com.lzs.utils.IDUtils;

@Service                                          
public class BookingServiceServiceImpl implements BookingServiceService{
	@Autowired
	private BookingServiceMapper bookingServiceMapper;
	
	/**
	 * 新增预约服务
	 */
	public int addBookingService(BookingService bookingService){
		String uuid = IDUtils.genId();
		bookingService.setUuid(uuid);
		return bookingServiceMapper.addBookingService(bookingService);
	}
	
	/**
	 * 查询预约服务列表
	 */
	public List<Map<String,Object>> queryBookingServiceListByParam(Map<String,Object> paramMap){
		return bookingServiceMapper.queryBookingServiceListByParam(paramMap);
	}
	
	/**
	 * 查询预约详情
	 */
	public Map<String,Object> queryBookingService(String uuid){
		return bookingServiceMapper.queryBookingService(uuid);
	}
	
	/**
	 * 修改预约状态
	 */
	public int updateBookingServiceStatus(Map<String,Object> paramMap){
		return bookingServiceMapper.updateBookingServiceStatus(paramMap);
	}
}
