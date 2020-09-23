package com.airhacks.controller;

import com.airhacks.model.AdmTypology;
import com.airhacks.repository.AdmTypologyRepository;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("typology")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdmTypologyController {


    @Inject
    AdmTypologyRepository admTypologyRepository;

    @Inject
    Logger logger;

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response getById(@PathParam("id") Long id) {

        List<AdmTypology> admTypologyList = admTypologyRepository.getAll(id);

        return Response.ok().entity(admTypologyList).build();
    }
}
