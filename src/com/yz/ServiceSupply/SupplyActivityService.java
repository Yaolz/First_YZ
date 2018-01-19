package com.yz.ServiceSupply;

import java.util.List;

import com.yz.bean.SupplyActivity;
import com.yz.service.BaseService;

public interface SupplyActivityService extends BaseService<Integer,SupplyActivity>{

	public List<SupplyActivity> queryBySupplyId(String supplyid);
	
	public List<SupplyActivity> queryByPageSupply(int pageNo, int pageSize,String supplyid);
	
}
