package com.yz.ServiceCompany;

import java.util.List;

import com.yz.DaoCompany.CompanyCaseDAO;
import com.yz.DaoCompany.CompanyCaseDAOImpl;
import com.yz.bean.CompanyCase;

public class CompanyCaseServiceImpl implements CompanyCaseService{

	private CompanyCaseDAO comcasedao;
	
	public CompanyCaseServiceImpl() {
		comcasedao = new CompanyCaseDAOImpl();
	}
	
	@Override
	public void add(CompanyCase t) {
		comcasedao.add(t);
	}

	@Override
	public void delete(String id) {
		comcasedao.delete(id);
	}

	@Override
	public void update(CompanyCase t) {
		comcasedao.update(t);
	}

	@Override
	public void update_pwd(CompanyCase t) {
		comcasedao.update_pwd(t);
	}

	@Override
	public void update_status(CompanyCase t) {
		comcasedao.update_status(t);
	}

	@Override
	public List<CompanyCase> queryAll() {
		return comcasedao.queryAll();
	}

	@Override
	public List<CompanyCase> queryByPager(int pageNo, int pageSize) {
		return comcasedao.queryByPager(pageNo, pageSize);
	}

	@Override
	public CompanyCase queryById(String id) {
		return comcasedao.queryById(id);
	}

	@Override
	public int count() {
		return comcasedao.count();
	}

	@Override
	public List<CompanyCase> queryByCompanyId(String id) {
		return comcasedao.queryByCompanyId(id);
	}

	@Override
	public List<CompanyCase> queryByPagerCompany(int pageNo, int pageSize, String companyid) {
		return comcasedao.queryByPagerCompany(pageNo, pageSize, companyid);
	}

}
