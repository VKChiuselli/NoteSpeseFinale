package com.nsi.dao;

import com.nsi.utility.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by acerioni on 06/09/2016.
 */
public class GenericDao<T> implements  GenericDaoInterface<T>{
    private final SessionFactory sessionFactory;

    public GenericDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
        if (sessionFactory == null) {
            throw new RuntimeException("Session factory is null!!!");
        }
    }

    @Override
    public T get(Class<T> cl, String id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        T element = session.get(cl, id);
        session.getTransaction().commit();
        session.close();
        return element;
    }

    @Override
    public T save(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
        return object;
    }

    @Override
    public void update(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }



    @SuppressWarnings("unchecked")
    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        List<T> result;
        try (Session session = sessionFactory.openSession()) {
            result = null;
            if ((!hsql.toUpperCase().contains("DELETE"))
                    && (!hsql.toUpperCase().contains("UPDATE"))
                    && (!hsql.toUpperCase().contains("INSERT"))) {

                session.beginTransaction();
                Query query = session.createQuery(hsql);
                if (params != null) {
                    params.keySet().stream().forEach((i) -> {
                        query.setParameter(i, params.get(i));
                    });
                }
                result = query.list();
                session.getTransaction().commit();
            }
        }
        return result;
    }


@SuppressWarnings("unchecked")
@Override
public ObservableList<T> filtrableQuery(String hsql, Map<String, Object> params) {
    ObservableList<T> result = FXCollections.observableArrayList();
    try (Session session = sessionFactory.openSession()) {
        if ((!hsql.toUpperCase().contains("DELETE"))
                && (!hsql.toUpperCase().contains("UPDATE"))
                && (!hsql.toUpperCase().contains("INSERT"))) {

            session.beginTransaction();
            Query query = session.createQuery(hsql);
            if (params != null) {
                params.keySet().stream().forEach((i) -> {
                    query.setParameter(i, params.get(i));
                });
            }
            result.setAll(query.list());
            session.getTransaction().commit();
        }
    }
    return result;
}

    @Override
    public int countAll(T ob) {
        return 1;
    }

    @Override
    public void printEntity(T obj) {
        /*Questo metodo è più che altro un esercizio di stile/funzione di debug per non stare a ciclare ogni volta su tutte
        le proprietà di un'entita. La reflection può essere lenta/devastante*/
        {
            for (Field field : obj.getClass().getDeclaredFields()) {
                try {
                    //field.setAccessible(true); // if you want to modify private fields
                    field.setAccessible(true);
                    System.out.println(field.getName() + " - " + field.get(obj));
                } catch (Exception ex) {
                    Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<T> findAll(T object) {
        List<T> result;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from " + object.getClass().getName()).list();
            session.getTransaction().commit();
            session.close();

        }

        return result;
    }

    @Override
    public ObservableList<T> findAllObservableList(T object) {
        ObservableList<T> result = FXCollections.observableArrayList();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            result.setAll(session.createQuery("from " + object.getClass().getName()).list());
            session.getTransaction().commit();
            session.close();

        }

        return result;
    }


}