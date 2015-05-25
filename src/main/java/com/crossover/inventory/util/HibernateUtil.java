package com.crossover.inventory.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Logger logger = Logger.getLogger(HibernateUtil.class);

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        getSessionFactory().close();
    }

    public static void insert(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        try {
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error occurred while inserting to database ", e);
            throw new Exception("Error occurred while adding customer");
        } finally {
            closeSession(session);
        }
    }

    public static List getAll(String sql) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List entityList = null;
        try {
            transaction = session.beginTransaction();
            entityList = session.createQuery(sql).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error occurred while reading from database", e);
        } finally {
            session.close();
        }
        return entityList;
    }

    private static void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }

    private void buildSessionFactory() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            throw new ExceptionInInitializerError(ex);
        }
    }
}
