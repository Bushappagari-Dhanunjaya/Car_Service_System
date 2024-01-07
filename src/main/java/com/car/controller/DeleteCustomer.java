package com.car.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.car.model.Customer;

/**
 * Servlet implementation class DeleteCustomer
 */
public class DeleteCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		String tempUsername=req.getParameter("Username");
		HttpSession session = req.getSession();
		String aname=(String)session.getAttribute("aname");
		if(aname!=null) {
			Customer c=new Customer();
			c.setUsername(tempUsername);
			int row=c.deleteCustomer();
			if(row==1) {
				out.println("Deleted");		  
			}
			else {
				out.println("Customer not Found");
			}
		}
		else {
			res.sendRedirect("/CSS/adminlogout.html");
		}

	}

}
