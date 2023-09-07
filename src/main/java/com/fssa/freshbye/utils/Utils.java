package com.fssa.freshbye.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//public class Utils {
//	public static Connection getConnection(){
//		final String DB_URL;
//		final String DB_USER;
//		final String DB_PASSWORD;
//		
//			DB_URL = "jdbc:mysql://164.52.216.41:3306/logesh_venkatesan_corejava_project";
//			DB_USER = "crWfn2h2TAXX";
//			DB_PASSWORD = "3d11bc4f-1eb2-4b7c-99b0-bab25501c6d6";
//		
//		
//			 try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//				} catch (SQLException e) {
//					e.printStackTrace();
//					throw new RuntimeException("Unable to Connect to Database", e);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//					throw new RuntimeException("Database Driver class Not found", e);
//				}
//	}
//}
