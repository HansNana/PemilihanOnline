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
import pojos.Acara;
import pojos.Akun;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class AcaraHelper {
    public AcaraHelper(){
        
    }
    public List<Acara> getAllAcara(){
        List<Acara> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Acara ac";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    
     public void addNewAcara(String jenisAcara){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Acara acara = new Acara(jenisAcara);
        session.saveOrUpdate(acara);
        transaction.commit();
        session.close();
    }
}
