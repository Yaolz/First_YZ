package com.yz.DaoCol;

import java.util.List;

import com.yz.bean.Supply;
import com.yz.bean.SupplyCol;

public interface SupplyColDAO extends BaseCol<Integer,SupplyCol>{
	
	public List<Supply> queryPage(int pageNo, int pageSize,String customerid);

}
