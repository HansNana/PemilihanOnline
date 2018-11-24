/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Akun;
import pojos.Voters;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class VotersHelper {
    public VotersHelper(){
        
    }
    public List<Voters> getAllVoters(){
        List<Voters> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Voters v";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewVoters(int nik, String nama, int noUrut){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();        
        Voters voters = new Voters(nik, nama, noUrut);
        session.saveOrUpdate(voters);
        transaction.commit();
        session.close();
    }
}
