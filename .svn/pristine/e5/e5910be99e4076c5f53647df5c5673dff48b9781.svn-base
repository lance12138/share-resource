package com.jxust.service;

import java.util.List;

import com.jxust.bean.DownloadResource;

public interface DownloadResourceService {

	List findByGrade(int downloadId,Long courseid);

	DownloadResource findById(Long id);

	void save(DownloadResource downloadResource);

	public String getHQL(DownloadResource downloadResource,String select,int grade);

	public int getCountByHQL(String hql);

	public List<DownloadResource> getListgetListForPage(String hql, int startRow,
			int endRow);

	public void delete(Long resourceId);
	void batchDelete(int grade,Long id);
	int findSizeByGrade(int grade, Long cid);

	List<DownloadResource> findByKey(String searchInput);

	

}
