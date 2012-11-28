package com.ssh.dao.website;

import org.springframework.stereotype.Repository;

import com.ssh.comm.dao.BaseDaoBean;
import com.ssh.entity.website.WebSite;

@Repository
public class WebSiteDaoBean extends BaseDaoBean<WebSite, Integer> implements WebSiteDao {

}
