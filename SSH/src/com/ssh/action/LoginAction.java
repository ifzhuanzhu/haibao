package com.ssh.action;

//import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.ssh.comm.GlobalConstants;
import com.ssh.comm.action.BaseAction;
import com.ssh.dao.system.AdminDao;
import com.ssh.entity.system.Admin;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	AdminDao adminDao;
	
	private String loginName;
	private String passWord;
	
	public String execute() {
		if(loginName==null){
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if(cookies != null){
				for (Cookie cookie : cookies) {
					if("web.cookie.loginName".equals(cookie.getName())){
						loginName=cookie.getValue();//URLDecoder.decode(cookie.getValue(), "UTF-8");
					}
				}
			}
		}
		return "success";
	}
	
	public String login() {
		Admin admin = adminDao.AttemptLogin(loginName, passWord);
		if(admin != null)
		{
			Cookie cookie = new Cookie(GlobalConstants.SESSION_ADMIN_KEY, "");
			cookie.setMaxAge(Integer.MAX_VALUE);
			cookie.setValue(loginName);
			ServletActionContext.getResponse().addCookie(cookie);
			ServletActionContext.getRequest().getSession().setAttribute(GlobalConstants.SESSION_ADMIN_KEY, admin);
			
			String redirectUrl=ServletActionContext.getRequest().getParameter("redirectUrl");
			setRedirectUrl(redirectUrl);
			return FORWARD;
		}
		return SUCCESS;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
