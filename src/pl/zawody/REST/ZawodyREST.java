package pl.zawody.REST;


import pl.zawody.Beans.ZawodyEJB;
import pl.zawody.Entities.Containers.ZawodyList;
import pl.zawody.Entities.Zawody;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/zawody")
@Consumes({ "application/xml" })
@Produces({ "application/xml" })

public class ZawodyREST {

    @EJB
    ZawodyEJB bean;

    @Path("/create")
    @POST
    public String create(Zawody zawody) {
        return bean.create(zawody);
    }

    @GET
    @Path("/{idc}")
    public Zawody findByID(@PathParam("idc") Long idc) {
        return bean.find(idc);

    }


    @GET
    public ZawodyList findAll() {
        return new ZawodyList(bean.findAll());
    }


    @PUT
    public String update(Zawody zawody) {

        return bean.update(zawody);
    }

    @DELETE
    @Path("/{idc}")
    public String delete(@PathParam("idc")Long idc) {
        Zawody zawody = bean.find(idc);
        if (zawody != null ) {
            return bean.delete(zawody);
        }
        return Constants.FAILURE;
    }
}
