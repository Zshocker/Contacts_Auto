package ma.fstm.ilisi.gestioncontacts.Controller;

import ma.fstm.ilisi.gestioncontacts.Model.bo.Contact;
import ma.fstm.ilisi.gestioncontacts.Model.dao.DAOContact;

import java.util.LinkedList;
import java.util.List;
import ma.fstm.ilisi.gestioncontacts.Model.bo.Type;
import ma.fstm.ilisi.gestioncontacts.Model.servise.ContactServise;

/**
 *
 * @author hicham
 */
public class ContactController {

    ContactServise servise=new ContactServise();
    public boolean insertContact(String Nom, String Prenom, String tel, String email ,Type type){
        return servise.insertContact(Nom,Prenom,tel,email,type);
    }
    public boolean updateContact(Contact con, String Nom, String Prenom, String tel, String email,Type type ){
       return  servise.Update_Contact(con, Nom, Prenom, tel, email,type);
    }
    public List<Contact> AllContacts()
    {
        return (List<Contact>) DAOContact.getDAOContact().Retrieve();
    }
    public boolean deleteContact(Contact c){
        return servise.deleteContact(c);
    }
}
