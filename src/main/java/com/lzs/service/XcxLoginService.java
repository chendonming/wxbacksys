package com.lzs.service;


import java.util.Map;

import com.lzs.exception.BusinessException;
import com.lzs.model.WxUser;

public interface XcxLoginService {
	/**
	 *小程序登陆
	 */
	public Map<String,Object> login(WxUser wxUser) throws BusinessException;
}
