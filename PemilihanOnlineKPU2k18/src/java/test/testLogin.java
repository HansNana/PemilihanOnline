/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.AkunHelper;
import pojos.Akun;

/**
 *
 * @author danielbram
 */
public class testLogin {
    
    public static void main(String[] args) {

        AkunHelper test = new AkunHelper();
        Akun akun = test.getUser("dv@gmail.com", "11");
        if (akun != null) {
            Gson gson = new Gson();
            String json = gson.toJson(akun);
            System.out.println(json);
        }
        Akun user1 = test.getUser("dv@gmail.co", "1");
        if (user1 != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user1);
            System.out.println(json);
        }
        Akun user2 = test.getUser("dv@gmail.com", "111");
        if (user2 != null) {
            Gson gson = new Gson();
            String json = gson.toJson(user2);
            System.out.println(json);
        }

    }
}


