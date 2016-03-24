package com.jxust.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.User;
@Service("testService")
@Transactional
public class testService {

	@Resource
	private SessionFactory sessionFactory;
	
	public void save(){
		Session session=sessionFactory.getCurrentSession();
		session.save(new User());
		//int a = 1 / 0; 
		session.save(new User());
	}
}
