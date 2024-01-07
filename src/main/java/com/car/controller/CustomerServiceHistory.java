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
 * Servlet implementation class CustomerServiceHistory
 */
public class CustomerServiceHistory extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                       
		PrintWriter out = res.getWriter();
		History ch=new History();
		HttpSession session = req.getSession();
		String un=(String) session.getAttribute("SessionUsername");
		ch.setUsername(un);
		ArrayList<History> history = ch.getHistory();
		session.setAttribute("history", history);
		res.sendRedirect("/CSS/customerhistory.jsp");
		
		
	}

}
