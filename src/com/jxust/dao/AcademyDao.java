package com.jxust.dao;

import com.jxust.base.BaseDao;
import com.jxust.bean.Academy;

public interface AcademyDao extends BaseDao<Academy>{

	public Academy findByacademy(String name);

}
