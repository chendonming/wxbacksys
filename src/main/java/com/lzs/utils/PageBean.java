package com.lzs.utils;

public class PageBean {

	private int pageNum ;
	
	private int pageSize ;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum == 0 ? null : pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize == 0 ? null : pageSize;
	}
	
	
}
