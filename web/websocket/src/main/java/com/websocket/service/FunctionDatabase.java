package com.websocket.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.websocket.model.ThietBi;

public class FunctionDatabase {
	private static Connection getConnection()
	{
		
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/doan2";
			String username = "root";
			String password = "123456";
			Connection connection = (Connection) DriverManager.getConnection(url, username,password);
			return connection;
		} catch (SQLException  | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		 return null;
	}
	public static List<ThietBi> getAll()
	{
		Connection connection = getConnection();
		List<ThietBi> listResult = new ArrayList<ThietBi>();
		if(connection != null)
		{
			try {
				String sql = "select * from thietbi";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while(result.next())
				{
					boolean valueDen1 =  result.getBoolean("den1");
					boolean valueDen2 = result.getBoolean("den2");
					boolean valueChedo = result.getBoolean("chedo");
					boolean valueQuat = result.getBoolean("quat");
					String valueNhiedo = result.getString("nhietdo");
					ThietBi den1 = new ThietBi("den1",valueDen1);
					ThietBi den2 = new ThietBi("den2", valueDen2);
					ThietBi chedo = new ThietBi("chedo", valueChedo);
					ThietBi quat = new ThietBi("quat", valueQuat);
					ThietBi nhietdo = new ThietBi("nhietdo", valueNhiedo);
					listResult.add(den1);
					listResult.add(den2);
					listResult.add(chedo);
					listResult.add(quat);
					listResult.add(nhietdo);
					//list.add(mapper.mapRow(rs));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listResult;
	}
	public static int update(ThietBi x)
	{
		Connection connection = getConnection();
		int result = 0;
		if(connection != null)
		{
			try {
				String sql = createSql(x);
				Statement statement = connection.createStatement();
				result = statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	private static String createSql(ThietBi x)
	{
		String s = "update thietbi set";
		if(x.getName().equals("den1"))
			s = s + " den1 = " + x.isStatus();
		else if(x.getName().equals("den2"))
			s = s + " den2 = " + x.isStatus();
		else if(x.getName().equals("quat"))
			s = s + " quat = " + x.isStatus();
		return s;
	}
}
