package com.yz.ServiceCol;

import java.util.List;

import com.yz.bean.Supply;
import com.yz.bean.SupplyCol;

public interface SupplyColService extends ServiceCol<Integer,SupplyCol>{
	
	public List<Supply> queryPage(int pageNo, int pageSize,String customerid);

}
