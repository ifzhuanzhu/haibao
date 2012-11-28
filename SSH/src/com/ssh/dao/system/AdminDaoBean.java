package com.ssh.dao.system;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.comm.dao.BaseDaoBean;
import com.ssh.entity.system.Admin;

@Repository
public class AdminDaoBean extends BaseDaoBean<Admin, Integer> implements
		AdminDao {

	@Override
	@Transactional
	public Admin AttemptLogin(String loginName, String passWord) {
		java.util.List<Admin> list = findByCriteria(
				Restrictions.eq("loginName", loginName),
				Restrictions.eq("passWord", passWord));

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
