package com.example.demospringsecurity.domain;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Role {

	private String role;
	@Id
	private int roleId;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Role() {
	}
	public Role(String role, int roleId) {
		this.role = role;
		this.roleId = roleId;
	}
	
	
}
