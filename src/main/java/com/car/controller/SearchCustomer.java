package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.car.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchCustomer
 */
public class SearchCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String tempUsername=req.getParameter("Username");
		String aname=(String) session.getAttribute("aname");
		if(aname!=null) {

			Customer c=new Customer();
			c.setUsername(tempUsername);
			c.searchCustomer();
			String tempName=c.getName();
			String tempUserName=c.getUsername();
			String tempEmail=c.getEmail();

			session.setAttribute("searchName", tempName);
			session.setAttribute("searchUsername", tempUserName);
			session.setAttribute("searchEmail", tempEmail);
			if(tempName!=null && tempUserName !=null && tempEmail!=null) {
				res.sendRedirect("/CSS/searchcustomer.jsp");
			}
			else {
				out.println("User not found");		  
			}
		}
		else {
			res.sendRedirect("/CSS/adminlogout.html");
		}

	}

}
