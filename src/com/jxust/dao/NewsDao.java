package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.News;

public interface NewsDao extends BaseDao<News>{

	public String getHQL(News news);
	
	public List nextPage(News news);
	public List previousPage(News news);

	
}
