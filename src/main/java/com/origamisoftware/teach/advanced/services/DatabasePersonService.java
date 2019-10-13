package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.PersonStockSymbol;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DatabasePersonService implements PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPerson() throws PersonServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;

    }

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     */
    @Override
    public void addOrUpdatePerson(Person person) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }

    /**
     * Get a list of all a person's stock symbols.
     *
     * @param person the person
     * @return a list of stock symbols
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<String> getSymbols(Person person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<String> symbols = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(String.class);
            criteria.add(Restrictions.eq("person", person));
            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            List<PersonStockSymbol> list = criteria.list();
            for (PersonStockSymbol personStockSymbol : list) {
                symbols.add(personStockSymbol.getSymbol());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return symbols;

    }

    /**
     * Assign a stock symbol to a person.
     *
     * @param symbol  The symbol to assign
     * @param person The person to assign the hobby too.
     */
    @Override
    public void addSymbolToPerson(String symbol, Person person) {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            PersonStockSymbol personStockSymbol = new PersonStockSymbol();
            personStockSymbol.setSymbol(symbol);
            personStockSymbol.setPerson(person);
            session.saveOrUpdate(personStockSymbol);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
}
