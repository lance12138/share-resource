package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.TeachMaterial;
import com.jxust.dao.TeachMaterialDao;
import com.jxust.service.TeachMaterialService;
@Service
@Transactional
public class TeachMaterialServiceImpl implements TeachMaterialService{
	
	@Resource
	private TeachMaterialDao materialDao;

	public void save(TeachMaterial material) {
		// TODO Auto-generated method stub
		materialDao.save(material);
	}

	public String getHQL(Long courseid) {
		// TODO Auto-generated method stub
		return materialDao.getHQL(courseid);
	}

	public int getCountByHQL(String hql) {
		// TODO Auto-generated method stub
		return materialDao.getCountByHQL(hql);
	}

	public List<TeachMaterial> getListForPage(String hql, int startRow,
			int endRow) {
		// TODO Auto-generated method stub
		return materialDao.getListForPage(hql, startRow, endRow);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		materialDao.delect(id);
	}

	public void batchDelete(Long courseid) {
		// TODO Auto-generated method stub
		materialDao.batchDelete(courseid);
	}

	public int getSize(Long courseid) {
		// TODO Auto-generated method stub
		return materialDao.getSize(courseid);
	}

	public List<TeachMaterial> findByCourse(Long courseid) {
		// TODO Auto-generated method stub
		return materialDao.findByCourse(courseid);
	}
}
