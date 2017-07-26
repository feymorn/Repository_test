package com.scdx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.scdx.bean.User;

public class UserDao {
	

	private static String URL="jdbc:mysql://localhost:3306/scdx?characterEncoding=utf-8" ;
	private static String USER="root" ;
	private static String PASSWORD="root" ;
	private static Connection conn=null ;
	
	public String register(String id,String pwd){
		
		System.out.println("UserDao.register:开始连接数据库");
		
		
		
          try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("已找到JDBC驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
          
          
          try {
			conn=DriverManager.getConnection(URL,USER,PASSWORD) ;
			System.out.println("连接已经建立");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
          
          try {
			Statement stmt=(Statement) conn.createStatement();
			System.out.println("已经建立声明对象Statement");
			String sql="insert into  user(username,password) values('"+id+"','"+pwd+"');";
			
			System.out.println("将执行sql:"+sql);
			stmt.executeUpdate(sql);
			
			stmt.close();
			System.out.println("关闭声明对象Statment成功");
			conn.close();
			System.out.println("关闭连接成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         
		return "success";
	}
	
	
	public User query(String keyword){
				
		 User user=new User();
		
		System.out.println("UserDao.query:开始连接数据库");
		
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("已找到JDBC驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        
        try {
			conn=DriverManager.getConnection(URL,USER,PASSWORD) ;
			System.out.println("连接已经建立");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        
        try {
			Statement stmt=(Statement) conn.createStatement();
			System.out.println("UserDao.query:已经建立声明对象Statement");
			String sql="select * from  user where username='"+keyword+"';";
			
			System.out.println("UserDao.query:将执行sql:"+sql);
			ResultSet rs=stmt.executeQuery(sql);
			
				
				if(rs.next()){
					user.setUsername(rs.getString(1));
					System.out.println("UserDao.query:已经获得username值:"+rs.getString(1));
					user.setPassword(rs.getString(2));
					System.out.println("UserDao.query:已经获得password值:"+rs.getString(2));
				}
			
			stmt.close();
			System.out.println("UserDao.query:关闭声明对象Statment成功");
			conn.close();
			System.out.println("UserDao.query:关闭连接成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		
		
       
		return user;
	}
	
	
	public <T> ArrayList getUserList(){
		ResultSet rs=null;
		ArrayList<User> list=new ArrayList<>();
		User user=new User();
		System.out.println("UserDao.getUserList:开始连接数据库");
		
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("已找到JDBC驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			conn=DriverManager.getConnection(URL,USER,PASSWORD) ;
			System.out.println("UserDao.getUserList:连接已经建立");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try{
        Statement stmt=(Statement) conn.createStatement();
		System.out.println("UserDao.query:已经建立声明对象Statement");
		String sql="select * from  user;";
		System.out.println("UserDao.getUserList:将执行sql:"+sql);
		 rs=stmt.executeQuery(sql);
		 int m=rs.getMetaData().getColumnCount();
	//	 ResultSetMetaData meta=rs.getMetaData();
		System.out.println("有"+m+"列");
		
		
			for(int i=1;i<=m;i++){
				System.out.println(rs.getMetaData().getColumnName(i));
				System.out.println("\t\t");
		 
		}
			while(rs.next()){
				User u=new User();
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				System.out.print(rs.getString(1)+"/");
				System.out.println(rs.getString(2));
				list.add(u);
				
			}
			 
			stmt.close();
			System.out.println("UserDao.getUserList:关闭声明对象Statment成功");
			conn.close();
			System.out.println("UserDao.getUserList:关闭连接成功");
		
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
		
	}
	

}
