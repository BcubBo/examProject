package com.bcubbo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bcubbo.tools.OracleConnection;

public class BookInfoDaoImpl implements BookInfoDao {



	public ResultSet queryBookInfo(String sql, Object[] params) throws Exception{
		Connection bookInfoConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		
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

	public int updateBookInfo(String sql, Object[] params) throws Exception{
		Connection bookInfoConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
/*		this.closeConneciton(bookInfoConnection, null, null);
		this.closeConneciton(null, preparedStatement, null);
		*/
		return 0;
	}

	public int deleteBookInfo(String sql, Object[] params) throws Exception{
		Connection bookInfoConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
/*		this.closeConneciton(bookInfoConnection, null, null);
		this.closeConneciton(null, preparedStatement, null);*/
		return 0;
	}	

	public void closeConneciton(Connection connection ,PreparedStatement preparedStatement,
ResultSet resultSets){
		//关闭链接
		
		OracleConnection.closeResource(connection,preparedStatement,resultSets);
		
		
		
	}
	
}
