package com.bcubbo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bcubbo.tools.OracleConnection;

public class UserDaoImpl implements UserDao {
 
	public ResultSet queryUsers(String sql, Object[] params) throws Exception  {
		
		Connection userConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		preparedStatement = userConnection.prepareStatement(sql);
		
		for(int i = 0 ;i<params.length;i++){
			preparedStatement.setObject((i+1), params[i]);
			
		}
		ResultSet resultSets = null;
		resultSets = preparedStatement.executeQuery();

		//在servlet中进行resultSets的关闭
		
		
		
		
		
		
		
		return resultSets;
	}

	public int updateUsers(String sql, Object[] params) throws Exception {
		Connection userConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		int updateRows = 0 ;
		preparedStatement = userConnection.prepareStatement(sql);
		
		for(int i = 0 ;i<params.length;i++){
			
			preparedStatement.setObject((i+1), params[i]);
			
			
		}
		
		updateRows = preparedStatement.executeUpdate();

		
		return updateRows;
		
	}

	public int deleteUsers(String sql, Object[] params) throws Exception {
		Connection userConnection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		this.closeConneciton(userConnection, null, null);
		this.closeConneciton(null, preparedStatement, null);
		return 0;
	}

	public void closeConneciton(Connection connection ,PreparedStatement preparedStatement,
ResultSet resultSets){
		
		OracleConnection.closeResource(connection,preparedStatement,resultSets);
		
		
		
	}	

	
}
