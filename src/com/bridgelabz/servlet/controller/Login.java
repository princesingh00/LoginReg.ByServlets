package com.bridgelabz.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgelabz.servlet.dao.*;

//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDBConnection obj = new DBConnectionImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email=request.getParameter("uname");
		String password=request.getParameter("pass");

		if (obj.login(email,password)) {

			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", email);
			response.sendRedirect("Welcome.jsp");

		} else {
			response.sendRedirect("Login.jsp");

		}
	}
}
