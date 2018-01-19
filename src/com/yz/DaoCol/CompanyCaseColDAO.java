package com.yz.DaoCol;

import java.util.List;

import com.yz.bean.CompanyCase;
import com.yz.bean.CompanyCaseCol;

public interface CompanyCaseColDAO extends BaseCol<Integer,CompanyCaseCol>{

	public List<CompanyCase> queryPage(int pageNo, int pageSize,String customerid);
	
}
