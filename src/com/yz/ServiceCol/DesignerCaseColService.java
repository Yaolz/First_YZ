package com.yz.ServiceCol;

import java.util.List;

import com.yz.bean.DesignerCase;
import com.yz.bean.DesignerCaseCol;

public interface DesignerCaseColService extends ServiceCol<Integer,DesignerCaseCol>{

	public List<DesignerCase> queryPage(int pageNo, int pageSize,String customerid);
	
}
