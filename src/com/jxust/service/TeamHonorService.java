package com.jxust.service;

import java.util.List;

import com.jxust.bean.TeamHonor;

public interface TeamHonorService {

	public void save(TeamHonor honor);

	public String getHQL(Long courseid);

	public int getCountByHQL(String hql);

	public List<TeamHonor> getListForPage(String hql, int startRow, int endRow);

	public int getSize(Long courseid);

	public void batchDelete(Long courseid);

	public void delete(Long id);

	public List<TeamHonor> findByCourse(Long courseid);

}
