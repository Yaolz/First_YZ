package com.yz.ServiceAdimin;

import java.util.List;

import com.yz.DaoAdmin.AdminDAO;
import com.yz.DaoAdmin.AdminDAOImpl;
import com.yz.bean.Admin;

public class AdminServiceImpl implements AdminService{

	private AdminDAO admindao;
	
	public AdminServiceImpl() {
		admindao = new AdminDAOImpl();
	}
	
	@Override
	public void add(Admin t) {
		admindao.add(t);
	}

	@Override
	public void delete(String id) {
		admindao.delete(id);
	}

	@Override
	public void update(Admin t) {
		admindao.update(t);
	}
	
	@Override
	public List<Admin> queryAll() {
		return admindao.queryAll();
	}

	@Override
	public List<Admin> queryByPager(int pageNo, int pageSize) {
		return admindao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Admin queryById(String id) {
		return admindao.queryById(id);
	}

	@Override
	public int count() {
		return admindao.count();
	}

	@Override
	public List<Admin> queryByName(String name) {
		return admindao.queryByName(name);
	}

	@Override
	public Admin queryByEmailPwd(String email, String password) {
		return admindao.queryByEmailPwd(email, password);
	}

	@Override
	public void update_pwd(Admin t) {
		admindao.update_pwd(t);
	}

	@Override
	public void update_status(Admin t) {
		admindao.update_status(t);
		
	}

	@Override
	public void update_time(String id) {
		admindao.update_time(id);
	}

}
