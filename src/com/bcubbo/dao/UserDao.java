package com.bcubbo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface UserDao {
	
	//查询
	public ResultSet queryUsers(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params )throws Exception ;
	
	
	
	//增加
	public int updateUsers(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params)throws Exception;
	
	//删除
	public int deleteUsers(Connection connection,PreparedStatement preparedStatement,String sql, Object[] params)throws Exception;
	
	
	
	
}
