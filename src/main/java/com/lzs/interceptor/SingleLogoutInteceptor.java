package com.lzs.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lzs.service.UserService;

@Component
public class SingleLogoutInteceptor extends HandlerInterceptorAdapter {
	@Value("${effective.date}")
	private String date;
	@Autowired
	private  UserService userService;
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		 String sysDate =df.format(new Date());// new Date()为获取当前系统时间
		 Date a = df.parse(date);
		 Date b = df.parse(sysDate);
		 //当前系统日期小于设置有效日期则返回true
		 if(!b.before(a)){
			 return false;
		 }
		 String user_id = request.getHeader("user_id");
		 Map<String,Object> userMap = userService.queryUser(user_id);
		 if(userMap==null|| userMap.size()==0){
			 return false;
		 }
		 return true;
//		return super.preHandle(request, response, handler);
	}

}
