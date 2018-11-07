/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Akun;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class AkunHelper {
    public AkunHelper(){
        
    }
    public List<Akun> getAllPasien(){
        List<Akun> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Akun a";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
}
