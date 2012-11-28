package com.ssh.dao.system;

import com.ssh.comm.dao.BaseDao;
import com.ssh.entity.system.Admin;

public interface AdminDao extends BaseDao<Admin, Integer> {

	public Admin AttemptLogin(String loginName, String passWord);
}
