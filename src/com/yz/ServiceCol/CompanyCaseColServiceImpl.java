package com.yz.ServiceCol;

import java.util.List;

import com.yz.DaoCol.CompanyCaseColDAO;
import com.yz.DaoCol.CompanyCaseColDAOImpl;
import com.yz.bean.CompanyCase;
import com.yz.bean.CompanyCaseCol;

public class CompanyCaseColServiceImpl implements CompanyCaseColService{

	private CompanyCaseColDAO comdao;
	
	public CompanyCaseColServiceImpl() {
		comdao = new CompanyCaseColDAOImpl();
	}
	
	@Override
	public void add(CompanyCaseCol t) {
		comdao.add(t);
	}

	@Override
	public void delete(String id,String customerid) {
		comdao.delete(id,customerid);
	}

	@Override
	public List<CompanyCaseCol> queryByCustomerId(String customerid) {
		return comdao.queryByCustomerId(customerid);
	}

	@Override
	public List<CompanyCaseCol> queryPageByCustomerId(int pageNo, int pageSize, String customerid) {
		return comdao.queryPageByCustomerId(pageNo, pageSize, customerid);
	}

	@Override
	public CompanyCaseCol queryById(String id) {
		return comdao.queryById(id);
	}

	@Override
	public int count() {
		return comdao.count();
	}

	@Override
	public CompanyCaseCol queryBySave(String id, String customerid) {
		return comdao.queryBySave(id, customerid);
	}

	@Override
	public List<CompanyCase> queryPage(int pageNo, int pageSize, String customerid) {
		return comdao.queryPage(pageNo, pageSize, customerid);
	}

}
