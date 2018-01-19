package com.yz.ServiceCol;

import java.util.List;

import com.yz.DaoCol.DesignerCaseColDAO;
import com.yz.DaoCol.DesignerCaseColDAOImpl;
import com.yz.bean.DesignerCase;
import com.yz.bean.DesignerCaseCol;

public class DesignerCaseColServiceImpl implements DesignerCaseColService{

	private  DesignerCaseColDAO desdao;
	public DesignerCaseColServiceImpl() {
		desdao=new DesignerCaseColDAOImpl();
	}

	@Override
	public void add(DesignerCaseCol t) {
		desdao.add(t);
		
	}

	@Override
	public void delete(String id,String customerid) {
		desdao.delete(id,customerid);
		
	}

	@Override
	public List<DesignerCaseCol> queryByCustomerId(String customerid) {
		return desdao.queryByCustomerId(customerid);
	}

	@Override
	public List<DesignerCaseCol> queryPageByCustomerId(int pageNo, int pageSize, String customerid) {
		return desdao.queryPageByCustomerId(pageNo, pageSize, customerid);
	}

	@Override
	public DesignerCaseCol queryById(String id) {
		return desdao.queryById(id);
	}

	@Override
	public int count() {
		return desdao.count();
	}

	@Override
	public DesignerCaseCol queryBySave(String id, String customerid) {
		return desdao.queryBySave(id, customerid);
	}

	@Override
	public List<DesignerCase> queryPage(int pageNo, int pageSize, String customerid) {
		return desdao.queryPage(pageNo, pageSize, customerid);
	}
	

}
