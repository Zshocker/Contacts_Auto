package ma.fstm.ilisi.gestioncontacts.Model.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.*;
import java.util.List;
import ma.fstm.ilisi.gestioncontacts.Model.bo.Type;
import ma.fstm.ilisi.gestioncontacts.Model.dao.hib.FabricSession;

public class DAOType
{
    private static DAOType daoType=null;
    public static DAOType getDAOType(){
        if(daoType==null)daoType=new DAOType();
        return daoType;
    }
    private DAOType(){}
    public List<Type> Retreve()
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try
        {
            List<Type> types=(List<Type>) session.createQuery("from Type ").list();
            session.close();
            return types;
        }catch (HibernateException e){
            System.out.println(e);
            return null;
        }
    }
}
