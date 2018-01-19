package com.yz.ServiceCompany;

import java.util.List;

import com.yz.bean.CompanyCase;
import com.yz.service.BaseService;

public interface CompanyCaseService extends BaseService<Integer,CompanyCase>{

	public List<CompanyCase> queryByCompanyId(String id);
	
	public List<CompanyCase> queryByPagerCompany(int pageNo, int pageSize,String companyid);
	
}
