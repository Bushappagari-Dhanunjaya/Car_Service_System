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
 * Servlet implementation class EditCarDetailsOne
 */
public class EditCarDetailsOne extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter out = res.getWriter();
	  String tempRegNo=req.getParameter("CarRegNo");
	  HttpSession session=req.getSession();
	  String username = (String) session.getAttribute("SessionUsername");
	  session.setAttribute("SessionRegNo", tempRegNo);
	  if(username!=null) {
		Car cd=new Car();
		
		cd.setUsername(username);
		cd.setCarregno(tempRegNo);
		int row = cd.checkRegNo();
		
		if(row==1) {
			res.sendRedirect("/CSS/careditdetails2.html");
		}
		else {
			out.println("you have not request for any request");
		}
	  }
	  else {
		  res.sendRedirect("/CSS/logout.html");
	  }
}

}
