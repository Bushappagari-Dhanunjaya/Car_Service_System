package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.car.model.Car;
import com.car.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetServiceRequest
 */
public class GetServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		String aname = (String) session.getAttribute("aname");
		if(aname!=null) {
			Car c=new Car();
			ArrayList<Car> serviceRequests = c.getServiceRequests();

			session.setAttribute("SRs", serviceRequests);
			res.sendRedirect("/CSS/getservicerequests.jsp");
		}

		else {
			res.sendRedirect("/CSS/adminlogout.html");
		}
	}

}

