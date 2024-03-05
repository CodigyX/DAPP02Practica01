package org.uv.dapp02practica01;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Codigy
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        try{
            //Create the SessionFactory from standard ("hibernate.cfg.xml")
            //config.file.
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
