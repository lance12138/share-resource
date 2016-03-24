package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.DownloadResource;
import com.jxust.dao.DownloadResourceDao;
import com.jxust.service.DownloadResourceService;

@Service
@Transactional
public class DownloadResourceServiceImpl implements DownloadResourceService{

	@Resource
	private DownloadResourceDao downloadResourceDao;

	public List findByGrade(int downloadId,Long courseid) {
		// TODO Auto-generated method stub
		return downloadResourceDao.getByGrade(downloadId,courseid);
	}

	public DownloadResource findById(Long id) {
		// TODO Auto-generated method stub
		return downloadResourceDao.getById(id);
	}

	public void save(DownloadResource downloadResource) {
		// TODO Auto-generated method stub
		downloadResourceDao.save(downloadResource);
	}

	public String getHQL(DownloadResource downloadResource,String select,int grade) {
		// TODO Auto-generated method stub
		return downloadResourceDao.getQueryHQL(downloadResource,select,grade);
	}

	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return downloadResourceDao.getCountByHQL(hql);
	}

	public List<DownloadResource> getListgetListForPage(String hql,
			int startRow, int endRow) {
		// TODO Auto-generated method stub
		return downloadResourceDao.getListForPage(hql, startRow, endRow);
	}

	public void delete(Long resourceId) {
		// TODO Auto-generated method stub
		downloadResourceDao.delect(resourceId);
	}

	public void batchDelete(int grade,Long id) {
		// TODO Auto-generated method stub
		 downloadResourceDao.batchByGrade(grade,id);
	}

	public int findSizeByGrade(int grade, Long cid) {
		// TODO Auto-generated method stub
		return downloadResourceDao.findSizeByGrade(grade,cid);
	}

	public List<DownloadResource> findByKey(String searchInput) {
		// TODO Auto-generated method stub
		return downloadResourceDao.findByKey(searchInput);
	}
}
