package com.bcubbo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcubbo.dao.BookInfoDaoImpl;
import com.bcubbo.pojo.BookInfo;
import com.bcubbo.tools.OracleConnection;
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		String sql = "select book_code,book_name,book_type.type_name,book_info.book_type,book_author,publish_date,is_borrow,createby,creation_time,last_updatetime from book_info inner join book_type on book_info.book_type = book_type.id order by creation_time desc";
		BookInfoDaoImpl bookInfo = new BookInfoDaoImpl();
		
		Object[] params = {};
		Connection connection = OracleConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSets  = null;
		
		try {
			resultSets = bookInfo.queryBookInfo(connection,preparedStatement,sql, params);
			List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
			

			
			
			while(resultSets.next()){
				BookInfo bookItem = new BookInfo();
				bookItem.setBookName(resultSets.getString("book_name"));
				bookItem.setBookCode(resultSets.getString("book_code"));
				bookItem.setTypeName(resultSets.getString("type_name"));
				bookItem.setBookType(Integer.parseInt(resultSets.getString("book_type")));
				bookItem.setBookAuthor(Integer.parseInt(resultSets.getString("book_author")));
				bookItem.setPublishPress(resultSets.getString("publish_date"));
				bookItem.setIsBorrow(Integer.parseInt(resultSets.getString("is_borrow")));
				bookItem.setCreateBy(resultSets.getString("createby"));
				bookItem.setCreationTime(resultSets.getDate("creation_time"));
				bookItem.setLastUpdateTime((resultSets.getDate("last_updatetime")));		
				bookInfoList.add(bookItem);
				System.out.println("上次更新时间为"+resultSets.getString("last_updatetime"));
				
				
			}
			
			String userCode = request.getParameter("user_code");
			request.setAttribute("userCode", userCode);
			//获取用户名
			request.setAttribute("bookInfoList", bookInfoList);
			//设置返回的数据集合
			request.getRequestDispatcher("admin.jsp").forward(request,response);
			//请求调度器调度request
			System.out.println("进行了admin.jsp页面的跳转");
			

			//在此关闭resultSets
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
/*			OracleConnection.closeResource(null, preparedStatement, null);
			OracleConnection.closeResource(connection, null, null);
			OracleConnection.closeResource(null, null, resultSets);*/
			
			//关闭链接
			
			
			
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
