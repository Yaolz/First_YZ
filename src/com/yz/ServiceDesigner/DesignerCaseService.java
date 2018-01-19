package com.yz.ServiceDesigner;

import java.util.List;

import com.yz.bean.DesignerCase;
import com.yz.service.BaseService;

public interface DesignerCaseService extends BaseService<Integer,DesignerCase>{

	public List<DesignerCase> queryByDesignerId(String designerid);
	
	public List<DesignerCase> queryByPagerDesigner(int pageNo, int pageSize,String companyid);
	
}
