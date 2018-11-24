/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.DataCalonHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.DataCalon;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("dataCalon")
public class DataCalonResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DataCalonResource
     */
    public DataCalonResource() {
    }

    /**
     * Retrieves representation of an instance of service.DataCalonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonDataCalon() {
        //TODO return proper representation object
        DataCalonHelper test = new DataCalonHelper();
        List<DataCalon> list = test.getAllDataCalon();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of DataCalonResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
}
