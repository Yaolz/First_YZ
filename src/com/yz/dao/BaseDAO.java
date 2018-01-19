package com.yz.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<PK extends Serializable,T> {

	public void add(T t); 

	public void delete(String id);

	public void update(T t);
	
	public void update_pwd(T t);
	
	public void update_status(T t);

	public List<T> queryAll();

	public List<T> queryByPager(int pageNo, int pageSize);

	public T queryById(String id);

	public int count();
	
}
