package com.bcubbo.dao;

import com.bcubbo.pojo.Users;

public interface BookInfoDao {

	//查询
	public Users queryBookInfo(String sql,String userCode);
	
	//增加
	public int updateBookInfo(String sql,Object[] params);
	
	//删除
	public int deleteBookInfo(String sql, Object[] params);
	
	
}
