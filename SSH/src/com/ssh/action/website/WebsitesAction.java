package com.ssh.action.website;

import java.util.List;

import javax.annotation.Resource;

import com.ssh.comm.action.BaseAction;
import com.ssh.dao.website.WebSiteDao;
import com.ssh.entity.website.WebSite;

public class WebsitesAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private WebSiteDao webSiteDao;
	
	private List<WebSite> webSites;
	private String teString;
	
	public String execute()
	{
		webSites = webSiteDao.findAll();
		setTeString("hello OGNL!");
		return SUCCESS;
	}

	public List<WebSite> getWebSites() {
		return webSites;
	}

	public void setWebSites(List<WebSite> webSites) {
		this.webSites = webSites;
	}

	public String getTeString() {
		return teString;
	}

	public void setTeString(String teString) {
		this.teString = teString;
	}
}
