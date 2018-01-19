package com.yz.ServiceAdimin;

import java.util.List;

import com.yz.bean.Admin;
import com.yz.service.BaseService;

public interface AdminService extends BaseService<Integer,Admin>{

	public List<Admin> queryByName(String name);
	
	public Admin queryByEmailPwd(String email, String password);
	
	public void update_time(String id) ;
}
