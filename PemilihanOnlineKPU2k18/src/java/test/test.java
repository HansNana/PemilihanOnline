/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.AkunHelper;
import helper.DataCalonHelper;
import helper.VotersHelper;
import java.util.List;
import pojos.Akun;
import pojos.DataCalon;
import pojos.Voters;

/**
 *
 * @author danielbram
 */
public class test {

    public static void main(String[] args) {

        VotersHelper test = new VotersHelper();
        List<Voters> data = test.getAcara("PemilihanGubernur");
        if (data != null) {
            Gson gson = new Gson();
            String json = gson.toJson(data);
            System.out.println(json);
        }
    }
}