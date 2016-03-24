package com.jxust.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jxust.base.BaseDao;


@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	SessionFactory sessionFactory = null;
	private Class<T> clazz;

	public BaseDaoImpl() {
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}

	public void save(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}

	public void delect(Long id) {
		// TODO Auto-generated method stub
		Object object = getSession().get(clazz, id);
		getSession().delete(object);
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName()//
		).list();
	}
	public int getSize(){
		Query query=getSession().createQuery(//
				"select count(*) FROM " +clazz.getSimpleName());
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}
	public int getSize(Long id){
		Query query=getSession().createQuery(//
				"select count(*) FROM " +clazz.getSimpleName()+" where courseId="+id);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}
	public void batchDelete(){
		Query query=getSession().createQuery("delete "+clazz.getSimpleName());
		query.executeUpdate();
	}
	public void batchDelete(Long id){
		Query query=getSession().createQuery("delete from "+clazz.getSimpleName()+" where courseId="+id);
		query.executeUpdate();
	}
	public T getById(Long id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(clazz, id);
	}
	public List<T> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}

		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)"//
		).setParameterList("ids", ids).list();
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		getSession().update(t);
	}

	/***********************************************************/
	/**
	 * 分页相关的方法
	 */
	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery("select count(*) " + hql);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}

	public List<T> getListForPage(String hql, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}

	public String getQueryHQL(T t) {
	   
		
		//根据板块，回复的特点，
		
			
			StringBuffer sb = new StringBuffer("from " + clazz.getSimpleName()
					+ " where 1=1 ");
			return sb.toString();
		}
	
	
	 

	/**
	 * 获得当前可用的session
	 * 
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
