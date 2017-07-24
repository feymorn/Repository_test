package com.scdx.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scdx.dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username=request.getParameter("username");
      String password=request.getParameter("password");
      System.out.println("已接收到前台表单数据_用户名:"+username);
      System.out.println("已接收到前台表单数据_用户名:"+password);
      UserDao userDao=new UserDao();
      System.out.println("创建UserDao实例成功"+userDao);
      String ok;
      ok=userDao.register(username,password);
      if(ok.equals("success")){
    	  
    	  response.sendRedirect("success.html");
    	  
      }
      

		
	}

}
