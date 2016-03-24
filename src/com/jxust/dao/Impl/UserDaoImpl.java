package com.jxust.dao.Impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.ACMuser;
import com.jxust.bean.User;
import com.jxust.dao.UserDao;
@Repository
public class UserDaoImpl extends BaseDaoImpl<ACMuser> implements UserDao{

	public List findBygrade(int i) {
		try {
			String queryString = "from Tools d where d.id.grade=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setInteger(0, i);
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public boolean ajaxValidate(String card) {
		String hql="from ACMuser a where a.id.cardnumber=?";
		Query query = getSession().createQuery("select count(*) " + hql);
		query.setString(0, card);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result==0;
		
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		getSession().save(user);
	}

	public User checkUser(String userName, String password,int i) {
		Query query=getSession().createQuery("FROM User u WHERE u.userName=? AND u.password=? AND u.grade=? ");//
		query.setString(0, userName);
		query.setString(1, DigestUtils.md5Hex(password)); 
		query.setInteger(2, i); 
		return (User) query.uniqueResult();
	}

	public boolean validateUser(String email) {
		String hql=" from User u where u.email=?";
		Query query=getSession().createQuery("select count(*) "+hql);
		query.setString(0, email);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result==0;
	}

	public String getUserQuery(User user) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("from User where 1=1 ");
		if(user.getUserName()!=null&&!user.getUserName().isEmpty()){
			sb.append(" and userName like '%"+user.getUserName()+"%' ");
		}
		return sb.toString();
	}

	public User findById(Long id) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery("from User u where u=?");
		query.setLong(0, id);
		
		return (User) query.uniqueResult();
	}

	public void update(User u) {
		// TODO Auto-generated method stub
		getSession().update(u);
	}

	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		getSession().delete(u);
	}

	public boolean ValidateUserName(String userName) {
		String hql=" from User u where u.userName=?";
		Query query=getSession().createQuery("select count(*) "+hql);
		query.setString(0, userName);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result==0;
	}

	
	

}
