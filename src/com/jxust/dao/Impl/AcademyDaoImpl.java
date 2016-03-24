package com.jxust.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Academy;
import com.jxust.dao.AcademyDao;
@Repository
public class AcademyDaoImpl extends BaseDaoImpl<Academy> implements AcademyDao{

	public Academy findByacademy(String name) {
		try {
			String queryString = "from Academy d where d.id.academy=?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setString(0,name);
			return (Academy) queryObject.list().get(0);
		} catch (RuntimeException re) {

			throw re;
		}
	}

}
