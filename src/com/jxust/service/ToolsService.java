package com.jxust.service;

import java.util.List;

import com.jxust.bean.Tools;

public interface ToolsService {

	public List findTeachter(int grade);

	public  void save(Tools tool);

	public List<Tools> findother();

	public void delete(Long id);

	public Tools findByGrade(int i);

	public Tools findTeachChange(int i);

}
