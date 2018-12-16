/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AkunHelper;
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

/**
 * REST Web Service
 *
 * @author ok
 */
@Path("akun")
public class AkunResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AkunResource
     */
    public AkunResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonAkun() {
        //TODO return proper representation object
        AkunHelper test = new AkunHelper();
        List<Akun> list = test.getAllAkun();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * Retrieves representation of an instance of service.AkunResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogin(
            @QueryParam("email") String email,
            @QueryParam("password") String password) {
        AkunHelper helper = new AkunHelper();
        Akun akun = helper.getUser(email, password);
        Gson gson = new Gson();
        return Response
                .status(200)
                .entity(gson.toJson(akun))
                .build();
    }

    /**
     * PUT method for updating or creating an instance of AkunResource
     *
     * @param content representation for the resource
     */
    @POST
    @Path("addAkun")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAkun(String data) {
        Gson gson = new Gson();
        Akun akun = gson.fromJson(data, Akun.class);
        AkunHelper helper = new AkunHelper();
        helper.addNewAkun(
                akun.getNik(),
                akun.getNama(),
                akun.getEmail(),
                akun.getPassword()
        );
        return Response
                .status(200)
                .entity(akun)
                .build();
    }
     @GET
    @Path("getDataUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataUser(
            @QueryParam("email") String email){
        AkunHelper helper = new AkunHelper();
        List<Akun> akun = helper.getDataUser(email);
        Gson gson = new Gson();
        return Response
                .status(200)
                .entity(gson.toJson(akun))
                .build();
    }
}
