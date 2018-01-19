package com.yz.DaoCustomer;

import java.util.List;

import com.yz.bean.Customer;
import com.yz.dao.BaseDAO;

public interface CustomerDAO extends BaseDAO<Integer,Customer>{

	public List<Customer> queryByName(String name);
	
	public Customer queryByEmailPwd(String email, String password);
	
	public void update_time(String id) ;
	
}
