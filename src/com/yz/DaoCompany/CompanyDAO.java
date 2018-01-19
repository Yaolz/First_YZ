package com.yz.DaoCompany;

import java.util.List;

import com.yz.bean.Company;
import com.yz.dao.BaseDAO;

public interface CompanyDAO extends BaseDAO<Integer,Company>{

	public List<Company> queryByName(String name);
	
	public Company queryByEmailPwd(String email, String password);
	
	public void update_time(String id) ;
}
