package com.jxust.service;

import java.util.List;

import com.jxust.bean.Forum;

public interface ForumService {

	public void save(Forum forum);

	public String getHQL(Forum forum);

	public int getCountByHql(String hql);

	public List getListForPage(String hql, int startRow, int endRow);

	public Forum findById(Long forumId);

	public void update(Forum forum);

	public void delete(Long id);

	public int getSize();
	public List<Forum> findAll();

}
