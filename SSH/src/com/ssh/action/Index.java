package com.ssh.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ssh.entity.system.Admin;

public class Index {
	public String execute() {
		Configuration conf = new Configuration();
		@SuppressWarnings("deprecation")
		SessionFactory sf= conf.buildSessionFactory();
		Session session = sf.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Admin admin = new Admin();
		admin.setAdminID(1);
		admin.setFirstName("W");
		admin.setLastName("NN");
		admin.setLoginName("admin");
		admin.setPassWord("pwd");
		session.save(admin);
		
		transaction.commit();
		
		System.out.print("hello");
		return "success";
	}
}
