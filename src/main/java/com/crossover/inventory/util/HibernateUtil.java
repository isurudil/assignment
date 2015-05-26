package com.crossover.inventory.util;

import com.crossover.inventory.entity.BaseEntity;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
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

    public static void saveOrUpdate(Object object) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(object);
        try {
            transaction.commit();
            session.flush();
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
        List entityList = null;
        try {
            entityList = session.createQuery(sql).list();
        } catch (HibernateException e) {
            logger.error("Error occurred while reading from database", e);
        } finally {
            session.close();
        }
        return entityList;
    }

    public static List getBy(String entityName, String parameter, String value) {
        Session session = sessionFactory.openSession();
        List list = null;
        String sql = "FROM " + entityName + " WHERE " + parameter + " = :parameterValue";
        try {
            Query query = session.createQuery(sql);
            query.setParameter("parameterValue", value);
            list = query.list();
        } catch (HibernateException e) {
            logger.error("Error occurred while reading from database", e);
        } finally {
            session.close();
        }
        return list;
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
