package ma.fstm.ilisi.gestioncontacts.Controller;

import ma.fstm.ilisi.gestioncontacts.Model.bo.Contact;
import ma.fstm.ilisi.gestioncontacts.Model.dao.DAOContact;

import java.util.LinkedList;
import java.util.List;
import ma.fstm.ilisi.gestioncontacts.Model.bo.Type;

/**
 *
 * @author hicham
 */
public class ContactController {
    List<Contact> contacts =null;
    public boolean insertContact(String Nom, String Prenom, String tel, String email,String type ){
        Contact con=new Contact();
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        con.setTypes(new Type(type));
        boolean b= DAOContact.getDAOContact().Create(con);
        if(b && contacts!=null)
            contacts.add(con);
        return b;
    }
    public void updateContact(Contact con, String Nom, String Prenom, String tel, String email,String type ){
        con.setEmail(email);
        con.setNom(Nom);
        con.setTel(tel);
        con.setPrenom(Prenom);
        con.setTypes(new Type(type));
        DAOContact.getDAOContact().update(con);
    }
    public List<Contact> AllContacts()
    {
        if(contacts==null)contacts =(List<Contact>) DAOContact.getDAOContact().Retrieve();
        return contacts;
    }
    public boolean  deleteContact(Contact c){
        boolean b= DAOContact.getDAOContact().delete(c);
        if(b&& contacts!=null)
                contacts.remove(c);
        return b;
    }
}
