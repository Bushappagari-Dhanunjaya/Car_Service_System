package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.car.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerregisterServlet
 */
public class CustomerregisterServlet extends HttpServlet {
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String tempName=req.getParameter("name");
		String tempUsername=req.getParameter("username");
		String tempEmail=req.getParameter("email");
		String tempPassword=req.getParameter("password");
		HttpSession session = req.getSession();
		Customer c=new Customer();
		c.setName(tempName);
		c.setUsername(tempUsername);
		c.setEmail(tempEmail);
		c.setPassword(tempPassword);
		int result=c.checkDetails();
		if(result==1) {
			
			session.setAttribute("SessionName", tempName);
			session.setAttribute("SessionUsername", tempUsername);
			c.register();
			res.sendRedirect("/CSS/customerloginsuccess.jsp");
		}
		else if(result==-1) {
			
			res.sendRedirect("/CSS/customerunexist.html");
			
		}
		else {
			res.sendRedirect("/CSS/cemailexist.html");
		}
	}

}
