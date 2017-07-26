package com.scdx.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scdx.bean.User;
import com.scdx.dao.UserDao;

/**
 * Servlet implementation class Query
 */
@WebServlet("/Query")
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String keyword;
			keyword=request.getParameter("query");
			System.out.println("已获得查询关键词:"+keyword);
			User u=new User();
			UserDao ud=new UserDao();
			//u=ud.query(keyword);
			List list=ud.getUserList();
		    request.setAttribute("list", list);
		    System.out.println("list列表信息:"+list);
		    System.out.println("已经在request中设置list对象");
			System.out.println("Query.doGet已获得返回的用户名:"+u.getUsername());
			System.out.println("Query.doGet已获得返回的密码:"+u.getPassword());
			request.setAttribute("username", u.getUsername());
			request.setAttribute("password",u.getPassword());
//			
//			System.out.println("request.getAuthType:"+request.getAuthType());
//			System.out.println("request.getCharacterEncoding:"+request.getCharacterEncoding());
//			System.out.println("request.getContentType:"+request.getContentType());
//			System.out.println("request.getLocalAddr:"+request.getLocalAddr());
//			System.out.println("request.getLocalName:"+request.getLocalName());
//			System.out.println("request.getLocalPort:"+request.getLocalPort());
//			System.out.println("request.getRemoteAddr:"+request.getRemoteAddr());
//			
//			System.out.println("request中已存入数据:"+request.getAttribute("username"));
//			System.out.println("request中已存入数据:"+request.getAttribute("password"));
//			
		HttpSession session = request.getSession();
//			System.out.println("创建session");
		session.setAttribute("abc", "session ok");
//			session.setAttribute("abc", "session ok1");
//			session.setAttribute("abd", "abd");
//			System.out.println("session大小:"+session);
//			ServletContext app=this.getServletContext();
//			app.setAttribute("app", "this is a application scope");  
			
			System.out.println("准备页面跳转");
			request.getRequestDispatcher("success.jsp").forward(request, response);
			System.out.println("页面跳转成功");
			
			

		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
