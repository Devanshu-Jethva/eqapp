package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.MailService;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();

		UserBean newUser = new UserBean();
		newUser.setFirstName(firstName);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRole("USER");

		userDao.addUser(newUser);

		MailService mailer = new MailService();
		mailer.sendWelcomeMail(newUser);

		response.sendRedirect("Login.jsp");

	}
}
