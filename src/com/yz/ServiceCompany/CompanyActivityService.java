package com.yz.ServiceCompany;

import java.util.List;

import com.yz.bean.CompanyActivity;
import com.yz.service.BaseService;

public interface CompanyActivityService extends BaseService<Integer,CompanyActivity>{

	public List<CompanyActivity> queryByCompanyId(String companyid);
	
	public List<CompanyActivity> queryPageByCompanyId(int pageNo, int pageSize,String companyid);
	
}
