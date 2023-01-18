package com.app.dao;

import java.util.HashMap;
import java.util.List;

import com.app.modelo.RoleUser;
import com.spring.model.UserDetails;

public interface AdminUserDao {

	List<UserDetails> findAllUsers();

	void saveUser(UserDetails user);

	


}
