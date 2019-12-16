package com.websocket.respository;

import java.util.List;

import com.websocket.mapper.IRowMapper;

public interface IAbstractRespository<T> {
	List<T> query(String sql,IRowMapper<T> mapper,Object... parameters);
	int insert(String sql,Object... parameters);
	int update(String sql,Object... parameters);
	public List<T> update(T object);
	int delete(String sql,Object... parameters);
	int getTotalItem(String sql,Object... parameters);
	public List<T> findAll();
	
}
