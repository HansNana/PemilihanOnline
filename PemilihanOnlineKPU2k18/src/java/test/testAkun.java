/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.AkunHelper;
import java.util.List;
import pojos.Akun;

/**
 *
 * @author Muliana
 */
public class testAkun {
  public static void main(String[] args) {
       AkunHelper test = new AkunHelper();
        List<Akun> list = test.getAllAkun();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
