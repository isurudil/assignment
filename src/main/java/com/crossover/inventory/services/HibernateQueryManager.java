package com.crossover.inventory.services;

import com.crossover.inventory.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

public class HibernateQueryManager<T> {

    private static Logger logger = Logger.getLogger(HibernateQueryManager.class);

    public void executeQuery(T object) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        try {
            transaction.commit();
        } catch (ConstraintViolationException e) {
            transaction.rollback();
            logger.error("Error occurred while inserting to database ", e);
            throw new Exception("Error occurred while adding customer");
        }
    }
}
