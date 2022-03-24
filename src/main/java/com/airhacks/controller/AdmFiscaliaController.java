package com.airhacks.controller;

import com.airhacks.controller.util.ResponseJson;
import com.airhacks.model.AdmFiscalia;
import com.airhacks.repository.AdmFiscaliaRepository;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//api/fiscalia/all
@Path("/fiscalia")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdmFiscaliaController {
    @Inject
    AdmFiscaliaRepository admFiscaliaRepository;

    @Inject
    Logger logger;

    @Inject
    ResponseJson responseJson;

    @GET
    public Response getAll(
            @QueryParam("country") Long country,
            @QueryParam("state") Long state,
            @QueryParam("city") Long city,
            @QueryParam("zone") Long zone
    ) {

        List<AdmFiscalia> admPeople = admFiscaliaRepository.getAll(country, state, city, zone);

        return Response.ok().entity(admPeople).build();
    }


    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response getById(@PathParam("id") Long id) {

       Optional< AdmFiscalia> admFiscalia = admFiscaliaRepository.GetById3(id);

       if(admFiscalia==null)
           return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok().entity(admFiscalia).build();
    }

    @POST
    public Response getById(@Valid AdmFiscalia admFiscalia) {

        logger.info("this is my class*-------------------" + admFiscalia.toString());

        admFiscaliaRepository.save(admFiscalia);

        if (admFiscalia.getFiscaliaId() != null && admFiscalia.getFiscaliaId() > 0) {
            responseJson.setCode("OK");
            responseJson.setId(admFiscalia.getFiscaliaId());
            return Response.status(Response.Status.CREATED).entity(responseJson).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response getById(@Valid AdmFiscalia admFiscalia, @PathParam("id") Long id) {

        AdmFiscalia admFiscalia1 = admFiscaliaRepository.findBy(id);

        if (admFiscalia == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        admFiscalia.setFiscaliaId(admFiscalia.getFiscaliaId());
        admFiscaliaRepository.save(admFiscalia);

        return Response.status(Response.Status.OK).build();
    }

}
