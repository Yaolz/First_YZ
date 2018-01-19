package com.yz.ServiceCustomer;

import java.util.List;

import com.yz.bean.Customer;
import com.yz.service.BaseService;

public interface CustomerService extends BaseService<Integer,Customer>{

	public List<Customer> queryByName(String name);
	
	public Customer queryByEmailPwd(String email, String password);
	
	public void update_time(String id) ;
}
