package com.bridgelabz.servlet.dao;

import java.sql.*;
import com.bridgelabz.servlet.controller.Mailer;
import com.bridgelabz.servlet.dto.UserDTO;
import com.bridgelabz.servlet.model.User;

public class DBConnectionImp implements IDBConnection {

	static Connection con;
	Mailer mailer = new Mailer();
	static {
		try {
			// load and register class driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish the connection between java application and database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginRegistration", "root", "password");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	@Override
	public Connection DBConnection() {
		return con;
	}

	@Override
	public void register(User user) {
		
		String query = " insert into Members (firstName,lastName,userName,email,phone,password,regDate) values (?,?,?,?,?,?,?)";		
		try (PreparedStatement st = con.prepareStatement(query)) {

			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setString(3, user.getUserName());
			st.setString(4, user.getEmail());
			st.setString(5, user.getPhone());
			st.setString(6, user.getPassword());
			st.setString(7, user.getRegDate());

			int i = st.executeUpdate();
			if (i > 0) {
				System.out.println("Succesfully Registered");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean login(String email, String password) {
		
		boolean value = false;
		String query = "select * from Members where email = '" + email + "' and password = '" + password + "'";
		ResultSet rs = null;
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			value = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public int forgotPassword(UserDTO user) {
		int k = 0;
		String email = user.getEmail();
		String pass = user.getPassword();
		String query0 = "select * from Members where email = ?";
		String query1 = "update Members set password =? where email = ?";
		try {
			PreparedStatement ps0 = con.prepareStatement(query0);
			PreparedStatement ps1 = con.prepareStatement(query1);

			ps0.setString(1, email);
			ps1.setString(1, pass);
			ps1.setString(2, email);
			ResultSet rs = ps0.executeQuery();
			if (rs.next()) {
				k = ps1.executeUpdate();
				System.out.println("Password Update");
			}
		} catch (SQLException e) {
			System.out.println("Password Update failed");
			e.printStackTrace();
		}
		return k;

	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkEmail(String email) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from Members  where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				mailer.send(email, "validation mail", "http://localhost:8080/loginandRegistration/SetPassword.jsp");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}