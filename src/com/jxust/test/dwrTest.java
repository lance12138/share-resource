package com.jxust.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class dwrTest {
	List<String> list=new ArrayList<String>();
		public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	/*	List<String> list=new ArrayList<String>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String>  test(String test){
		System.out.println(test);
		list.add("asdfasdfs");
		list.add("bsdfdf");
		return list;
	}*/
	@Resource
	SessionFactory sessionFactory = null;
	public List test(int grade){
		try {
			String queryString = "from Chapter d where d.id.grade=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0,grade);
			List testList= queryObject.list();
			for (Iterator iterator = testList.iterator(); iterator.hasNext();) {
				String testString = (String) iterator.next();
				list.add(testString);
			}
			return list;
		} catch (RuntimeException re) {

			throw re;
		}
	}

	private Session getSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
	}
	
}
