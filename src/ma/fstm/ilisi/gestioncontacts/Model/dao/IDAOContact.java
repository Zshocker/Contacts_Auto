package ma.fstm.ilisi.gestioncontacts.Model.dao;



import ma.fstm.ilisi.gestioncontacts.Model.bo.Contact;

import java.util.Collection;

public interface IDAOContact {
    boolean Create(Contact user);
    Collection<Contact> Retrieve();
    void update(Contact user);
    boolean delete(Contact user);
}
