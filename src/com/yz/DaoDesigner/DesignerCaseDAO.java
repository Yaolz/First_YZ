package com.yz.DaoDesigner;

import java.util.List;

import com.yz.bean.DesignerCase;
import com.yz.dao.BaseDAO;

public interface DesignerCaseDAO extends BaseDAO<Integer, DesignerCase>{

	public List<DesignerCase> queryByDesignerId(String designerid);
	
	public List<DesignerCase> queryByPagerDesigner(int pageNo, int pageSize,String companyid);
	
}
