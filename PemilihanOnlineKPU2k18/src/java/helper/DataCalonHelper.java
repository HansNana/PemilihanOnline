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
import pojos.DataCalon;
import pojos.PesertaAcara;
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class DataCalonHelper {

    public DataCalonHelper() {

    }

    public List<DataCalon> getAllDataCalon() {
        List<DataCalon> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from DataCalon d";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public int deleteDataCalon(int delete) {
        int result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "delete DataCalon where nikCalon= " + delete;
        Query q = session.createQuery(query);
        result = q.executeUpdate();
        session.close();
        return result;
    }

    public void addNewDataCalon(int nik, String nama, int noUrut, byte[] foto, String jenisAcara) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        DataCalon dataCalon = new DataCalon(nik, nama, noUrut, foto, jenisAcara);
        session.saveOrUpdate(dataCalon);
        transaction.commit();
        session.close();
    }

    public List<DataCalon> getAcara(String jenis) {
        List<DataCalon> list = this.getAllDataCalon();
        List<DataCalon> ketemu = this.getAllDataCalon();
        ketemu.clear();

        DataCalon dataCalon = new DataCalon(jenis);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getJenisAcara().equals(dataCalon.getJenisAcara())) {
                ketemu.add(list.get(i));
            }

        }

        return ketemu;
    }
}
