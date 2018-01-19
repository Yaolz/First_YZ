package com.yz.DaoAdmin;

import java.util.List;

import com.yz.bean.Admin;
import com.yz.dao.BaseDAO;

public interface AdminDAO extends BaseDAO<Integer,Admin>{

	public List<Admin> queryByName(String name);
	
	public Admin queryByEmailPwd(String email, String password);

	public void update_time(String id) ;
	
}
