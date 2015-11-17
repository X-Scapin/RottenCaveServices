package org.isep.rottencave.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.isep.rottencave.model.PlayerResult;
import org.rottencave.util.HibernateSessions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSessionTest.class);
	
	public static void main(String[] args) {
		PlayerResult pr = new PlayerResult(new Date(), 130, "DirtyPlayer");

		//Get Session
        SessionFactory sessionFactory = HibernateSessions.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(pr);
        //Commit transaction
        session.getTransaction().commit();
        LOGGER.debug("PlayerResult ID="+pr.getId());
         
        //terminate session factory
        sessionFactory.close();
	}
}
