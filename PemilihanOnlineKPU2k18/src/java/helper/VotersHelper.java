/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pojos.Voters;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class VotersHelper {
    public VotersHelper(){
        
    }
    public List<Voters> getAllPasien(){
        List<Voters> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Voters v";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
}