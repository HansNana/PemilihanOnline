/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import helper.PesertaAcaraHelper;
import java.util.List;
import pojos.PesertaAcara;

/**
 *
 * @author Muliana
 */
public class testPesertaAcara {
    public static void main(String[] args) {
        PesertaAcaraHelper test = new PesertaAcaraHelper();
        List<PesertaAcara> list = test.getAllPesertaAcara();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);

    }
}
