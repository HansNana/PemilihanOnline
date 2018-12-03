/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.DataCalonHelper;
import java.util.List;
import pojos.DataCalon;

/**
 *
 * @author danielbram
 */
public class testDeleteDataCalon {
    public static void main(String[] args) {
        DataCalonHelper test = new DataCalonHelper();
        int list = test.deleteDataCalon(12312);
        List<DataCalon> all = test.getAllDataCalon();
        Gson gson = new Gson();
        String json = gson.toJson(all);
        System.out.println(json);
    }
}
