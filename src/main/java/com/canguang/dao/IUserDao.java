package com.canguang.dao;

import com.canguang.model.User;

public interface IUserDao {

	User findByUsername(String username);
}
