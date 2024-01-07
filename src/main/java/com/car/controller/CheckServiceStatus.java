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
 * Servlet implementation class CheckServiceStatus
 */
public class CheckServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String regNo = req.getParameter("CarRegNo");
		HttpSession session = req.getSession();
		String tempUsername=(String) session.getAttribute("SessionUsername");
		if(tempUsername!=null) {
			Car service=new Car();
			service.setUsername(tempUsername);
			service.setCarregno(regNo);
			int row=service.checkService();
			if(row==1) {
               session.setAttribute("carModel", service.getCarmodel());
               session.setAttribute("carRegNo", service.getCarregno());
               session.setAttribute("carStatus", service.getCarstatus());
               res.sendRedirect("/CSS/getcarservicestatus.jsp");
                       
			}
			else {
				res.sendRedirect("/CSS/unsuccess.html");
			}

		} 
		else {
			res.sendRedirect("/CSS/logout.html");
		}

	}


}
