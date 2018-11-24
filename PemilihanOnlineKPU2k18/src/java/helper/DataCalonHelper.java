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
import pojos.DataCalon;
import pojos.PesertaAcara;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class DataCalonHelper {
    public DataCalonHelper(){
        
    }
    public List<DataCalon> getAllDataCalon(){
        List<DataCalon> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from DataCalon d";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewDataCalon(int nik, String nama, int noUrut, byte[] foto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();                
        DataCalon dataCalon = new DataCalon(nik, nama, noUrut, foto);
        session.saveOrUpdate(dataCalon);
        transaction.commit();
        session.close();
    }
}
