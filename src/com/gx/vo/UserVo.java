package com.gx.vo;

import com.gx.po.User;

public class UserVo extends User{
	 private Integer powerid;

	 private Integer userid;

	 private String powername;

	public Integer getPowerid() {
		return powerid;
	}

	public void setPowerid(Integer powerid) {
		this.powerid = powerid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPowername() {
		return powername;
	}

	public void setPowername(String powername) {
		this.powername = powername;
	}
}
