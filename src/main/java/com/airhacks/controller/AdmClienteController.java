package com.airhacks.controller;

import com.airhacks.controller.util.ResponseJson;
import com.airhacks.model.AdmCliente;
import com.airhacks.repository.AdmClienteRepository;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.swing.text.html.Option;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.validation.Valid;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdmClienteController {
    @Inject
    AdmClienteRepository admClienteRepository;
    @Inject
    Logger logger;

    @Inject
    ResponseJson responseJson;


    @GET
    public Response getAll(){
        List <AdmCliente> clientes = admClienteRepository.getAll();
        return Response.ok().entity(clientes).build();
    }

//    @GET
//    @Path("/{id:[0-9][0-9]*}")
//    public Response getClientById(@PathParam("id") Long id){
//        List <AdmCliente> cliente = admClienteRepository.getClienteById(id);
//        if (cliente==null)
//        {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//
//        } else {
//            return Response.ok().entity(cliente).build();
//        }
//    }
}
