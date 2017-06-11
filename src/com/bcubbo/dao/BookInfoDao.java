package com.bcubbo.dao;

import java.sql.ResultSet;

public interface BookInfoDao {

	//查询
	public ResultSet queryBookInfo(String sql,Object[] params)throws Exception;
	
	//增加
	public int updateBookInfo(String sql,Object[] params)throws Exception;
	
	//删除
	public int deleteBookInfo(String sql, Object[] params)throws Exception;
	
	
}
