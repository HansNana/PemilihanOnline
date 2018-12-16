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
import util.HibernateUtil;

/**
 *
 * @author danielbram
 */
public class AkunHelper {

    public AkunHelper() {

    }

    public List<Akun> getAllAkun() {
        List<Akun> result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String query = "from Akun a";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }

    public void addNewAkun(int nik, String nama, String email, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Akun akun = new Akun(nik, nama, email, password);
        session.saveOrUpdate(akun);
        transaction.commit();
        session.close();
    }

    public Akun getUser(String email, String password) {
        List<Akun> list = this.getAllAkun();
        Collections.sort(list);
        Akun akun = new Akun(email, password);
        int result = Collections.binarySearch(list, akun);
        if (result <= -1) {
            //cek user
            return null;
        } else {
            Akun index = list.get(result);
            if (akun.getPassword().equals(index.getPassword())) {
                return akun;
            } else {
                return null;
            }
        }
    }

    public List<Akun> getDataUser(String email) {
        List<Akun> list = this.getAllAkun();
        List<Akun> ketemu = this.getAllAkun();
        ketemu.clear();
        
        Akun akun = new Akun(email);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmail().equals(akun.getEmail())) {
                ketemu.add(list.get(i));
            }

        }

        return ketemu;
    }

}
