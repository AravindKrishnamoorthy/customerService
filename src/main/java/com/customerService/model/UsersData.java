package com.customerService.model;

public class UsersData {
	
	private int user_Id;
	private int role_Id;
	private String name;
	private String companyName;
	private String username;
	private String password;
	private String client_BrokerName;
	private String CSuserRoleID;
	private String brokerUserName;
	
	public UsersData(Object[] obj) {
		user_Id = (int)obj[0];
		role_Id = (int)obj[1];
		name = (String)obj[2];
		companyName = (String)obj[3];
		username = (String)obj[4];
		password = (String)obj[5];
		client_BrokerName = (String)obj[6];
		CSuserRoleID = (String)obj[7];
		brokerUserName = (String)obj[8];
	}
	
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getRole_Id() {
		return role_Id;
	}
	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getClient_BrokerName() {
		return client_BrokerName;
	}
	public void setClient_BrokerName(String client_BrokerName) {
		this.client_BrokerName = client_BrokerName;
	}
	public String getCSuserRoleID() {
		return CSuserRoleID;
	}
	public void setCSuserRoleID(String cSuserRoleID) {
		CSuserRoleID = cSuserRoleID;
	}
	public String getBrokerUserName() {
		return brokerUserName;
	}
	public void setBrokerUserName(String brokerUserName) {
		this.brokerUserName = brokerUserName;
	}
	
}
