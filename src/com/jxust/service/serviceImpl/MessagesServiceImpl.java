package com.jxust.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxust.bean.Messages;
import com.jxust.dao.MessagesDao;
import com.jxust.service.MessagesService;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService{
	@Resource
	private MessagesDao messagesDao;

	public void save(Messages msg) {
		// TODO Auto-generated method stub
		messagesDao.save(msg);
	}

	public String getHQL() {
		// TODO Auto-generated method stub
		return messagesDao.getHQL();
	}

	public int getQueryCount(String hql,Long userId) {
		// TODO Auto-generated method stub
		return messagesDao.getCountByHQL(hql,userId);
	}

	public List<Messages> getListForPage(String hql, int startRow, int endRow, Long id) {
		// TODO Auto-generated method stub
		return messagesDao.getListForPage(hql, startRow, endRow,id);
	}

}
