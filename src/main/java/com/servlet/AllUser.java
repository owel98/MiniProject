package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.javabeans.Employee;


@WebServlet("/AllUser")
public class AllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO em = new EmployeeDAO();
		List<Employee> list = em.viewAllUsers();
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link type='text/css' rel='stylesheet' href='css/style.css'>");
		out.println("</head>");
		out.println("<body style='background-color:white'>");
		out.println("<font> <center> <h1 style='color:white;text-align:center;margin-top:30px'> Users list </h1> </center> </font>");
		out.println("<table cellspacing='0' width='300px' border='3px solid black' style='margin-left:auto; margin-right:auto;padding:5px;background-color:white'>");
		out.println("<tr>");
		out.println("<th> Employee Id </th>");
		out.println("<th> Employee Name </th>");
		out.println("<th> Employee Email </th>");
		out.println("</tr>");
		for (Employee user : list) {
			out.println("<tr>");
			out.println("<td>" + user.getEmpId() + "</td>");
			out.println("<td>" + user.getEmpName() + "</td>");
			out.println("<td>" + user.getEmpEmail() + "</td>");
			out.println("<td> <a href = 'Delete?empId=" + user.getEmpId() + "'> &#10060" + "</td>");
//			Update?empId=704803&empName=sravani
			out.println("<td> <a href = 'Update?empId=" + user.getEmpId() + "&empName=" + user.getEmpName() + "'> &#9998 </a> </td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<font color=green> <center> <h3 style='color:white;text-align:center;margin-top:30px'> <a href = 'home.jsp' style='color:white;text-align:center;margin-top:30px'> Click here for Main page </a>  </h3> </center> </font> ");
		out.println("</body>");
		out.println("</html>");
	}



}
