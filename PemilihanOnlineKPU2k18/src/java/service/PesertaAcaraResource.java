/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AkunHelper;
import helper.PesertaAcaraHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Akun;
import pojos.PesertaAcara;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("pesertaAcara")
public class PesertaAcaraResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PesertaAcaraResource
     */
    public PesertaAcaraResource() {
    }

    /**
     * Retrieves representation of an instance of service.PesertaAcaraResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonPesertaAcara() {
        //TODO return proper representation object
        PesertaAcaraHelper test = new PesertaAcaraHelper();
        List<PesertaAcara> list = test.getAllPesertaAcara();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PesertaAcaraResource
     * @param content representation for the resource
     */
    @POST
    @Path("addPesertaAcara")
    @Consumes(MediaType.APPLICATION_JSON)
public Response addPesertaAcara(String data) {
        Gson gson = new Gson();
        
        PesertaAcara peserta = gson.fromJson(data, PesertaAcara.class);
        PesertaAcaraHelper helper = new PesertaAcaraHelper();
        
        helper.addNewPeserta(
                peserta.getNik(),
                peserta.getNama(),
                peserta.getNamaAcara());
        return Response
                .status(200)
                .entity(peserta)
                .build();
    }
}
