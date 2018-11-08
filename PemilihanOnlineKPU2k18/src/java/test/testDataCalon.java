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
 * @author Muliana
 */
public class testDataCalon {
    public static void main(String[] args) {
        DataCalonHelper test = new DataCalonHelper();
        List<DataCalon> list = test.getAllDataCalon();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
    }
}
