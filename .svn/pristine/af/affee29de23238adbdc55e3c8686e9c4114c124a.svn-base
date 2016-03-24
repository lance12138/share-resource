package com.jxust.service.serviceImpl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.News;
import com.jxust.dao.NewsDao;
import com.jxust.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{
  @Resource
  private NewsDao newsDao;
	public void save(News news) {
		newsDao.save(news);
		
	}
	public String getHQL(News news) {
		// TODO Auto-generated method stub
		return newsDao.getHQL(news);
	}
	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return newsDao.getCountByHQL(hql);
	}
	public List getListForPage(String hql, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return newsDao.getListForPage(hql, startIndex, pageSize);
	}
	public News getById(Long id) {
		// TODO Auto-generated method stub
		return newsDao.getById(id);
	}
	public void delete(Long id) {
		newsDao.delect(id);
		
	}
	public void update(News news) {
		newsDao.update(news);
		
	}
	public List nextPage(News news) {
		
		return newsDao.nextPage(news);
	}
	public List previousPage(News news) {
		// TODO Auto-generated method stub
		return newsDao.previousPage(news);
	}
	public void batchDelete() {
		// TODO Auto-generated method stub
		 newsDao.batchDelete();
	}
	public int getAllSize() {
		// TODO Auto-generated method stub
		return newsDao.getSize();
	}

}
