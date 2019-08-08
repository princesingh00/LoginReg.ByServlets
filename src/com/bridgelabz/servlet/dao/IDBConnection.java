package com.bridgelabz.servlet.dao;

import java.sql.*;
import com.bridgelabz.servlet.dto.UserDTO;
import com.bridgelabz.servlet.model.User;

public interface IDBConnection {

	public Connection DBConnection();
	void register(User user);
	int forgotPassword(UserDTO user);
	void logOut();
	boolean login(String email,String password);
	boolean checkEmail(String email);
	
}
