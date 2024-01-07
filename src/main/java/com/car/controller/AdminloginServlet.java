package com.car.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.car.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminloginServlet
 */
public class AdminloginServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        	
          PrintWriter out = res.getWriter();
          
  		  String tempName=req.getParameter("aname");
  		  String tempPassword=req.getParameter("apassword");
  		  HttpSession session = req.getSession();
  		  Admin admin=new Admin();
  		  admin.setName(tempName);
  		  admin.setPassword(tempPassword);
  		  int result=admin.checkAdmin();
  		  if(result==1) {
  			  session.setAttribute("aname", tempName);
  			  
  			  res.sendRedirect("/CSS/adminloginsuccess.jsp");
  		  }
  		  else if(result==-1) {
  			res.sendRedirect("/CSS/adminpwdwrong.html");
  		  }
  		  else {
  			res.sendRedirect("/CSS/adminunwrong.html");
  		  }

        }

}
