package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.car.model.History;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class HistoryOfServices
 */
public class HistoryOfServices extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String aname=(String)session.getAttribute("aname");
		if(aname!=null) {
			History history=new History();
			ArrayList<History> hs = history.historyOfServices();

			session.setAttribute("hs", hs);
			res.sendRedirect("/CSS/adminhistory.jsp");
		}

		else {
			res.sendRedirect("/CSS/adminlogout.html");
		}

	}


}
