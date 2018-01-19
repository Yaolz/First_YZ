package com.yz.ServiceDesigner;

import java.util.List;

import com.yz.DaoDesigner.DesignerCaseDAO;
import com.yz.DaoDesigner.DesignerCaseDAOImpl;
import com.yz.bean.DesignerCase;

public class DesignerCaseServiceImpl implements DesignerCaseService {

	private DesignerCaseDAO descasedao;

	public DesignerCaseServiceImpl() {
		descasedao = new DesignerCaseDAOImpl();
	}

	@Override
	public void add(DesignerCase t) {
		descasedao.add(t);
	}

	@Override
	public void delete(String id) {
		descasedao.delete(id);
	}

	@Override
	public void update(DesignerCase t) {
		descasedao.update(t);
	}

	@Override
	public void update_pwd(DesignerCase t) {
		descasedao.update_pwd(t);
	}

	@Override
	public void update_status(DesignerCase t) {
		descasedao.update_status(t);
	}

	@Override
	public List<DesignerCase> queryAll() {
		return descasedao.queryAll();
	}

	@Override
	public List<DesignerCase> queryByPager(int pageNo, int pageSize) {
		return descasedao.queryByPager(pageNo, pageSize);
	}

	@Override
	public DesignerCase queryById(String id) {
		return descasedao.queryById(id);
	}

	@Override
	public int count() {
		return descasedao.count();
	}

	@Override
	public List<DesignerCase> queryByDesignerId(String designerid) {
		return descasedao.queryByDesignerId(designerid);
	}

	@Override
	public List<DesignerCase> queryByPagerDesigner(int pageNo, int pageSize, String companyid) {
		return descasedao.queryByPagerDesigner(pageNo, pageSize, companyid);
	}

}
