package com.ssh.entity.system;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_permission")
public class Permission {

	@Id
	private Integer permissionId;
	private String name;
	private String action;
	private String description;
	
	Integer getPermissionId() {
		return permissionId;
	}
	void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getAction() {
		return action;
	}
	void setAction(String action) {
		this.action = action;
	}
	String getDescription() {
		return description;
	}
	void setDescription(String description) {
		this.description = description;
	}
}
