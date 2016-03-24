package com.jxust.dao;

import com.jxust.base.BaseDao;
import com.jxust.bean.Forum;

public interface ForumDao extends BaseDao<Forum>{

	public String getHQL(Forum forum);
}
