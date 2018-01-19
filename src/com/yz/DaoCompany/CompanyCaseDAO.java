package com.yz.DaoCompany;

import java.util.List;

import com.yz.bean.CompanyCase;
import com.yz.dao.BaseDAO;

public interface CompanyCaseDAO extends BaseDAO<Integer, CompanyCase> {

	public List<CompanyCase> queryByCompanyId(String companyid);

	public List<CompanyCase> queryByPagerCompany(int pageNo, int pageSize, String companyid);

}
