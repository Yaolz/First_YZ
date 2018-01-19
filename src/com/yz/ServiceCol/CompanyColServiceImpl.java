package com.yz.ServiceCol;

import java.util.List;

import com.yz.DaoCol.CompanyColDAO;
import com.yz.DaoCol.CompanyColDAOImpl;
import com.yz.bean.Company;
import com.yz.bean.CompanyCol;

public class CompanyColServiceImpl implements CompnayColService{
	
	private CompanyColDAO companycoldao;
	
	public CompanyColServiceImpl() {
		companycoldao=new CompanyColDAOImpl();
	}

	@Override
	public void add(CompanyCol t) {
		companycoldao.add(t);
		
	}

	@Override
	public void delete(String id,String customerid) {
		companycoldao.delete(id,customerid);
		
	}

	@Override
	public List<CompanyCol> queryByCustomerId(String customerid) {
		return companycoldao.queryByCustomerId(customerid);
	}

	@Override
	public List<CompanyCol> queryPageByCustomerId(int pageNo, int pageSize, String customerid) {
		return companycoldao.queryPageByCustomerId(pageNo, pageSize, customerid);
	}

	@Override
	public CompanyCol queryById(String id) {
		return companycoldao.queryById(id);
	}

	@Override
	public int count() {
		return companycoldao.count();
	}

	@Override
	public CompanyCol queryBySave(String id, String customerid) {
		return companycoldao.queryBySave(id, customerid);
	}

	@Override
	public List<Company> queryPage(int pageNo, int pageSize, String customerid) {
		return companycoldao.queryPage(pageNo, pageSize, customerid);
	}

	
}
