package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO em = new EmployeeDAO();
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link type='text/css' rel='stylesheet' href='css/style.css'>");
		out.println("</head>");
		out.println("<body>");
		
		if (em.updateRegistration(empId, empName)) {
			out.println("<font color=green> <center> <h2> Employee name with Employee ID - " + empId
					+ " has been updated </h2> </center> </font>");
		}
		
		else {
			out.println("<font color=red> <center> <h2> Could not update the employee name </h2> </center> </font> ");
		}
		
		out.println("<font color=dodgerblue> <center> <h2> <a href = 'home.jsp'> Click here for Main page </a>  </h2> </center> </font> ");
		out.println("</body>");
		out.println("</html>");
	

	}

}
