package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Chapter;
import com.jxust.dao.ChapterDao;
import com.jxust.service.ChapterService;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
	@Resource
	private ChapterDao chapterdao;

	public void save(Chapter chapter) {
		
		chapterdao.save(chapter);
	}

	public Chapter findByTitle(String name) {
		// TODO Auto-generated method stub
		return chapterdao.findByTitle(name);
	}

	public String getQueryHQL(Long grade) {
		// TODO Auto-generated method stub
		return chapterdao.getQueryHQL(grade);
	}

	public int getCountByHQL(Long grade,String hql) {
		// TODO Auto-generated method stub
		return chapterdao.getCountByHQL(grade,hql);
	}

	public List getListForPage(String HQL, int startRow, int endRow,Long grade) {
		// TODO Auto-generated method stub
		return chapterdao.getListForPage(HQL, startRow, endRow,grade);
	}

	public List getBygrade(int grade) {
		// TODO Auto-generated method stub
		return chapterdao.findBygrade(grade);
	}

	public void delete(Long courseid) {
		// TODO Auto-generated method stub
		chapterdao.delect(courseid);
	}

	public List<Chapter> findBycourse(Long courseid) {
		// TODO Auto-generated method stub
		return chapterdao.findBycourse(courseid);
	}
	
}
