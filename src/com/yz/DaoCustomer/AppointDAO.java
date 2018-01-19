package com.yz.DaoCustomer;

import java.util.List;

import com.yz.bean.Appointment;
import com.yz.dao.BaseDAO;

public interface AppointDAO extends BaseDAO<Integer,Appointment>{

	public List<Appointment> queryPagerByUserId(int pageNo, int pageSize, String customerid);
	
	public List<Appointment> queryPagerByCompany(int pageNo, int pageSize, String companyid);
	
	public Appointment queryApped(String cusid,String companyid);
}
