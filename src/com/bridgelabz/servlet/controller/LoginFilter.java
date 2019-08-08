package com.bridgelabz.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String email = request.getParameter("uname");
		Pattern emailpattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");
		Matcher match = emailpattern.matcher(email);
		PrintWriter pw = response.getWriter();

		if (match.matches()) {
			pw.print("success");
			chain.doFilter(request, response);
		} else {
			pw.print("invalid username");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward (request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
