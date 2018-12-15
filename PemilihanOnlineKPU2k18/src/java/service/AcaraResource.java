/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AcaraHelper;
import helper.AkunHelper;
import helper.DataCalonHelper;
import helper.VotersHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Acara;
import pojos.Akun;
import pojos.Voters;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("acara")
public class AcaraResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AcaraResource
     */
    public AcaraResource() {
    }

    /**
     * Retrieves representation of an instance of service.AcaraResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonAkun() {
        //TODO return proper representation object
        AcaraHelper test = new AcaraHelper();
        List<Acara> list = test.getAllAcara();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of AcaraResource
     * @param content representation for the resource
     */
    @POST
    @Path("addAcara")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAcara(String data) {
        Gson gson = new Gson();        
        Acara acara = gson.fromJson(data, Acara.class);
        AcaraHelper helper = new AcaraHelper();
        helper.addNewAcara(acara.getJenisAcara());
        return Response
                .status(200)
                .entity(acara)
                .build();
    }
    @GET    
    @Path("deleteAcara")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAcara(
            @QueryParam("jenisAcara")String jenisAcara) {
        AcaraHelper helper = new AcaraHelper();
        int data = helper.deleteJenisAcara(jenisAcara);        
        return Response
                .status(200)
                .entity(data)
                .build();        
    }
}
