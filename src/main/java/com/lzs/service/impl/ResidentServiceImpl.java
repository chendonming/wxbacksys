package com.lzs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzs.dao.ResidentMapper;
import com.lzs.model.Resident;
import com.lzs.service.ResidentService;
import com.lzs.utils.IDUtils;

@Service
public class ResidentServiceImpl implements ResidentService{
	@Autowired
	private ResidentMapper residentMapper;
	
	/**
	 * 新增居民用户
	 * @throws Exception 
	 */
	public int addResident(Resident resident) throws Exception{
		String card_number = resident.getCard_number();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("card_number", card_number);
		Resident resident1 = residentMapper.queryResidentByNameAndCard(paramMap);
		if(resident1!=null){
			throw new Exception("身份证号码已存在！");
		}
		String uuid = IDUtils.genId();
		resident.setUuid(uuid);
		return residentMapper.addResident(resident);
	}
	
	/**
	 * 查询居民用户列表
	 */
	public List<Map<String,Object>> queryResidentList(Map<String,Object> paramMap){
		return residentMapper.queryResidentList(paramMap);
	}
	
	/**
	 * 查询居民信息
	 */
	public Map<String,Object> queryResident(String uuid){
		return residentMapper.queryResident(uuid);
	}
	

	/**
	 * 根据身份证修改居民
	 */
	public int updateResident(Resident resident){
		return residentMapper.updateResidentByNameAndCard(resident);
	}
}
