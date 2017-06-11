package com.bcubbo.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcubbo.dao.BookInfoDaoImpl;
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/
		String sql = "select book_code,book_name,book_type.type_name,book_info.book_type,book_author,publish_date,is_borrow,createby,creation_time,last_updatetime from book_info inner join book_type on book_info.book_type = book_type.id order by creation_time desc;";
		BookInfoDaoImpl bookInfo = new BookInfoDaoImpl();
		Object[] params = {};
		
		
		try {
			ResultSet resultSets = bookInfo.queryBookInfo(sql, params);
			request.setAttribute("resultSets", resultSets);
			request.getRequestDispatcher("admin.jsp").forward(request,response);
			System.out.println("进行了admin.jsp页面的跳转");
			
			bookInfo.closeConneciton(null, null, resultSets);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
