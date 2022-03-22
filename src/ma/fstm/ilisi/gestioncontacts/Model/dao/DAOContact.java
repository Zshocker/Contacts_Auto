package ma.fstm.ilisi.gestioncontacts.Model.dao;
import ma.fstm.ilisi.gestioncontacts.Model.bo.Contact;
import ma.fstm.ilisi.gestioncontacts.Model.dao.hib.FabricSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DAOContact implements IDAOContact{
    private static DAOContact daoContact=null;
    private List<Contact> contacts =null;
    public static DAOContact getDAOContact(){
       if(daoContact==null)daoContact=new DAOContact();
       return daoContact;
    }
    public static List<Contact> getCache(){
        return  daoContact.contacts;
    }
    private DAOContact(){

    }
    @Override
    public boolean Create(Contact user) {
        SessionFactory sessionFactory= FabricSession.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
            session.save(user);
            tx.commit();
            return true;
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
            return false;
        }
    }

    @Override
    public Collection<Contact> Retrieve() {
        if(contacts!=null)return contacts;
        SessionFactory sessionFactory= FabricSession.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        try {
            contacts= (List<Contact>) session.createQuery("from Contact").list();
           session.close();
           return contacts;
        } catch (HibernateException e) {
            System.err.println(e);
          return null;
        }
    }

    @Override
    public void update(Contact user) {
        SessionFactory sessionFactory= FabricSession.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
        }
    }

    @Override
    public boolean delete(Contact user) {
        SessionFactory sessionFactory= FabricSession.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
            session.delete(user);
            tx.commit();
            return true;
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
            return false;
        }
    }
   
}
