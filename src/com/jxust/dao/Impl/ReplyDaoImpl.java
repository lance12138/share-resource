package com.jxust.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Reply;
import com.jxust.dao.ReplyDao;
@Repository
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao{

	public String getHQL(Reply reply, Long forumId) {
		StringBuffer sb = new StringBuffer(" from Reply r " 
				+ " where r.forum.id= " +forumId+" order by updateTime ");
		return sb.toString(); 
	}
	public void batchDelete(Long forumId){
		Query query=getSession().createQuery("delete from Reply where forumId=?");
		query.setLong(0, forumId);
		query.executeUpdate();
	}
	public int getSize(Long forumId){
		Query query=getSession().createQuery("select count(*) from Reply where forumId=?");
		query.setLong(0, forumId);
		int result = Integer.parseInt(String.valueOf(query.list().get(0)));
		return result;
	}

}
