package com.lzs.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lzs.utils.ReturnResult;

@ControllerAdvice  
public class GlobalExceptionHandler {

	private  static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(BusinessException.class)  
    @ResponseBody  
    public ReturnResult handleBizExp(HttpServletRequest request, Exception ex){  
        log.info("infoError",ex);
        return ReturnResult.fail(ex.getMessage());
    } 
	
	@ExceptionHandler(RuntimeException.class)  
    @ResponseBody  
    public ReturnResult runtimeExceptionHandler(RuntimeException runtimeException) {  
        log.error("runtimeException", runtimeException);
        log.info(runtimeException.getStackTrace());
        return ReturnResult.exception("程序执行出错，请联系管理员！");
    }
}
