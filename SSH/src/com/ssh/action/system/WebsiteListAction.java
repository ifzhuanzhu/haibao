package com.ssh.action.system;

import java.util.List;

import javax.annotation.Resource;

import com.ssh.comm.action.BaseAction;
import com.ssh.dao.website.WebSiteDao;
import com.ssh.entity.website.WebSite;

public class WebsiteListAction  extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Resource
	private WebSiteDao webSiteDao;
	
	private List<WebSite> webSites;
	
	public String execute()
	{
		webSites = webSiteDao.findAll();
		return SUCCESS;
	}

	public List<WebSite> getWebSites() {
		return webSites;
	}

	public void setWebSites(List<WebSite> webSites) {
		this.webSites = webSites;
	}
	
}
