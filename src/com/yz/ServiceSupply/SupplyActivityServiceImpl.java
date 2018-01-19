package com.yz.ServiceSupply;

import java.util.List;

import com.yz.DaoSupply.SupplyActivityDAO;
import com.yz.DaoSupply.SupplyActivityDAOImpl;
import com.yz.bean.SupplyActivity;

public class SupplyActivityServiceImpl implements SupplyActivityService{

	private SupplyActivityDAO supdao;
	
	public SupplyActivityServiceImpl() {
		supdao = new SupplyActivityDAOImpl();
	}
	
	@Override
	public void add(SupplyActivity t) {
		supdao.add(t);
	}

	@Override
	public void delete(String id) {
		supdao.delete(id);
	}

	@Override
	public void update(SupplyActivity t) {
		supdao.update(t);
	}

	@Override
	public void update_pwd(SupplyActivity t) {
		supdao.update_pwd(t);
	}

	@Override
	public void update_status(SupplyActivity t) {
		supdao.update_status(t);
	}

	@Override
	public List<SupplyActivity> queryAll() {
		return supdao.queryAll();
	}

	@Override
	public List<SupplyActivity> queryByPager(int pageNo, int pageSize) {
		return supdao.queryByPager(pageNo, pageSize);
	}

	@Override
	public SupplyActivity queryById(String id) {
		return supdao.queryById(id);
	}

	@Override
	public int count() {
		return supdao.count();
	}

	@Override
	public List<SupplyActivity> queryBySupplyId(String supplyid) {
		return supdao.queryBySupplyId(supplyid);
	}

	@Override
	public List<SupplyActivity> queryByPageSupply(int pageNo, int pageSize, String supplyid) {
		return supdao.queryByPageSupply(pageNo, pageSize, supplyid);
	}

}
