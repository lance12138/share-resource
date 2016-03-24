package com.jxust.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.Forum;
import com.jxust.dao.ForumDao;
@Repository
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao{

	public String getHQL(Forum forum){
		StringBuffer sb=new StringBuffer("from Forum order by updateTime desc");
		return sb.toString();
	}
}
