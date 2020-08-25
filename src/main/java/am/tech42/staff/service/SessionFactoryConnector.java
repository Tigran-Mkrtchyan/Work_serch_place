package am.tech42.staff.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryConnector {
    private static SessionFactory sessionFactory ;

    private SessionFactoryConnector(){}

    public static synchronized SessionFactory getSessionFactory(){
        if(sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
