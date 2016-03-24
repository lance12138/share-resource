package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.TeamHonor;
import com.jxust.dao.TeamHonorDao;
import com.jxust.service.TeamHonorService;
@Service
@Transactional
public class TeamHonorServiceImpl implements TeamHonorService{

	@Resource
	private TeamHonorDao teamHonorDao;

	public void save(TeamHonor honor) {
		// TODO Auto-generated method stub
		teamHonorDao.save(honor);
	}

	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return teamHonorDao.getCountByHQL(hql);
	}

	public String getHQL(Long courseid) {
		// TODO Auto-generated method stub
		return teamHonorDao.getHQL(courseid);
	}

	public List<TeamHonor> getListForPage(String hql, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return teamHonorDao.getListForPage(hql, startRow, endRow);
	}

	public void batchDelete(Long courseid) {
		// TODO Auto-generated method stub
		teamHonorDao.batchDelete(courseid);
	}

	public int getSize(Long courseid) {
		// TODO Auto-generated method stub
		return teamHonorDao.getSize(courseid);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		teamHonorDao.delect(id);
	}

	public List<TeamHonor> findByCourse(Long courseid) {
		// TODO Auto-generated method stub
		return teamHonorDao.findByCourse(courseid);
	}
}
