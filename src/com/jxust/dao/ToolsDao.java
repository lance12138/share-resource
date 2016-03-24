package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.Tools;

public interface ToolsDao extends BaseDao<Tools>{

	public List findTeachter(int grade);

	public List<Tools> findother();

	public Tools findByGrade(int i);

	public Tools findTeachChange(int i);

}
