package com.yz.ServiceCol;

import java.util.List;

import com.yz.bean.CompanyCase;
import com.yz.bean.CompanyCaseCol;

public interface CompanyCaseColService extends ServiceCol<Integer,CompanyCaseCol>{

	public List<CompanyCase> queryPage(int pageNo, int pageSize,String customerid);
	
}
