package com.yz.ServiceDesigner;

import java.util.List;

import com.yz.DaoDesigner.DesignerDAO;
import com.yz.DaoDesigner.DesignerDAOImpl;
import com.yz.bean.Designer;

public class DesignerServiceImpl implements DesignerService {

	public DesignerDAO designerdao;

	public DesignerServiceImpl() {
		designerdao = new DesignerDAOImpl();
	}
	
	@Override
	public void add(Designer t) {
		designerdao.add(t);

	}

	@Override
	public void delete(String id) {
		designerdao.delete(id);

	}

	@Override
	public void update(Designer t) {
		designerdao.update(t);
	}

	@Override
	public List<Designer> queryAll() {
		// TODO Auto-generated method stub
		return designerdao.queryAll();
	}

	@Override
	public List<Designer> queryByPager(int pageNo, int pageSize) {
		return designerdao.queryByPager(pageNo, pageSize);
	}

	@Override
	public Designer queryById(String id) {
		return designerdao.queryById(id);
	}

	@Override
	public int count() {
		return designerdao.count();
	}

	@Override
	public List<Designer> queryByName(String name) {
		return designerdao.queryByName(name);
	}

	@Override
	public Designer queryByEmailPwd(String email, String password) {
		return designerdao.queryByEmailPwd(email, password);
	}

	@Override
	public void update_pwd(Designer t) {
		designerdao.update_pwd(t);
	}

	@Override
	public void update_status(Designer t) {
		designerdao.update_status(t);
		
	}

	@Override
	public void update_time(String id) {
		designerdao.update_time(id);
	}

}
