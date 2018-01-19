package com.yz.ServiceCol;

import java.util.List;

import com.yz.DaoCol.DesignerColDAO;
import com.yz.DaoCol.DesignerColDAOImpl;
import com.yz.bean.Designer;
import com.yz.bean.DesignerCol;

public class DesignerColServiceImpl implements DesignerColService{

	private DesignerColDAO desdao;
	
	public DesignerColServiceImpl() {
		desdao = new DesignerColDAOImpl();
	}
	
	@Override
	public void add(DesignerCol t) {
		desdao.add(t);
	}

	@Override
	public void delete(String id,String customerid) {
		desdao.delete(id,customerid);
	}

	@Override
	public List<DesignerCol> queryByCustomerId(String customerid) {
		return desdao.queryByCustomerId(customerid);
	}

	@Override
	public List<DesignerCol> queryPageByCustomerId(int pageNo, int pageSize, String customerid) {
		return desdao.queryPageByCustomerId(pageNo, pageSize, customerid);
	}

	@Override
	public DesignerCol queryById(String id) {
		return desdao.queryById(id);
	}

	@Override
	public int count() {
		return desdao.count();
	}

	@Override
	public DesignerCol queryBySave(String id, String customerid) {
		return desdao.queryBySave(id, customerid);
	}

	@Override
	public List<Designer> queryPage(int pageNo, int pageSize, String customerid) {
		return desdao.queryPage(pageNo, pageSize, customerid);
	}

}
