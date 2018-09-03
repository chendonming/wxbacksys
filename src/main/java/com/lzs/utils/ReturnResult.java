package com.lzs.utils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 自定义响应结构
 *  200 业务办理成功
 *  300 业务办理失败(业务逻辑处理层)
 *  400 业务参数错误(接口参数错误)
 *  999 业务办理异常(数据库方面的异常)
 */
public class ReturnResult implements Serializable{


	private static final long serialVersionUID = -4254726102616289056L;
	
	// 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    
    //分页时使用
    private long total;//总条数
    
    private int pages; //总页数
    
    /**
     * 办理业务成功(有返回信息和数据)
     * @param msg
     * @param data
     * @return
     */
    public static ReturnResult success(String msg ,Object data){
    	return new ReturnResult(200,msg ,data);
    	
    }
    
    
    /**
     * 办理业务成功(只返回数据，无信息)
     * @param msg
     * @param data
     * @return
     */
    public static ReturnResult success(Object data){
    	return new ReturnResult(200,null ,data);
    	
    }
    
    /**
     * 办理业务成功(只返回状态码)
     * @param msg
     * @param data
     * @return
     */
    public static ReturnResult success(){
    	return new ReturnResult(200,null ,null);
    	
    }
    
    /**
     * 返回数据和相应的分页信息
     * @param data
     * @param total
     * @param pages
     * @author lzs
     */
    public static ReturnResult pageOk(String msg, Object data,long total,int pages){
    	return new ReturnResult(200,msg ,data,total,pages);
    }
    
    /**
     * 返回数据和相应的分页信息
     * @param data
     * @param total
     * @param pages
     * @author lzs
     */
    public static ReturnResult pageOk( Object data,long total,int pages){
    	return new ReturnResult(200,null ,data,total,pages);
    }
    
    /**
     * 办理业务失败
     * @param msg
     * @param data
     * @return
     */
    public  static  ReturnResult fail(String msg){
    	return new ReturnResult(300,msg,new ArrayList());
    }
    
    /**
     * 办理业务失败
     * @param msg
     * @param data
     * @return
     */
    public  static  ReturnResult fail(String msg ,Object data){
    	return new ReturnResult(300,msg ,data);
    }
    
    /**
     *desc: 参数错误
     *param:@param msg
     *param:@return
     *author:fangh
     *date:下午4:58:56
     */
    public static ReturnResult error(String msg) {
        return new ReturnResult(400,msg,null);
    }
    
    /**
     *desc: 插入数据出现异常或者运行时产生的异常
     *param:@param msg
     *param:@return
     *author:fangh
     *date:下午4:58:56
     */
    public static ReturnResult exception(String msg) {
        return new ReturnResult(999,msg, new ArrayList());
    }
    
   

    public ReturnResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public ReturnResult(Integer status, String msg, Object data,String session) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    public ReturnResult(Integer status  ,String msg ,Object data,long total , int pages) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.total = total;
        this.pages=pages;
    }

    public ReturnResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	
	

}
