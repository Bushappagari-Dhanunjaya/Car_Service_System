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
 * Servlet implementation class EditCarDetailsTwo
 */
public class EditCarDetailsTwo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String tempcarmodel=req.getParameter("carmodel");
		String tempcartype=req.getParameter("cartype");

		HttpSession session = req.getSession();

		String username=(String) session.getAttribute("SessionUsername");
		String regNo=(String) session.getAttribute("SessionRegNo");
		if(username!=null) {
			Car tempcardetails=new Car();
			tempcardetails.setUsername(username);
			tempcardetails.setCarregno(regNo);
			tempcardetails.setCarmodel(tempcarmodel);
			tempcardetails.setCartype(tempcartype);

			int row= tempcardetails.editCarDetails();
			if(row==1) {
				//success
				res.sendRedirect("/CSS/success2.html");


			}
			else {
				//not success
				res.sendRedirect("/CSS/unsuccess.html");

			}
		}
		else {
			res.sendRedirect("/CSS/logout.html");
		}
	}

}
