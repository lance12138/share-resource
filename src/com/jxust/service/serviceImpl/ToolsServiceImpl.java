package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Tools;
import com.jxust.dao.ToolsDao;
import com.jxust.service.ToolsService;


@Service
@Transactional
public class ToolsServiceImpl implements ToolsService{

	@Resource
	private ToolsDao toolsDao;

	public List findTeachter(int grade) {
		// TODO Auto-generated method stub
		return toolsDao.findTeachter(grade);
	}

	public void save(Tools tool) {
		// TODO Auto-generated method stub
		toolsDao.save(tool);
	}

	public List<Tools> findother() {
		// TODO Auto-generated method stub
		return toolsDao.findother();
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		toolsDao.delect(id);
	}

	public Tools findByGrade(int i) {
		// TODO Auto-generated method stub
		return toolsDao.findByGrade(i);
	}

	public Tools findTeachChange(int i) {
		// TODO Auto-generated method stub
		return toolsDao.findTeachChange(i);
	}
	
	
}
