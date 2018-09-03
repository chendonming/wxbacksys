package com.lzs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzs.model.BookingService;
import com.lzs.model.User;
import com.lzs.service.BookingServiceService;
import com.lzs.service.VTeamUserService;
import com.lzs.service.VolunteerTeamService;
import com.lzs.utils.ReturnResult;

@RequestMapping("/bookService")
@RestController
public class BookingServiceController extends BaseController{
	@Autowired
	private BookingServiceService bookingServiceService;
	@Autowired
	private VolunteerTeamService  volunteerTeamService;
	
	/**
	 * 新增预约服务
	 */
	@RequestMapping("/addBookingService")
	public ReturnResult addBookingService(BookingService bookingService){
		User user = this.getUser();
		Integer is_authentication =user.getIs_authentication();
		if(is_authentication !=1){
			return ReturnResult.error("没有实名认证！");
		}
		bookingService.setUser_id(user.getUuid());
		int i = bookingServiceService.addBookingService(bookingService);
		return ReturnResult.success(i);
	}
	
	/**
	 * 查询自己的预约服务列表
	 */
	@RequestMapping("/queryBookingServiceForMySelf")
	public ReturnResult queryBookingServiceForMySelf(int pageSize,int pageNum){
		User user = this.getUser();
		String user_id = user.getUuid();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("user_id", user_id);
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = bookingServiceService.queryBookingServiceListByParam(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages()); 
	}
	
	/**
	 * 查询需要预约服务管理列表
	 */
	@RequestMapping("/queryBookingServiceForTeam")
	public ReturnResult queryBookingServiceForTeam(int pageSize,int pageNum){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		User user = this.getUser();
		String user_id = user.getUuid();
		Integer role = user.getRole();
		if(role ==1){
			return ReturnResult.error("居民身份不能查询！");
		} else if(role ==2){
			List<Map<String,Object>> typelist = volunteerTeamService.queryTypeByUser(user_id);
			if(typelist==null || typelist.size()==0){
				return ReturnResult.error("没有管理的志愿者团队！");
			} else{
				StringBuffer sb = new StringBuffer();
				for(Map<String,Object> typeMap:typelist){
					sb.append(typeMap.get("type"));
					sb.append(",");
				}
				String str = sb.toString().trim();
				paramMap.put("types", (str.substring(0,str.length() - 1)).split(","));
			}
		}
		
		
		Page page = PageHelper.startPage(pageNum, pageSize);
		List<Map<String,Object>> list = bookingServiceService.queryBookingServiceListByParam(paramMap);
		return ReturnResult.pageOk(list, page.getTotal(), page.getPages()); 
	}
	
	/**
	 * 查询预约详情
	 */
	@RequestMapping("/queryBookingService")
	public ReturnResult  queryBookingService(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("预约详情id不能为空！");
		}
		Map<String,Object> map = bookingServiceService.queryBookingService(uuid);
		return ReturnResult.success(map);
	}
	
	/**
	 * 预约详情修改成已读
	 */
	@RequestMapping("/updateBookingServiceRead")
	public ReturnResult updateBookingServiceRead(String uuid){
		if(StringUtils.isEmpty(uuid)){
			return ReturnResult.error("预约详情id不能为空！");
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("uuid", uuid);
		paramMap.put("status", 2);
		int i = bookingServiceService.updateBookingServiceStatus(paramMap);
		return ReturnResult.success(i);
	}
}
