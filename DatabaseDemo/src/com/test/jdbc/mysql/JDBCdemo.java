package com.test.jdbc.mysql;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
public class JDBCdemo {
public static void main(String[] args) {
	String username="root";
	String password="nirmit";
	String url="jdbc:mysql://localhost:3306/idfc";
	String query="SELECT * FROM experience;";
//	String query1="CREATE TABLE experience(id INT,stu_name VARCHAR(100));";
//	String query1="INSERT INTO experience VALUES(1,'Nirmit'),(2,'Pravin');";
//	String query1="UPDATE experience SET stu_name='John' WHERE id=2;";
//	String query1="DELETE FROM experience where id=2;";
//	String query1="DROP TABLE experience;";
	try {
//		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		Statement st=con.createStatement();
//		st.executeUpdate(query1);
//		System.out.println("Operation Successful");
		ResultSet rs=st.executeQuery(query);
		ResultSetMetaData rm=rs.getMetaData();
		int col=rm.getColumnCount();
		while(rs.next()) {
			for(int i=1;i<=col;i++) {
				System.out.print(rs.getString(i)+" ");
			}
			System.out.println();
		}
		con.close();
//		
	}
	catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}finally {
		
	}
}
}
