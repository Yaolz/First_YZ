package com.yz.ServiceCol;

import java.util.List;

import com.yz.bean.Designer;
import com.yz.bean.DesignerCol;

public interface DesignerColService extends ServiceCol<Integer,DesignerCol>{

	public List<Designer> queryPage(int pageNo, int pageSize,String customerid);
	
}
