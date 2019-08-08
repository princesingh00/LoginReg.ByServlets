package com.bridgelabz.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgelabz.servlet.dao.*;
import com.bridgelabz.servlet.dto.UserDTO;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDBConnection obj = new DBConnectionImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		UserDTO user = new UserDTO();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("Npass"));
		int k = obj.forgotPassword(user);
		if (k != 0) {
			System.out.println("Password Reset Succesfully");
			pw.println("Link Send to your email ");
			RequestDispatcher rd = request.getRequestDispatcher("PasswordReset.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("SetPassword.jsp");
		}
	}

}
