package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Program;
import com.jxust.dao.ProgramDao;
import com.jxust.service.ProgramService;
@Service
@Transactional
public class ProgramServiceImpl implements ProgramService{

	@Resource
	private ProgramDao programDao;

	public void save(Program program) {
		// TODO Auto-generated method stub
		programDao.save(program);
	}

	public int getCountByCourse(String hql,Long courseid) {
		// TODO Auto-generated method stub
		return programDao.getCountByCourse(hql,courseid);
	}

	public String getHQL(Long courseId) {
		// TODO Auto-generated method stub
		return programDao.getHQL(courseId);
	}

	public List<Program> getListForPage(String hql, int startRow, int endRow,
			Long courseid) {
		// TODO Auto-generated method stub
		return programDao.getListForPage(hql, startRow, endRow,courseid);
	}

	public int findSizeByCourse(Long courseid) {
		// TODO Auto-generated method stub
		return programDao.getSize(courseid);
	}

	public Program findById(Long proId) {
		// TODO Auto-generated method stub
		return programDao.getById(proId);
	}

	public void delete(Long proId) {
		// TODO Auto-generated method stub
		programDao.delect(proId);
	}
}
