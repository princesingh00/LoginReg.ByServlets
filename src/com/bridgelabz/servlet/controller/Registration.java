package com.bridgelabz.servlet.controller;

import com.bridgelabz.servlet.dto.*;
import com.bridgelabz.servlet.services.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Ifacility obj = new FacilityImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO user = new UserDTO();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setUserName(request.getParameter("uname"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setPassword(request.getParameter("pass"));
		obj.dtomodelMapping(user);
		response.sendRedirect("success.jsp");
	}

}
