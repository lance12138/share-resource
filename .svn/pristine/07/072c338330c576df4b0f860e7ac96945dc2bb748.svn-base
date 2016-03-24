package com.jxust.dao.Impl;

import org.springframework.stereotype.Repository;

import com.jxust.base.BaseDaoImpl;
import com.jxust.bean.AttachFile;
import com.jxust.dao.AttachFileDao;
@Repository
public class AttachFileDaoImpl extends BaseDaoImpl<AttachFile> implements AttachFileDao{

	public void save(AttachFile[] attachFile, String[] attachFileName) {
		for (int i = 0; i < attachFileName.length; i++) {
			attachFile[i].setFile(attachFileName[i]);
			getSession().save(attachFile[i]);
		}
		
	}

}
