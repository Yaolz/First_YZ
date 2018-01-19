package com.yz.DaoSupply;

import java.util.List;

import com.yz.bean.SupplyActivity;
import com.yz.dao.BaseDAO;

public interface SupplyActivityDAO extends BaseDAO<Integer,SupplyActivity>{

	public List<SupplyActivity> queryBySupplyId(String supplyid);
	
	public List<SupplyActivity> queryByPageSupply(int pageNo, int pageSize,String supplyid);
	
}
