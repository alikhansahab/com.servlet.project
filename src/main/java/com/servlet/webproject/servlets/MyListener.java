package com.servlet.webproject.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyListener implements HttpSessionListener{
	
	private int total = 0;
	private int current = 0;
	ServletContext context = null;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		current++;
		total++;
		context = se.getSession().getServletContext();
		context.setAttribute("total", total);
		context.setAttribute("current", current);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		current--;
		context.setAttribute("current", current);
	}
}
