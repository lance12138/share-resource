package com.jxust.dao;

import java.util.List;

import com.jxust.base.BaseDao;
import com.jxust.bean.TeachTeam;
import com.jxust.bean.TeachTopic;

public interface TeachTeamDao extends BaseDao<TeachTeam>{

	public String getQueryHQL(TeachTeam teachTeam);

	public TeachTeam findByManager(int i);

}
