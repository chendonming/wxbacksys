package com.lzs.dao;

import com.lzs.model.VolunteerTeamPicture;

public interface VolunteerTeamPictureMapper {
	/**
	 * 新增志愿者团队图片
	 */
	public int addVolunteerTeamPicture(VolunteerTeamPicture volunteerTeamPicture);
	
	/**
	 * 删除志愿者团队图片
	 */
	public int deleteVolunteerTeamPicture(String volunteer_team_id);
}
