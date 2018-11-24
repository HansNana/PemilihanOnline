/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Akun;
import pojos.PesertaAcara;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class PesertaAcaraHelper {
    public PesertaAcaraHelper(){
        
    }
    public List<PesertaAcara> getAllPesertaAcara(){
        List<PesertaAcara> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from PesertaAcara p";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
    public void addNewPeserta(int nik, String nama, String namaAcara){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();        
        PesertaAcara peserta = new PesertaAcara(nik, nama, namaAcara);
        session.saveOrUpdate(peserta);
        transaction.commit();
        session.close();
    }
}
