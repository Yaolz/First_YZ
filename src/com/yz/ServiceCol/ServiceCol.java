package com.yz.ServiceCol;

import java.io.Serializable;
import java.util.List;

public interface ServiceCol<PK extends Serializable,T> {
	
			public void add(T t); 
		
			public void delete(String id,String customerid);
			
			public List<T> queryByCustomerId(String customerid);
		
			public List<T> queryPageByCustomerId(int pageNo, int pageSize, String customerid);
		
			public T queryById(String id);
			
			public T queryBySave(String id,String customerid);
		
			public int count();
}
