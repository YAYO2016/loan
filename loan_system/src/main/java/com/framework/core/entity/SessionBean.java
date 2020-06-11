package com.framework.core.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SessionBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//用户编码     
	private String userId="";
	//用户编码     
	private String userName="";
	//地区编码
	private String areaId="";
	//用户状态：有效,失效
	private String userStatus="";
	//组织机构编码
	private String orgId=""; 
	//组织机构名称
	private String orgName=""; 
	//登录方式
	private String login = "login" ; 
	//手机号码
	private String msisdn = ""; 
	//当前主机ip
	private String localAddr = ""; 
	//当前主机端口
	private int localPort = 9099; 
	//当前主机名
	private String localName = ""; 

	//权限MAP
	private Map<String,String> roleMap = new HashMap<String, String>();
	private Map<String,String> menuMap = new HashMap<String, String>();
	private Map<String,String> funcMap = new HashMap<String, String>();
	
	public Map<String, String> getMenuMap() {
		return menuMap;
	}
	public void setMenuMap(Map<String, String> menuMap) {
		this.menuMap = menuMap;
	}
	public Map<String, String> getFuncMap() {
		return funcMap;
	}
	public void setFuncMap(Map<String, String> funcMap) {
		this.funcMap = funcMap;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	public Map<String, String> getRoleMap() {
		return roleMap;
	}
	public void setRoleMap(Map<String, String> roleMap) {
		this.roleMap = roleMap;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public String getLocalAddr() {
		return localAddr;
	}
	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}
	public int getLocalPort() {
		return localPort;
	}
	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
}
