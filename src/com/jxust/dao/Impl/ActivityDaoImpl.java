package com.jxust.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Activity;
import com.jxust.dao.ActivityDao;
@Repository
public class ActivityDaoImpl extends BaseDaoImpl<Activity> implements ActivityDao {

	public Activity nextPage(Activity ac) {
		String queryString = "from Activity d where d.ac_id>? order by ac_id asc";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setLong(0,ac.getAc_id());
		queryObject.setFirstResult(0);
		queryObject.setMaxResults(1);
		return (Activity) queryObject.uniqueResult();
	}

	public Activity previousPage(Activity ac) {
		String queryString="from Activity d where d.ac_id<? order by ac_id desc";
		Query queryObject=getSession().createQuery(queryString);
		queryObject.setLong(0,ac.getAc_id());
		queryObject.setFirstResult(0);
		queryObject.setMaxResults(1);
		return (Activity) queryObject.uniqueResult();
	}

}
