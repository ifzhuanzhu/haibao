package com.ssh.entity.system;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_user")
public class User implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length=15, nullable=false)
    private String loginname;
    
	@Column(length=15, nullable=false)
    private String username;
    
    @Column(length=60, nullable=false)
    private String password;
    
    @Column(length=15)
    private String remote_addr;
    
    private Integer login_status;
    
    private Date login_time;
        
    @Column(length=20)
    private String email;
    
    @Column(length=60)
    private String mailpass;
    
    @Column(name = "policeNum")
	private String policeNum;
    
   	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public String getRemote_addr() {
		return remote_addr;
	}
	public void setRemote_addr(String remoteAddr) {
		remote_addr = remoteAddr;
	}
	public Integer getLogin_status() {
		return login_status;
	}
	public void setLogin_status(Integer loginStatus) {
		login_status = loginStatus;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date loginTime) {
		login_time = loginTime;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailpass() {
		return mailpass;
	}
	public void setMailpass(String mailpass) {
		this.mailpass = mailpass;
	}
	
	public String getPoliceNum() {
		return policeNum;
	}
	public void setPoliceNum(String policeNum) {
		this.policeNum = policeNum;
	}
	
}