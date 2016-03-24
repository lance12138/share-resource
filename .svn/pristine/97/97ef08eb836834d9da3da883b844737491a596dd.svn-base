package com.jxust.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Messages;
import com.jxust.dao.MessagesDao;
@Repository
@SuppressWarnings("unchecked")
public class MessagesDaoImpl extends BaseDaoImpl<Messages> implements MessagesDao{
	
	public int getCountByHQL(String hql,Long userId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("select count(*) " + hql);
		query.setLong(0, userId);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}

	public String getHQL() {
		StringBuffer sb=new StringBuffer(" from Messages m where m.userId=? order by m.msg_time desc ");
		return sb.toString();
	}

	
	public List<Messages> getListForPage(String hql, int startRow, int endRow, Long id) {
		// TODO Auto-generated method stub
		Query query=getSession().createQuery(hql);
		query.setLong(0, id);
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		return query.list();
	}

}
