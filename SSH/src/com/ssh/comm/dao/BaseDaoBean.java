package com.ssh.comm.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository
public abstract class BaseDaoBean<T, PK extends Serializable> implements BaseDao<T, PK> {

    @Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDaoBean() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		return createCriteria(criterion).list();
	}

	@Transactional
	@Override
	public void delete(T entity) {
		Assert.notNull(entity);
		getSession().delete(entity);
	}

	@Transactional
	@Override
	public void delete(PK id) {
		Assert.notNull(id);
		getSession().delete(get(id));
	}

	@Transactional
	@Override
	public T save(T entity) {
		Assert.notNull(entity);
		getSession().save(entity);
		return entity;
	}

	@Transactional
	@Override
	public T saveOrUpdate(T entity) {
		Assert.notNull(entity);
		getSession().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		Assert.notNull(entity);
		getSession().update(entity);
		return entity;
	}
	

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public T get(PK id) {
		return (T)getSession().get(getPersistentClass(), id);
	}
	
	@Transactional
	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

}