package com.kitty.dao;

import com.kitty.model.User;

public interface IUserDao {

	User findByUsername(String username);
}
