package com.yz.ServiceCustomer;

import java.util.List;

import com.yz.bean.Appointment;
import com.yz.service.BaseService;

public interface AppointServite extends BaseService<Integer,Appointment>{

public List<Appointment> queryPagerByUserId(int pageNo, int pageSize, String customerid);
	
	public List<Appointment> queryPagerByCompany(int pageNo, int pageSize, String companyid);
	
	public Appointment queryApped(String cusid,String companyid);
}
