package com.bcubbo.dao;

import java.sql.ResultSet;

public interface UserDao {
	
	//查询
	public ResultSet queryUsers(String sql,Object[] params )throws Exception ;
	
	
	
	//增加
	public int updateUsers(String sql,Object[] params)throws Exception;
	
	//删除
	public int deleteUsers(String sql, Object[] params)throws Exception;
	
	
	
	
}
