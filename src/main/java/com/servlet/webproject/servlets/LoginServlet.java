package com.servlet.webproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.webproject.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This post method for login servlet !!");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email+"  "+password);
		UserDao userDao = new UserDao();
		if(userDao.login(email, password)) {
			PrintWriter out = resp.getWriter();
			out.write("<h1>Login Successfully !!</h1>");
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
		} else {
			resp.sendRedirect("index.html");
//			req.getRequestDispatcher("index.html").forward(req, resp);
//			System.out.println("Redirect to login");
		}
		
	}
}
