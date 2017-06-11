package com.bcubbo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.bcubbo.dao.UserDaoImpl;
import com.bcubbo.tools.OracleConnection;

public class UserNameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserNameCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		Connection connection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSets  = null;
		
		HashMap<String,String> resultMap = new HashMap<String,String>();

		String method= request.getParameter("method");
		System.out.println(method);

		UserDaoImpl userDataAccess = new UserDaoImpl();
		if(method.equals("checkAccountExist")){
			//当method为只检查是否存在用户的时候
			String userCode = request.getParameter("userCode");
			Object[] params = {userCode};
			System.out.println("userCode从ajax请求中获取<"+userCode+">");
			String sql  =  "select * from users where user_code =?";
			try {
				resultSets = userDataAccess.queryUsers(connection,preparedStatement,sql, params);
				//用户数据访问;
				if(resultSets.next()){
					System.out.println("从数据库中输出的ResultSets结果集中含有数据");
					
					
					
						
						resultMap.put("result", "true");
						response.setContentType("application/json");
						PrintWriter outPrintWriter = response.getWriter();
						
						outPrintWriter.write(JSONArray.toJSONString(resultMap));
						outPrintWriter.flush();
						outPrintWriter.close();
						resultMap.clear();
						
						
					
					
					
				}else{
					System.out.println("从数据库中输出的ResultSets结果集中不含有数据");
					
					resultMap.put("result", "false");
					response.setContentType("application/json");
					PrintWriter outPrintWriter = response.getWriter();
					
					outPrintWriter.write(JSONArray.toJSONString(resultMap));
					outPrintWriter.flush();
					outPrintWriter.close();
					resultMap.clear();
					
					
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			
			}finally{
				
/*				OracleConnection.closeResource(null, preparedStatement, null);
				OracleConnection.closeResource(connection, null, null);
				OracleConnection.closeResource(null, null, resultSets);*/
				
				
			}
		
		
	}
		System.out.println("用户名检查结尾");
		System.out.println(request.getParameter("method"));
		System.out.println("跳出UserNameCheck");
		
	
		
}//doGet方法结尾

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
