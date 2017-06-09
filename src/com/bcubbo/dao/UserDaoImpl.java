package com.bcubbo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bcubbo.tools.OracleConnection;

public class UserDaoImpl implements UserDao {
	private Connection userConnection = OracleConnection.getInstance().getConnection();
	private PreparedStatement preparedStatement = null;
	public ResultSet queryUsers(String sql, Object[] params) throws Exception  {
		
		
		
		preparedStatement = userConnection.prepareStatement(sql);
		
		for(int i = 0 ;i<params.length;i++){
			preparedStatement.setObject((i+1), params[i]);
			
		}
		ResultSet resultSets = null;
		resultSets = preparedStatement.executeQuery();
		
		
		
		
		
		
		
		
		return resultSets;
	}

	public int updateUsers(String sql, Object[] params) throws Exception {
		return 0;
	}

	public int deleteUsers(String sql, Object[] params) throws Exception {
		return 0;
	}




	
}
