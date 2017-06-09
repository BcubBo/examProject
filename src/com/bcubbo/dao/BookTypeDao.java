package com.bcubbo.dao;

import com.bcubbo.pojo.Users;

public interface BookTypeDao {
	//查询
	public Users queryBooType(String sql,String userCode);
	
	//增加
	public int updateBookType(String sql,Object[] params);
	
	//删除
	public int deleteBookType(String sql, Object[] params);
}
