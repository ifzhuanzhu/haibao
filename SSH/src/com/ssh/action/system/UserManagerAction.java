package com.ssh.action.system;

import java.util.List;

import javax.annotation.Resource;

import com.ssh.comm.action.BaseAction;
import com.ssh.dao.system.AdminDao;
import com.ssh.entity.system.Admin;

public class UserManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private AdminDao adminDao;
	
	private List<Admin> admins;

	@Override
	public String execute() throws Exception {
		admins = adminDao.findAll();
		return super.execute();
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	
	
}
