package com.sample1.service;

import java.util.List;

import hibernate.dao.UsersInfoDao;
import hibernate.domain.UsersInfo;

public class UsersInfoServiceImpl implements UsersInfoService {
	private UsersInfoDao usersInfoDao;

	public UsersInfoDao getUsersInfoDao() {
		return usersInfoDao;
	}

	public void setUsersInfoDao(UsersInfoDao usersInfoDao) {
		this.usersInfoDao = usersInfoDao;
	}
	
	public List<UsersInfo> listAll(){
		List<UsersInfo> l = getUsersInfoDao().findAll(UsersInfo.class);
		return l;
	}
}
