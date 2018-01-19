package com.yz.DaoCol;

import java.util.List;

import com.yz.bean.DesignerCase;
import com.yz.bean.DesignerCaseCol;

public interface DesignerCaseColDAO extends BaseCol<Integer,DesignerCaseCol>{

	public List<DesignerCase> queryPage(int pageNo, int pageSize,String customerid);
	
}
