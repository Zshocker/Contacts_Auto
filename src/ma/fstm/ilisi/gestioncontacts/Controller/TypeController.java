package ma.fstm.ilisi.gestioncontacts.Controller;

import java.util.List;
import ma.fstm.ilisi.gestioncontacts.Model.dao.DAOType;

public class TypeController
{
    public List<ma.fstm.ilisi.gestioncontacts.Model.bo.Type> getAllTypes(){
        return DAOType.getDAOType().Retreve();
    }
}
