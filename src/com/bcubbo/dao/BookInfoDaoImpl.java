package com.bcubbo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bcubbo.tools.OracleConnection;

public class BookInfoDaoImpl implements BookInfoDao {

	
	private static PreparedStatement preparedStatement = null;
	public ResultSet queryBookInfo(Connection connection,PreparedStatement preparedStatements, String sql, Object[] params) throws Exception{
		Connection bookInfoConnection = connection ;
		PreparedStatement preparedStatement = preparedStatements;
		
		ResultSet resultSets = null;

			preparedStatement = bookInfoConnection.prepareStatement(sql);
			for(int i = 0 ;i<params.length;i++){
				preparedStatement.setObject((i+1), params[i]);
				

			 
			
			}
			resultSets = preparedStatement.executeQuery();
/*			this.closeConneciton(bookInfoConnection, null, null);
			this.closeConneciton(null, preparedStatement, null);*/
			
			
		return resultSets;
	}

	public int updateBookInfo(Connection connection,PreparedStatement preparedStatements,String sql, Object[] params) throws Exception{
		Connection bookInfoConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = preparedStatements;
/*		this.closeConneciton(bookInfoConnection, null, null);
		this.closeConneciton(null, preparedStatement, null);
		*/
		return 0;
	}

	public int deleteBookInfo(Connection connection,PreparedStatement preparedStatements,String sql, Object[] params) throws Exception{
		Connection bookInfoConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = preparedStatements;
/*		this.closeConneciton(bookInfoConnection, null, null);
		this.closeConneciton(null, preparedStatement, null);*/
		return 0;
	}	

	public void closeConneciton(Connection connection ,PreparedStatement preparedStatements,
ResultSet resultSets){
		//关闭链接
		
		OracleConnection.closeResource(connection,preparedStatement,resultSets);
		
		
		
	}
	
}
