package com.bcubbo.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcubbo.dao.UserDaoImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HashMap<String,String> resultMap = new HashMap<String,String>();*/

		String methodCheck= request.getParameter("methodCheck");
		System.out.println("method的值为"+methodCheck);
		
		if(methodCheck==null){
			
			
			
		}else{
			
			if(methodCheck.equals("register")){
				
				//method参数值为register的时候进行注册操作
				String userCode = request.getParameter("user_code");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String gender = request.getParameter("gender");
				
				System.out.println("进入登陆块中");
				System.out.println("method方法为register:<"+userCode+">");
				System.out.println("method方法为register:<"+password+">");
				
				System.out.println("method方法为register:<"+email+">");
				System.out.println("method方法为register:<"+gender+">");
				UserDaoImpl userDao = new UserDaoImpl();
				Date date = new Date();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String registerDate = format.format(date);
				/*String oracleDate = registerDate;
				String oracleDateLogin = "To_Date('"+registerDate+"','dd-mm-yyyy')";*/
				String sql = "insert into users values(users_seq.nextval,?,?,?,?,To_Date('"+registerDate+"'"+",'dd-mm-yyyy'),To_Date('"+registerDate+"'"+",'dd-mm-yyyy'))";
				Object[] params = {userCode,password,email,gender};
				for(int i = 0;i<params.length;i++){
					
					System.out.println("插入的数据为"+params[i]);
					
					
				}
				try {
					
					int result = userDao.updateUsers(sql, params);
					if(result>0){
						
						System.out.println("添加成功条数为:<"+result+">");
						String sqlCommit = "commit";
						Object[] commitParam = {};
						if(userDao.updateUsers(sqlCommit,commitParam)==0){
							
							System.out.println("提交更改成功");
							//request.getSession().setAttribute("userCode", userCode);
							
							request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
							
							
						}else{
							
							System.out.println("提交失败");
							
						};
						
						
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
	/*			resultMap.put("result", "true");
				response.setContentType("application/json");
				PrintWriter outPrintWriter = response.getWriter();
				
				outPrintWriter.write(JSONArray.toJSONString(resultMap));
				outPrintWriter.flush();
				outPrintWriter.close();
				resultMap.clear();*/
				
				
				
				
			}
			System.out.println("用户名检查第二部分结尾");//if条件结尾
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
