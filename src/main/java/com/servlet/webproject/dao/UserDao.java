package com.servlet.webproject.dao;

import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;

import com.servlet.webproject.configuration.SessionProvider;
import com.servlet.webproject.models.User;

public class UserDao {

	private Session session = SessionProvider.getSession();
	
	public void register(User user) {
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}
	
	public boolean login(String email, String password) {
		Query<User> query = session.createQuery("FROM User u WHERE u.email =:email");
		query.setParameter("email", email);
		User user = null;
		try {
			 user = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("User not found !!");
		}
		
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public void resetPassword(String email, String password) {
		Transaction tx = session.beginTransaction();
		Query<User> query = session.createQuery("UPDATE User SET password=:password WHERE email =:email");
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.executeUpdate();
		tx.commit();
	}
}
