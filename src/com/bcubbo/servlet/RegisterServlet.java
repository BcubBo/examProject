package com.bcubbo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.bcubbo.dao.UserDaoImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		
		request.getParameter("");
		HashMap<String,String> resultMap = new HashMap<String,String>();

		String method = request.getParameter("method");
		ResultSet resultSets = null;
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
			
			}
		
		
	}//if条件结尾
		
}//doGet方法结尾

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
