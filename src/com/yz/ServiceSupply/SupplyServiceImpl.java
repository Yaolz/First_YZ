package com.yz.ServiceSupply;

import java.util.List;

import com.yz.DaoSupply.SupplyDAO;
import com.yz.DaoSupply.SupplyDAOImpl;
import com.yz.bean.Supply;

public class SupplyServiceImpl implements SupplyService {

	public SupplyDAO supplydao;

	public SupplyServiceImpl() {
		supplydao = new SupplyDAOImpl();
	}
	
	@Override
	public void add(Supply t) {
		supplydao.add(t);

	}

	@Override
	public void delete(String id) {
		supplydao.delete(id);

	}

	@Override
	public void update(Supply t) {
		supplydao.update(t);
	}

	@Override
	public List<Supply> queryAll() {
		return supplydao.queryAll();
	}

	@Override
	public List<Supply> queryByPager(int pageNo, int pageSize) {
		return supplydao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Supply queryById(String id) {
		return supplydao.queryById(id);
	}

	@Override
	public int count() {
		return supplydao.count();
	}

	@Override
	public List<Supply> queryByName(String name) {
		return supplydao.queryByName(name);
	}

	@Override
	public Supply queryByEmailPwd(String email, String password) {
		return supplydao.queryByEmailPwd(email, password);
	}

	@Override
	public void update_pwd(Supply t) {
		supplydao.update_pwd(t);
	}

	@Override
	public void update_status(Supply t) {
		supplydao.update_status(t);
		
	}

	@Override
	public void update_time(String id) {
		supplydao.update_time(id);
	}

}
