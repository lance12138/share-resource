package com.jxust.service;

import java.util.List;

import com.jxust.bean.ACMuser;
import com.jxust.bean.User;

public interface UserService {

	List findBygrade(int i);//通过等级查询

	boolean ajaxValidate(String card);

	void save(ACMuser acmUser);

  public String getHQL(ACMuser acmUser);

    public int findByHQL(String hql);

   public List getListForPage(String hql, int startRow, int endRow);

 public List findAll();

public void delete(Long userId);

void saveUser(User user);

public User checkUser(String userName, String password, int i);

boolean ValidateUser(String email);

int getSize();

void batchDelete();

public String getUserHQL(User user);

public User findById(Long id);

public void update(User u);

public void deleteuser(User u);

boolean ValidateUserName(String userName);

	
}
