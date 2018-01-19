package com.yz.ServiceCompany;

import java.util.List;

import com.yz.DaoCompany.CompanyActivityDAO;
import com.yz.DaoCompany.CompanyActivityDAOImpl;
import com.yz.bean.CompanyActivity;

public class CompanyActivityServiceImpl implements CompanyActivityService{

	private CompanyActivityDAO comdao;
	
	public CompanyActivityServiceImpl() {
		comdao = new CompanyActivityDAOImpl();
	}
	
	@Override
	public void add(CompanyActivity t) {
		comdao.add(t);
	}

	@Override
	public void delete(String id) {
		comdao.delete(id);
	}

	@Override
	public void update(CompanyActivity t) {
		comdao.update(t);
	}

	@Override
	public void update_pwd(CompanyActivity t) {
		comdao.update_pwd(t);
	}

	@Override
	public void update_status(CompanyActivity t) {
		comdao.update_status(t);
	}

	@Override
	public List<CompanyActivity> queryAll() {
		return comdao.queryAll();
	}

	@Override
	public List<CompanyActivity> queryByPager(int pageNo, int pageSize) {
		return comdao.queryByPager(pageNo, pageSize);
	}

	@Override
	public CompanyActivity queryById(String id) {
		return comdao.queryById(id);
	}

	@Override
	public int count() {
		return comdao.count();
	}

	@Override
	public List<CompanyActivity> queryByCompanyId(String companyid) {
		return comdao.queryByCompanyId(companyid);
	}

	@Override
	public List<CompanyActivity> queryPageByCompanyId(int pageNo, int pageSize, String companyid) {
		return comdao.queryPageByCompanyId(pageNo, pageSize, companyid);
	}

}
