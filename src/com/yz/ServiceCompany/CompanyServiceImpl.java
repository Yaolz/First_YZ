package com.yz.ServiceCompany;

import java.util.List;

import com.yz.DaoCompany.CompanyDAO;
import com.yz.DaoCompany.CompanyDAOImpl;
import com.yz.bean.Company;
import com.yz.common.AbstractBaseDAO;

public class CompanyServiceImpl extends AbstractBaseDAO implements CompanyService{

	private CompanyDAO comdao;
	
	public CompanyServiceImpl() {
		comdao = new CompanyDAOImpl();
	}
	
	@Override
	public void add(Company t) {
		comdao.add(t);
	}

	@Override
	public void delete(String id) {
		comdao.delete(id);
	}

	@Override
	public void update(Company t) {
		comdao.update(t);
	}

	@Override
	public List<Company> queryAll() {
		return comdao.queryAll();
	}

	@Override
	public List<Company> queryByPager(int pageNo, int pageSize) {
		return comdao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Company queryById(String id) {
		return comdao.queryById(id);
	}

	@Override
	public int count() {
		return comdao.count();
	}

	@Override
	public List<Company> queryByName(String name) {
		return comdao.queryByName(name);
	}

	@Override
	public Company queryByEmailPwd(String email, String password) {
		return comdao.queryByEmailPwd(email, password);
	}

	@Override
	public void update_pwd(Company t) {
		comdao.update_pwd(t);
	}

	@Override
	public void update_status(Company t) {
		comdao.update_status(t);
		
	}

	@Override
	public void update_time(String id) {
		comdao.update_time(id);
	}

}
