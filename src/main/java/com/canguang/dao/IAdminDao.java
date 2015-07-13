package com.canguang.dao;

import com.canguang.model.Admin;

public interface IAdminDao {
	
	Admin login(String userName,String pwd);

}
