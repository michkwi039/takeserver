package pl.zawody.REST;

import pl.zawody.Beans.ZawodnicyEJB;
import pl.zawody.Entities.Containers.ZawodnicyList;
import pl.zawody.Entities.Zawodnicy;
import pl.zawody.Utility.Constants;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/zawodnicy")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)

public class ZawodnicyREST  {

    @EJB
    ZawodnicyEJB bean;

    @Path("/create")
    @POST
    public String create(Zawodnicy zawodnik) {

        return bean.create(zawodnik);
    }

    @GET
    @Path("/{idc}")
    public Zawodnicy findByID(@PathParam("idc") int idc) {
        return bean.find(idc);
    }


    @GET
    public ZawodnicyList findAll() {
        return new ZawodnicyList(bean.findAll());
    }


    @PUT
    public String update(Zawodnicy zawodnik) {
        try {
            bean.update(zawodnik);
            return Constants.SUCCESS;
        } catch (Exception e) {
            return Constants.FAILURE;
        }
    }


    @DELETE
    @Path("/{idc}")
    public String delete(@PathParam("idc")int idc) {
        Zawodnicy zawodnicy = bean.find(idc);
        if (zawodnicy != null ) {
            return bean.delete(zawodnicy);
        }
        return Constants.FAILURE;
    }
}
