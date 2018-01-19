package com.yz.DaoSupply;

import java.util.List;

import com.yz.bean.Supply;
import com.yz.dao.BaseDAO;

public interface SupplyDAO  extends BaseDAO<Integer,Supply>{

public List<Supply> queryByName(String name);
	
	public Supply queryByEmailPwd(String email, String password);
	
	public void update_time(String id) ;
	
}
