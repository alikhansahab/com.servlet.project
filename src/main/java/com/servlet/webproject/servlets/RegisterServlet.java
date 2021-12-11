package com.servlet.webproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.webproject.dao.UserDao;
import com.servlet.webproject.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Register</title>\r\n"
				+ "</head>\r\n"
				+ "<body style=\"background:blue;text-align:center;\">\r\n"
				+ "	<div style=\"margin-top:200px;border:2px solid red;width:500px;margin-left:400px;background:skyblue;\">\r\n"
				+ "		<form action=\"register\" method=\"post\">\r\n"
				+ "		<h1>Register Here</h1>\r\n"
				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<input type=\"text\" name=\"name\" placeholder=\"Enter Name\">\r\n"
				+ "			</div>\r\n"
				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<input type=\"email\" name=\"email\" placeholder=\"Enter Email\">\r\n"
				+ "			</div>\r\n"
				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<input type=\"password\" name=\"password\" placeholder=\"Enter Password\">\r\n"
				+ "			</div>\r\n"
				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<button type=\"submit\">Register</button>\r\n"
				+ "			</div>\r\n"
				+ "		</form>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		
		UserDao userDao = new UserDao();
		userDao.register(user);
		resp.getWriter().write("<h1>Registration Successfull !!</h1>");;
	}
}
