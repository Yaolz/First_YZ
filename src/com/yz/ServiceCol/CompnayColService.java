package com.yz.ServiceCol;

import java.util.List;

import com.yz.bean.Company;
import com.yz.bean.CompanyCol;

public interface CompnayColService extends ServiceCol<Integer, CompanyCol> {

	public List<Company> queryPage(int pageNo, int pageSize,String customerid);
	
}
