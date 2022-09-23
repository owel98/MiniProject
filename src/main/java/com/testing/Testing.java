package com.testing;

import java.sql.Connection;

import java.sql.SQLException;

import com.dao.EmployeeDAO;
import com.jdbc.JDBCConnection;

public class Testing {
    public boolean isConnected() throws SQLException {
        Connection con = JDBCConnection.getConnection();
        return con  != null;
        
    }
    
    public int isUser() {
        
        EmployeeDAO dao = new EmployeeDAO();
        int empId = 704803;
        String empName = "Sravani";
       
//        int empId = 123456;
//        String empName = "Varsha";
        
        boolean isValidUser = dao.isValidUser(empId, empName);
        if (isValidUser) return 1;
        return 0;
        
    }
}


