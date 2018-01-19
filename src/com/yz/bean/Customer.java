package com.yz.bean;

import java.sql.Date;

public class Customer {
	private String id;//编号
	private String email;//邮箱
	private String img;//头像
	private String password;//密码
	private String name;//名字
	private String phone;//手机
	private String plot_name;//小区名称
	private String address;//地址
	private Date created_time;//创建时间
	private Date last_login_time;//�?近一次登录时�?
	private String status;//是否可用，Y表示可用，N表示不可�?
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPlot_name() {
		return plot_name;
	}
	public void setPlot_name(String polt_name) {
		this.plot_name = polt_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adderss) {
		this.address = adderss;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
