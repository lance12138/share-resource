package com.jxust.service;

import java.util.List;

import com.jxust.bean.TeachMaterial;

public interface TeachMaterialService {

	public void save(TeachMaterial material);

	public String getHQL(Long courseid);

	public int getCountByHQL(String hql);

	public List<TeachMaterial> getListForPage(String hql, int startRow,
			int endRow);

	public void delete(Long id);

	public int getSize(Long courseid);

	public void batchDelete(Long courseid);

	public List<TeachMaterial> findByCourse(Long courseid);

}
