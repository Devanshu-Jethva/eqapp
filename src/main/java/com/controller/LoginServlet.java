package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();

		UserBean user = userDao.authenticate(email, password);

		if (user == null) {
			request.setAttribute("error", "Invalid credentials");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			// successfully logged in

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			if (user.getRole().equals("USER")) {

				response.sendRedirect("Home.jsp");
			} else if (user.getRole().equals("ADMIN")) {
				response.sendRedirect("AdminDashboard.jsp");

			}
		}

	}
}
