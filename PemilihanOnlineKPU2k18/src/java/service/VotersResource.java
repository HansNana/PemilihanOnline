/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AkunHelper;
import helper.VotersHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Akun;
import pojos.PesertaAcara;
import pojos.Voters;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("voters")
public class VotersResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of VotersResource
     */
    public VotersResource() {
    }

    /**
     * Retrieves representation of an instance of service.VotersResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonVoters() {
        //TODO return proper representation object
        VotersHelper test = new VotersHelper();
        List<Voters> list = test.getAllVoters();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of VotersResource
     *
     * @param content representation for the resource
     */
    @POST
    @Path("addVoters")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVoters(String data) {
        Gson gson = new Gson();
        Voters voters = gson.fromJson(data, Voters.class);
        VotersHelper helper = new VotersHelper();
        helper.addNewVoters(
                voters.getNik(),
                voters.getNama(),
                voters.getNoUrut(),
                voters.getJenisAcara());
        return Response
                .status(200)
                .entity(voters)
                .build();
    }
    @GET
    @Path("deleteVoters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteVoters(
            @QueryParam("nik") int nik) {
        VotersHelper helper = new VotersHelper();
        int data = helper.deleteVoters(nik);
        return Response
                .status(200)
                .entity(data)
                .build();
    }
    @GET
    @Path("getAcara")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAcara(
            @QueryParam("jenisAcara") String jenisAcara){
        VotersHelper helper = new VotersHelper();
        List<Voters> voters = helper.getAcara(jenisAcara);
        Gson gson = new Gson();
        return Response
                .status(200)
                .entity(gson.toJson(voters))
                .build();
    }
}
