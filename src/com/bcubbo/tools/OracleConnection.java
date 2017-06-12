package com.bcubbo.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class OracleConnection {
	
	private static Connection connection;
	private static OracleConnection orclCon;
	public OracleConnection(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//因为在此进行了链接的启动，所以和mysql中的链接不一样。
			//其在一开始的时候就进行了链接的创建所以在整个运行的项目中使用的都是一个链接
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:bcubbo","bcubbo","BcubBo001");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static OracleConnection getInstance(){
		
		if(orclCon ==null){
			//双重校验
			synchronized(OracleConnection.class){
				
				if(orclCon ==null){
					
					orclCon = new OracleConnection();
					
					
				}
				
			}
			
			
		}
		
		
		
		
		return orclCon;
				
	
	
	};
	public Connection getConnection(){
		
		return connection;
		
		
	}
	
	public static boolean closeResource(Connection connection ,PreparedStatement preparedStatement,ResultSet resultSets){
		boolean flag = true;
		
		if(resultSets!=null){
			
			
			try{
				
				
				resultSets.close();
				resultSets = null;//GC回收
				System.out.println("关闭resultSets成功");
				flag = false;
				
				
			}catch(Exception e){
				
				e.printStackTrace();
				
				
			}
			
			
			
			
			
		}//resultSets关闭
		
		if(preparedStatement!=null){
			
			try {
				preparedStatement.close();
				preparedStatement = null;
				
				System.out.println("关闭preparedStatement成功");
				flag = false;
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			
		}//关闭preparedStatement
		
		if(connection != null){
			
			try{
				
				connection.close();
				connection = null;
				System.out.println("关闭connection成功");
				
				flag = false;
			}catch(Exception e){
				
				
				
				
			}
			
			
		}
		
		
		return flag;
		
		
	}
	
	
}
