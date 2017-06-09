package com.bcubbo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.bcubbo.dao.UserDaoImpl;
import com.bcubbo.tools.OracleConnection;


public class LoginSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginSerlvet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		System.out.println("进入doGet()");
		doPost(request,response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		HashMap<String,String> resultMap = new HashMap<String,String>();

		String method = request.getParameter("method");
		ResultSet resultSets = null;
		String userCodeReCall = null;
		String passwordReCall = null;
		UserDaoImpl userDataAccess = new UserDaoImpl();
		if(method.equals("checkAccountExist")){
			//当method为只检查是否存在用户的时候
			String userCode = request.getParameter("userCode");
			Object[] params = {userCode};
			System.out.println("userCode从ajax请求中获取<"+userCode+">");
			String sql  =  "select * from users where user_code =?";
			try {
				resultSets = userDataAccess.queryUsers(sql, params);
				//;
				if(resultSets.next()){
					System.out.println("输出的ResultSets结果集中含有数据");
					userCodeReCall = resultSets.getString("user_code");
					System.out.println("userCodeReCall>>>>>>"+userCodeReCall);
					
					
					
						
						resultMap.put("result", "true");
						response.setContentType("application/json");
						PrintWriter outPrintWriter = response.getWriter();
						
						outPrintWriter.write(JSONArray.toJSONString(resultMap));
						outPrintWriter.flush();
						outPrintWriter.close();
						resultMap.clear();
						
						
					
					
					
				}else{
					
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
			}
			
		}else if(method.equals("loginCheck")){
			//当进行整体验证的时候
			String userCode = request.getParameter("userCode");
			System.out.println("userCode从请求中获取<"+userCode+">");
			String password = request.getParameter("password");
			System.out.println("password从请求中获取<"+password+">");
			Object[] params = {userCode};
			String sql  =  "select * from users where user_code =?";
			
			

			try {
				resultSets = userDataAccess.queryUsers(sql, params);
				//;
				if(resultSets.next()){
					System.out.println("进入loginCheck块");
					System.out.println("输出的ResultSets结果集中含有数据");
					userCodeReCall = resultSets.getString("user_code");
					System.out.println("userCodeReCall>>>>>>"+userCodeReCall);
					passwordReCall = resultSets.getString("password");
					System.out.println("passwordReCall>>>>>>"+passwordReCall);
					if(password.equals(passwordReCall) && userCode.equals(userCodeReCall)){
						System.out.println("验证成功进入admin.jsp块");
						resultMap.put("result", "true");
						response.setContentType("application/json");
						PrintWriter outPrintWriter = response.getWriter();
						
						outPrintWriter.write(JSONArray.toJSONString(resultMap));
						outPrintWriter.flush();
						outPrintWriter.close();
						resultMap.clear();
						System.out.println("跳出验证块");
						
					}
					
					
				}else{
					
					resultMap.put("result", "false");
					response.setContentType("application/json");
					PrintWriter outPrintWriter = response.getWriter();
					
					outPrintWriter.write(JSONArray.toJSONString(resultMap));
					outPrintWriter.flush();
					outPrintWriter.close();
					
					
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		

		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
	}

}
