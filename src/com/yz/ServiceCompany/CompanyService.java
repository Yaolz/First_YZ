package com.yz.ServiceCompany;

import java.util.List;

import com.yz.bean.Company;
import com.yz.service.BaseService;

public interface CompanyService extends BaseService<Integer,Company>{

	public List<Company> queryByName(String name);
	
	public Company queryByEmailPwd(String email, String password);
	
	public void update_time(String id) ;
	
}
