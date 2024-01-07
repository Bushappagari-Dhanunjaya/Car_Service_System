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
 * Servlet implementation class ServiceRequest
 */
public class ServiceRequest extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter out = res.getWriter();
	String regno= req.getParameter("carregno");
	  String service=req.getParameter("serviceRequest");
	  HttpSession session=req.getSession();
	  String username = (String) session.getAttribute("SessionUsername");
		if(username!=null)
		{
		Car cd=new Car();
		cd.setUsername(username);
		cd.setCarregno(regno);
		cd.setCarservice(service);
		
		int row = cd.serviceRequest();
		
		if(row==0) {
			res.sendRedirect("/CSS/unsuccess.html");
		}
		else {
			
			res.sendRedirect("/CSS/success3.html");
		}
	}
		else {
			res.sendRedirect("/CSS/logout.html");
			
		}
	  
}

}
