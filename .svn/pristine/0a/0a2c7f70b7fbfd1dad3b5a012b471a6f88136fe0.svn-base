package com.jxust.service.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.AttachFile;
import com.jxust.dao.AttachFileDao;
import com.jxust.service.AttachFileService;
@Service
@Transactional
public class AttachFileServiceImpl implements AttachFileService{

	@Resource
	private AttachFileDao attachFileDao;

	public void save(AttachFile[] attachFile,String[] attachFileName) {
		// TODO Auto-generated method stub
		attachFileDao.save(attachFile,attachFileName);
	}

	public AttachFile getById(Long id) {
		// TODO Auto-generated method stub
		return attachFileDao.getById(id);
	}
}
