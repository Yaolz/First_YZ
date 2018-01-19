package com.yz.ServiceCol;

import java.util.List;

import com.yz.DaoCol.SupplyColDAO;
import com.yz.DaoCol.SupplyColDAOImpl;
import com.yz.bean.Supply;
import com.yz.bean.SupplyCol;

public class SupplyColServiceImpl implements SupplyColService{

	private SupplyColDAO supdao;
	
	public SupplyColServiceImpl() {
		supdao = new SupplyColDAOImpl();
	}
	
	@Override
	public void add(SupplyCol t) {
		supdao.add(t);
	}

	@Override
	public void delete(String id,String customerid) {
		supdao.delete(id,customerid);
	}

	@Override
	public List<SupplyCol> queryByCustomerId(String customerid) {
		return supdao.queryByCustomerId(customerid);
	}

	@Override
	public List<SupplyCol> queryPageByCustomerId(int pageNo, int pageSize, String customerid) {
		return supdao.queryPageByCustomerId(pageNo, pageSize, customerid);
	}

	@Override
	public SupplyCol queryById(String id) {
		return supdao.queryById(id);
	}

	@Override
	public int count() {
		return supdao.count();
	}

	@Override
	public SupplyCol queryBySave(String id, String customerid) {
		return supdao.queryBySave(id, customerid);
	}

	@Override
	public List<Supply> queryPage(int pageNo, int pageSize, String customerid) {
		return supdao.queryPage(pageNo, pageSize, customerid);
	}

}
