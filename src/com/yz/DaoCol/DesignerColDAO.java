package com.yz.DaoCol;

import java.util.List;

import com.yz.bean.Designer;
import com.yz.bean.DesignerCol;

public interface DesignerColDAO extends BaseCol<Integer,DesignerCol>{

	public List<Designer> queryPage(int pageNo, int pageSize,String customerid);
	
}
