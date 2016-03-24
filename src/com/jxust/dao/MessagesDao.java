package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Messages;

public interface MessagesDao extends BaseDao<Messages>{
	
	public String getHQL();
	public int getCountByHQL(String hql,Long userId);

	public List<Messages> getListForPage(String hql, int startRow, int endRow, Long id);

}
