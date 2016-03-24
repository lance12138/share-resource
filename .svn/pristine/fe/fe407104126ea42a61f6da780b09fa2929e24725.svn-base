package com.jxust.service;

import java.util.List;

import com.jxust.bean.News;

public interface NewsService {

	void save(News news);
	public String getHQL(News news);
    public int getCountByHQL(String hql);
    public List getListForPage(String hql, int startIndex, int pageSize);
    public News getById(Long id);
    void delete(Long id);
    void update(News news);
    public List nextPage(News news);
    public List previousPage(News news);
	void batchDelete();
	int getAllSize();
}
