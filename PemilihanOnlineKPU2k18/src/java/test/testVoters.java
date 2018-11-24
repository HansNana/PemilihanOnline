/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.VotersHelper;
import java.util.List;
import pojos.Voters;

/**
 *
 * @author Muliana
 */
public class testVoters {
    public static void main(String[] args) {
        VotersHelper test = new VotersHelper();
        List<Voters> list = test.getAllVoters();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
