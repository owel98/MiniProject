package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;
import com.javabeans.Employee;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String empId = request.getParameter("empId");
			String empName = request.getParameter("empName");
			
			HttpSession session = request.getSession();
			PrintWriter writer = response.getWriter();
			
	       	
				EmployeeDAO em = new EmployeeDAO();
				String empEmail = request.getParameter("empEmail");
				Employee emp = new Employee(empId, empName, empEmail);
				
				int uid = em.userLogin(empId,empName);
				session.setAttribute("uid", uid);
				
				session.setAttribute("empName", empName);
				
				 if(em.isUser(emp)) {
					 String html = "<h1 style='color:red'> <center> Is a User... </center> </h1>";
					 writer.println(html);
					 RequestDispatcher req = request.getRequestDispatcher("home.jsp");
					 req.include(request, response);
					 
				 }else {
				String html = "<h1 style='color:red'> <center> Not a User! </center> </h1>";
					writer.println(html);
					
					 RequestDispatcher req = request.getRequestDispatcher("register.jsp");
					req.include(request, response);
				 }

		
	}

}
