/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Collections;
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
    public int deleteVoters(int delete){
        int result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "delete Voters where nik = '"+delete+"'";
        Query q = session.createQuery(query);
        result = q.executeUpdate();
        session.close();
        return result;
    }
    public void addNewVoters(int nik, String nama, int noUrut, String jenisAcara){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();        
        Voters voters = new Voters(nik, nama, noUrut, jenisAcara);
        session.saveOrUpdate(voters);
        transaction.commit();
        session.close();
    }
    public Voters getAcara(String jenis) {
        List<Voters> list = this.getAllVoters();
        Collections.sort(list);
        Voters voters = new Voters(jenis);
        int result = Collections.binarySearch(list, voters);         
        if (result <= -1) {
            //cek user
            return null;
        } else {
            Voters index = list.get(result);
            if (voters.getJenisAcara().equals(index.getJenisAcara())) {
                return voters;
            } else {
                return null;
            }
        }
    }
}
