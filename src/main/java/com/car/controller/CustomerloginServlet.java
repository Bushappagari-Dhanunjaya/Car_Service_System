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
 * Servlet implementation class CustomerloginServlet
 */
public class CustomerloginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
              
		PrintWriter out = res.getWriter();
		String tempUsername = req.getParameter("username");
		String tempPassword = req.getParameter("password");
		HttpSession session = req.getSession();
		Customer c=new Customer();
		c.setUsername(tempUsername);
		c.setPassword(tempPassword);
        int result=c.validExistingUser();
        String tempName=c.getName();
        if(result==1) {
        	session.setAttribute("SessionName", tempName);
        	session.setAttribute("SessionUsername", tempUsername);
        	res.sendRedirect("/CSS/customerloginsuccess.jsp");
        }
        else if(result==-1) {
        	res.sendRedirect("/CSS/cpasswordwrong.html");
        }
        else {
        	res.sendRedirect("/CSS/cusernamenotexist.html");
        }
	}

}
