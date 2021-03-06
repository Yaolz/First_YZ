package com.yz.DaoCompany;

import java.util.List;

import com.yz.bean.CompanyActivity;
import com.yz.dao.BaseDAO;

public interface CompanyActivityDAO extends BaseDAO<Integer,CompanyActivity>{

	public List<CompanyActivity> queryByCompanyId(String companyid);
	
	public List<CompanyActivity> queryPageByCompanyId(int pageNo, int pageSize,String companyid);
	
}
