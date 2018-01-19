package com.yz.ServiceCustomer;

import java.util.List;

import com.yz.DaoCustomer.CustomerDAO;
import com.yz.DaoCustomer.CustomerDAOImpl;
import com.yz.bean.Customer;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO cusdao;
	
	public CustomerServiceImpl() {
		cusdao = new CustomerDAOImpl();
	}
	
	@Override
	public void add(Customer t) {
		cusdao.add(t);
	}

	@Override
	public void delete(String id) {
		cusdao.delete(id);
	}

	@Override
	public void update(Customer t) {
		cusdao.update(t);
	}

	@Override
	public List<Customer> queryAll() {
		return cusdao.queryAll();
	}

	@Override
	public List<Customer> queryByPager(int pageNo, int pageSize) {
		return cusdao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Customer queryById(String id) {
		return cusdao.queryById(id);
	}

	@Override
	public int count() {
		return cusdao.count();
	}

	@Override
	public List<Customer> queryByName(String name) {
		return cusdao.queryByName(name);
	}

	@Override
	public Customer queryByEmailPwd(String email, String password) {
		return cusdao.queryByEmailPwd(email, password);
	}

	@Override
	public void update_pwd(Customer t) {
		cusdao.update_pwd(t);
	}

	@Override
	public void update_status(Customer t) {
		cusdao.update_status(t);
		
	}

	@Override
	public void update_time(String id) {
		cusdao.update_time(id);
	}

}
