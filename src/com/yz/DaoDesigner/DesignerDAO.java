package com.yz.DaoDesigner;

import java.util.List;

import com.yz.bean.Designer;
import com.yz.dao.BaseDAO;

public interface DesignerDAO extends BaseDAO<Integer, Designer> {

	public List<Designer> queryByName(String name);

	public Designer queryByEmailPwd(String email, String password);

	public void update_time(String id) ;
	
}
