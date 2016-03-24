package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.TeachTeam;
import com.jxust.bean.TeachTopic;
import com.jxust.dao.TeachTeamDao;
import com.jxust.service.TeachTeamService;

@Service
@Transactional
public class TeachTeamServiceImpl implements TeachTeamService{

	@Resource
	private TeachTeamDao teachTeamDao;

	public void save(TeachTeam teachTeam) {
		// TODO Auto-generated method stub
		teachTeamDao.save(teachTeam);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		teachTeamDao.delect(id);
	}

	public String getQueryHQL(TeachTeam teachTeam) {
		// TODO Auto-generated method stub
		return teachTeamDao.getQueryHQL(teachTeam);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return teachTeamDao.findAll();
	}

	public TeachTeam finById(Long id) {
		// TODO Auto-generated method stub
		return teachTeamDao.getById(id);
	}

	public void update(TeachTeam teachTeam) {
		// TODO Auto-generated method stub
		teachTeamDao.update(teachTeam);
	}

	public TeachTeam finByManager(int i) {
		// TODO Auto-generated method stub
		return teachTeamDao.findByManager(i);
	}

	


}
