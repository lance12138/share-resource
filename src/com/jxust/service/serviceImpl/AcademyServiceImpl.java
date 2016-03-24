package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Academy;
import com.jxust.dao.AcademyDao;
import com.jxust.service.AcademyService;

@Service
@Transactional
public class AcademyServiceImpl implements AcademyService{

	@Resource
	AcademyDao academyDao;

	public List findAll() {
		// TODO Auto-generated method stub
		return academyDao.findAll();
	}

	public Academy findByacademy(String name) {
		// TODO Auto-generated method stub
		return academyDao.findByacademy(name);
	}
}
