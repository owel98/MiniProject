package com.dao;

import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.javabeans.Employee;
import com.jdbc.JDBCConnection;

public class EmployeeDAO {
	public boolean insertRegistration(Employee emp) {
		String query = "insert into registration values(?, ?, ?)";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, emp.getEmpId());
			statement.setString(2, emp.getEmpName());
			statement.setString(3, emp.getEmpEmail());
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private String getDate() {
		String query = "select curdate()";
		PreparedStatement statement;
		String date = null;
		try {
			statement = JDBCConnection.getConnection().prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while(res.next()) { date = res.getString(1); }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
		
	}

	private String getTime() {
		String query = "select curtime()";
		PreparedStatement statement;
		String time = null;
		try {
			statement = JDBCConnection.getConnection().prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while(res.next()) { time = res.getString(1); }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
		
	}
	
	public int userLogin(String empId, String empName) {
		String query = "insert into userdata(empId, empName,date, login) values(?, ?, ?, ?)";
		String uidQuery = "select uid from userdata where login = ? ";
		
		int uid = 0;

		try {
			
			String date = getDate();
			String loginTime = getTime();
			
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, empId);
			statement.setString(2, empName);
			statement.setString(3, date);
			statement.setString(4, loginTime);
			statement.executeUpdate();
			
			PreparedStatement statement1 = JDBCConnection.getConnection().prepareStatement(uidQuery);
			statement1.setString(1, loginTime); ;
			ResultSet res3 = statement1.executeQuery();
			while(res3.next()) { 
				uid = res3.getInt(1); }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uid;
	}

	public List<Employee> viewAllUsers() {
		List<Employee> list = new ArrayList<>();
		Employee user = null;
		String query = "select * from registration";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				user = new Employee();
				user.setEmpId(res.getString(1));
				user.setEmpName(res.getString(2));
				user.setEmpEmail(res.getString(3));

				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteRegistration(String empId) {
		String query = "delete from registration where empId = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, empId);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean updateRegistration(String empId, String empName) {
		String query = "update registration set empName = ? where empId = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, empName);
			statement.setString(2, empId);
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	
	public boolean userLogout(int uid) {
		String logoutTime = getTime();
		String query = "update userdata set logout = ? where uid = ?";

		try {
			PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
			statement.setString(1, logoutTime);
			statement.setInt(2, uid);
			
			return statement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean isUser(Employee emp) {
		String sql="select EXISTS(select * from registration where empId=? and empName=?) as status;";
		try {
			PreparedStatement statement=JDBCConnection.getConnection().prepareStatement(sql);
			statement.setString(1, emp.getEmpId());
			statement.setString(2, emp.getEmpName());
			System.out.println("before result set");
			ResultSet status=statement.executeQuery();
			System.out.println("After resultset");
			int userornot=0;
			while(status.next()) {
				userornot=status.getInt("status");
			}
			if(userornot==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean isValidUser(int empId, String empName) {
        String query = "select * from registration where empId = ?";
        int userCount = 0;
        String name = null;
        
        try {
            PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(query);
            statement.setInt(1, empId);
            ResultSet res = statement.executeQuery();
            
            while(res.next()) {
                userCount++;
                name = res.getString(2);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return userCount == 1 && name.equals(empName);
    }
}




