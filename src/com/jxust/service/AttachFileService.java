package com.jxust.service;

import com.jxust.bean.AttachFile;

public interface AttachFileService {

	public void save(AttachFile[] attachFile,String[] attachFileName);

	public AttachFile getById(Long id);

}
