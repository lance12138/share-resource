package com.jxust.test;

import org.junit.Test;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@SuppressWarnings("unused")
	@Test
	 public void testsessionFactory() throws Exception{
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
   
	}
	 @SuppressWarnings("unused")
	 @Test
	public void testsessiontransaction() throws Exception{
		   testService testservice=(testService) ac.getBean("testService");
		   testservice.save();

		}
}
