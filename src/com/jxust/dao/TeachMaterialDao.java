package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.TeachMaterial;

public interface TeachMaterialDao extends BaseDao<TeachMaterial>{

	public String getHQL(Long courseid);

	public List<TeachMaterial> findByCourse(Long courseid);

	
}
