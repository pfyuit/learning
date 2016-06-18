package com.pfyuit.myjavaee.service.database.nosql.cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfyuit.myjavaee.dao.database.nosql.cassandra.UsersDao;

/**
 * User implementation for cassandra.
 * @author yupengfei
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public void createKeySpace() {
		usersDao.createKeySpace();
	}

	@Override
	public void createTable() {
		usersDao.createTable();
	}

	@Override
	public void save() {
		usersDao.save();
	}

	@Override
	public void delete() {
		usersDao.delete();
	}

	@Override
	public void update() {
		usersDao.update();
	}

	@Override
	public void find() {
		usersDao.find();
	}

}
