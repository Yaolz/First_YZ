package com.yz.ServiceCustomer;

import java.util.List;

import com.yz.DaoCustomer.AppointDAO;
import com.yz.DaoCustomer.AppointDAOImpl;
import com.yz.bean.Appointment;

public class AppointServiteImpl implements AppointServite{

	private AppointDAO appdao;
	
	public AppointServiteImpl() {
		appdao = new AppointDAOImpl();
	}
	
	@Override
	public void add(Appointment t) {
		appdao.add(t);
	}

	@Override
	public void delete(String id) {
		appdao.delete(id);
	}

	@Override
	public void update(Appointment t) {
		appdao.update(t);
	}

	@Override
	public void update_pwd(Appointment t) {
		appdao.update_pwd(t);
	}

	@Override
	public void update_status(Appointment t) {
		appdao.update_status(t);
	}

	@Override
	public List<Appointment> queryAll() {
		return appdao.queryAll();
	}

	@Override
	public List<Appointment> queryByPager(int pageNo, int pageSize) {
		return appdao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Appointment queryById(String id) {
		return appdao.queryById(id);
	}

	@Override
	public int count() {
		return appdao.count();
	}

	@Override
	public List<Appointment> queryPagerByUserId(int pageNo, int pageSize, String customerid) {
		return appdao.queryPagerByUserId(pageNo, pageSize, customerid);
	}

	@Override
	public List<Appointment> queryPagerByCompany(int pageNo, int pageSize, String companyid) {
		return appdao.queryPagerByCompany(pageNo, pageSize, companyid);
	}

	@Override
	public Appointment queryApped(String cusid, String companyid) {
		return appdao.queryApped(cusid, companyid);
	}

}
