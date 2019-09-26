package pl.zawody.REST;

import pl.zawody.Beans.BiegEJB;

import pl.zawody.Entities.Biegi;
import pl.zawody.Entities.Containers.BiegiList;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/biegi")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)

public class BiegREST {

    @EJB
    BiegEJB bean;


    @POST
    @Path("/create")
    public String create(Biegi bieg) {
        return bean.create(bieg);
    }

    @GET
    @Path("/{idc}")
    public Biegi findByID(@PathParam("idc") int idc) {
        return bean.find(idc);

    }


    @GET
    public BiegiList findAll() {
        return new BiegiList(bean.findAll());
    }


    @PUT
    public String update(Biegi bieg) {

        return bean.update(bieg);
    }

    @DELETE
    @Path("/{idc}")
    public String delete(@PathParam("idc")int idc) {
        Biegi biegi = bean.find(idc);
        if (biegi != null ) {
            return bean.delete(biegi);
        }
        return Constants.FAILURE;
    }
}
