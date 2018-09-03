package com.lzs.service;

import com.lzs.exception.BusinessException;

public interface AuthenticationService {
	/**
	 * 新增实名认证
	 * @throws BusinessException 
	 */
	public int addAuthentication(String name,String card_number,String user_id) throws BusinessException;
}
