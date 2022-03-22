package ma.fstm.ilisi.gestioncontacts.Model.servise;

import ma.fstm.ilisi.gestioncontacts.Model.bo.Contact;
import ma.fstm.ilisi.gestioncontacts.Model.bo.Type;
import ma.fstm.ilisi.gestioncontacts.Model.dao.DAOContact;

public class ContactServise
{
    public boolean insertContact(String Nom, String Prenom, String tel, String email , Type type){
        if(!check_Contact_data(Nom, Prenom, tel, email))return false;
        Contact con=new Contact();
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        con.setTypes(type);
        boolean b= DAOContact.getDAOContact().Create(con);
        if(b && DAOContact.getCache()!=null)
            DAOContact.getCache().add(con);
        return b;
    }
    public boolean Update_Contact(Contact con, String Nom, String Prenom, String tel, String email,Type type)
    {
        if(!check_Contact_data(Nom, Prenom, tel, email))return false;
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        con.setTypes(type);
        DAOContact.getDAOContact().update(con);
        return true;
    }
    private boolean check_Contact_data(String Nom, String Prenom, String tel, String email){
        if(Nom.equals("")||Prenom.equals("")||tel.equals("")||email.equals(""))return false;
        if(!tel.matches("[+]212([0-9]){9}"))return false;
        if(!email.matches(".+@.+"))return false;
        return  true;
    }
    public boolean deleteContact(Contact c){
        boolean b= DAOContact.getDAOContact().delete(c);
        if(b&& DAOContact.getCache()!=null)
            DAOContact.getCache().remove(c);
        return b;
    }
}
