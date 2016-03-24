package com.jxust.dao;

import com.jxust.base.BaseDao;
import com.jxust.bean.AttachFile;

public interface AttachFileDao extends BaseDao<AttachFile>{

	public void save(AttachFile[] attachFile,String[] attachFileName);

}
