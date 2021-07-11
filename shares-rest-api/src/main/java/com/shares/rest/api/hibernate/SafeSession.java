package com.shares.rest.api.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface SafeSession {

	default Session getTangibleSession(SessionFactory sessionFactory) {
		try {
			return sessionFactory.getCurrentSession();
		}
		catch(Exception ex) {
			return sessionFactory.openSession();
		}
	}	
}
