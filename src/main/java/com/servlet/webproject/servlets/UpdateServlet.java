package com.servlet.webproject.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.webproject.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Register</title>\r\n" + "</head>\r\n"
				+ "<body style=\"background:blue;text-align:center;\">\r\n"
				+ "	<div style=\"margin-top:200px;border:2px solid red;width:500px;margin-left:400px;background:skyblue;\">\r\n"
				+ "		<form action=\"update\" method=\"post\">\r\n" + "		<h1>Reset Password</h1>\r\n"

				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<input type=\"password\" name=\"password\" placeholder=\"Enter Password\">\r\n"
				+ "			</div>\r\n"

				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<input type=\"password\" name=\"confirmPassword\" placeholder=\"Enter Password\">\r\n"
				+ "			</div>\r\n"
				
				+ "			<div style=\"padding-top:20px;\">\r\n"
				+ "				<button type=\"submit\">Reset</button>\r\n" + "			</div>\r\n"
				+ "		</form>\r\n" + "	</div>\r\n" + "</body>\r\n" + "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		String email = (String) req.getSession().getAttribute("email");
		PrintWriter out = resp.getWriter();
		if(password.equals(confirmPassword)) {
			UserDao userDao = new UserDao();
			userDao.resetPassword(email, confirmPassword);
			out.write("<h1>Successfully Reset !!</h1>");
		}
		else {
			out.write("<h1>Something went wrong !!</h1>");
		}
	}
}
