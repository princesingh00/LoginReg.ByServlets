package com.bridgelabz.servlet.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.bridgelabz.servlet.dao.*;

@WebServlet("/MailSend")

public class MailSend extends HttpServlet {
	IDBConnection obj = new DBConnectionImp();
	private static final long serialVersionUID = 1L;

	private static String Email;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Email = request.getParameter("emailId");
		System.out.println(Email);

		boolean check = obj.checkEmail(Email);
		if (check == true) {
			System.out.println("Email verified");
			response.sendRedirect("EmailSent.jsp");
		} else {
			System.out.println("not verified");
			request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
		}
	}

	public static String getUserMail() {
		return Email;
	}

}
