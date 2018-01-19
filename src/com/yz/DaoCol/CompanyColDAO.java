package com.yz.DaoCol;

import java.util.List;

import com.yz.bean.Company;
import com.yz.bean.CompanyCol;

public interface CompanyColDAO extends BaseCol<Integer,CompanyCol>{
	
	public List<Company> queryPage(int pageNo, int pageSize,String customerid);

}
