package com.ssh.comm.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, PK extends Serializable> {

	public Class<T> getPersistentClass();
	public void delete(T entity);
	public void delete(PK id);
	public T save(T entity);
	public T saveOrUpdate(T entity);
	public T update(T entity);
	public T get(PK id);
	public List<T> findAll();
}
