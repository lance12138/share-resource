package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.DownloadResource;

public interface DownloadResourceDao extends BaseDao<DownloadResource>{

	List getByGrade(int downloadId,Long courseid);

	public String getQueryHQL(DownloadResource downloadResource, String select,int grade);

	int findSizeByGrade(int grade,Long cid);

	void batchByGrade(int grade,Long cid);

	List<DownloadResource> findByKey(String searchInput);

	

	

}
