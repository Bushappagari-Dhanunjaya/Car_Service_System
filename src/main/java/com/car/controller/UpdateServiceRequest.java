package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.car.model.Car;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServiceRequest
 */
public class UpdateServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String aname=(String) session.getAttribute("aname");
		if(aname!=null) {
			String tempUsername = req.getParameter("username");
			Car c=new Car();
			c.setUsername(tempUsername);

			int row=c.updateService();
			if(row==0) {
				out.println("User not found");
			}
			else {

				out.println("Updated successfully");
			}
		}
		else {
			res.sendRedirect("/CSS/adminlogout.html");
		}
	}

}
