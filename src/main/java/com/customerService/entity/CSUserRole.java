package com.customerService.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CSuserRole")
public class CSUserRole implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RoleId")
	private String roleId;

	@Column(name="BrokerUserName")
	private String brokerUserName;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getBrokerUserName() {
		return brokerUserName;
	}

	public void setBrokerUserName(String brokerUserName) {
		this.brokerUserName = brokerUserName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
