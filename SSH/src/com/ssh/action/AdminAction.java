package com.ssh.action;

import javax.annotation.Resource;

import com.ssh.dao.system.AdminDao;
import com.ssh.entity.system.Admin;

public class AdminAction {
	
	@Resource
	private AdminDao adminDao;
	
	private String msg;
	
	public String execute() throws Exception {
		Admin admin = new Admin();
		admin.setAdminID(1);
		admin.setFirstName("Jack");
		admin.setLastName("DaoShen");
		admin.setLoginName("Taitanic");
		admin.setPassWord("Ticket2012");
		adminDao.save(admin);
		
		msg="OK";
		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
