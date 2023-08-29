package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EquityBean;
import com.dao.EquityDao;
import com.service.EqPriceService;

@WebServlet("/AddEqServlet")
public class AddEqServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EqPriceService eqService = new EqPriceService();

		ArrayList<EquityBean> list = eqService.addEquity();

		EquityDao dao = new EquityDao();
		for (EquityBean e : list) {
			dao.addEquity(e);
		}

		response.sendRedirect("AdminDashboard.jsp");

	}
}
