package com.zubentsov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	  
	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String login = "hbstudent";
		String password = "hbstudent";
			
			try {
				Connection conn=DriverManager.getConnection(jdbcUrl,login,password);
				System.out.println("connection open ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
