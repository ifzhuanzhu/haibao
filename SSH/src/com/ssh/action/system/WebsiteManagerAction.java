package com.ssh.action.system;

import java.io.*;

import javax.annotation.Resource;

import com.ssh.comm.GlobalConstants;
import com.ssh.comm.action.BaseAction;
import com.ssh.dao.website.WebSiteDao;
import com.ssh.entity.website.WebSite;

public class WebsiteManagerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 16 * 1024 ;
	
	@Resource
	private WebSiteDao webSiteDao;
	
	private Integer id;
	private WebSite webSite;
	private File imageUpload;
	private String imageUploadFileName;
	private String imageUploadContentType;
	
	public String execute()
	{
		if(id!=null)
		{
			webSite = webSiteDao.get(id);
		}
		return SUCCESS;
	}
	
	public String edit()
	{
		webSite = webSiteDao.get(id);
		return SUCCESS;
	}
	
	public String save() throws Exception
	{
		try {
			if(imageUpload != null)
			{
				//ServletActionContext.getServletContext().getRealPath("\\image")
				File destFile= new File(GlobalConstants.PATH_WEBSTIE_IMAGE + imageUploadFileName);
				uploadFile(imageUpload, destFile);
				webSite.setImageUri(GlobalConstants.URI_WEBSTIE_IMAGE + imageUploadFileName);
			}
			webSiteDao.saveOrUpdate(webSite);
		} catch (Exception e) {
			throw e;
		}
		setRedirectUrl("/system/website-list.do");
		return FORWARD;
	}
	
	public String delete() throws Exception
	{
		webSiteDao.delete(id);
		
		setRedirectUrl("/system/website-list.do");
		return FORWARD;
	}
	
	public String cancel() throws Exception
	{
		setRedirectUrl("/system/website-list.do");
		return FORWARD;
	}
	
	private static void uploadFile(File src, File dst) throws Exception
	{
        try {
           InputStream in = null ;
           OutputStream out = null ;
            try {                
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
                while (in.read(buffer) > 0 ) {
                   out.write(buffer);
               } 
           } finally {
                if ( null != in) {
                   in.close();
               } 
                if ( null != out) {
                   out.close();
               } 
           } 
       } catch (Exception e) {
           throw e;
    	   //e.printStackTrace();
       } 
   }


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WebSite getWebSite() {
		return webSite;
	}

	public void setWebSite(WebSite webSite) {
		this.webSite = webSite;
	}

	public File getImageUpload() {
		return imageUpload;
	}

	public void setImageUpload(File imageUpload) {
		this.imageUpload = imageUpload;
	}

	public String getImageUploadFileName() {
		return imageUploadFileName;
	}

	public void setImageUploadFileName(String imageUploadFileName) {
		this.imageUploadFileName = imageUploadFileName;
	}

	public String getImageUploadContentType() {
		return imageUploadContentType;
	}

	public void setImageUploadContentType(String imageUploadContentType) {
		this.imageUploadContentType = imageUploadContentType;
	}	
}
