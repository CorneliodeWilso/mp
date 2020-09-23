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
import java.util.UUID;

@Path("fiscalia")
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
    ) {

        List<AdmFiscalia> admPeople = admFiscaliaRepository.getAll();

        return Response.ok().entity(admPeople).build();
    }

    @GET

    @Path("/{id:[0-9][0-9]*}")
    public Response getById(@PathParam("id") Long id) {

        AdmFiscalia admFiscalia = admFiscaliaRepository.findBy(id);

        return Response.ok().entity(admFiscalia).build();
    }

    @POST
    public Response getById(@Valid AdmFiscalia admFiscalia) {

        admFiscaliaRepository.save(admFiscalia);

        if (admFiscalia.getFiscalia_id() != null && admFiscalia.getFiscalia_id() > 0) {
            responseJson.setCode("OK");
            responseJson.setId(admFiscalia.getFiscalia_id());
            return Response.status(Response.Status.CREATED).entity(responseJson).build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response getById(@Valid AdmFiscalia admFiscalia, @PathParam("id") Long id ) {

        AdmFiscalia admFiscalia1 = admFiscaliaRepository.findBy(id);

        if (admFiscalia == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        admFiscalia.setFiscalia_id(admFiscalia.getFiscalia_id());
        admFiscaliaRepository.save(admFiscalia);

        return Response.status(Response.Status.OK).build();
    }

}
