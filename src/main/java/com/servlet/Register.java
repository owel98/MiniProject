package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.javabeans.Employee;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO em=new EmployeeDAO();
		String empId=request.getParameter("empId");
		String empName=request.getParameter("empName");
		String empEmail=request.getParameter("empEmail");
		Employee emp=new Employee(empId,empName,empEmail);
		PrintWriter writer = response.getWriter();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpEmail(empEmail);
		response.setContentType("text/html");
		if (em.insertRegistration(emp)) {
			writer.println("<h1 style='color:green'> <center> Registered successfully! </center> </h1>");
			RequestDispatcher req = request.getRequestDispatcher("index.jsp");
			req.include(request, response);
		}
		
		else {
			writer.println("<h1 style='color:red'> <center> Could not register! </center> </h1>");
			writer.println("<font color=dodgerblue> <center> <h2> <a href = 'index.jsp'> Click here for Login page </a>  </h2> </center> </font> ");
		}
		

	}

}
