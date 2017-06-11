package com.bcubbo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface BookInfoDao {

	//查询
	public ResultSet queryBookInfo(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params)throws Exception;
	
	//增加
	public int updateBookInfo(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params)throws Exception;
	
	//删除
	public int deleteBookInfo(Connection connection,PreparedStatement preparedStatement,String sql, Object[] params)throws Exception;
	
	
}
