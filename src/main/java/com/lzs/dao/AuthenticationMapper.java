package com.lzs.dao;

import com.lzs.model.Authentication;

public interface AuthenticationMapper {
	/**
	 * 新增实名认证
	 */
	public int addAuthentication(Authentication authentication);
}
