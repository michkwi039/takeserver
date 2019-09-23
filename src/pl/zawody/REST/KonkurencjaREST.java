package pl.zawody.REST;

import pl.zawody.Beans.KonkurencjaEJB;
import pl.zawody.Entities.Biegi;
import pl.zawody.Entities.Containers.KonkurencjaList;
import pl.zawody.Entities.Konkurencja;
import pl.zawody.Utility.Constants;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/konkurencja")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class KonkurencjaREST {
    @EJB
    KonkurencjaEJB bean;

    @Path("/create")
    @POST
    public String create(Konkurencja konkurencja) {


        return bean.create(konkurencja);
    }

    @GET
    @Path("/{idc}")
    public Konkurencja find(@PathParam("idc") int idc) {
        return bean.find(idc);

    }

    @GET
    public KonkurencjaList findAll() {
        return new KonkurencjaList(bean.findAll());
    }


    @PUT
    public String update(Konkurencja konkurencja) {
        bean.update(konkurencja);
        return "Konkurencja updated";
    }


    @DELETE
    @Path("/{idc}")
    public String delete(@PathParam("idc")int idc) {
        Konkurencja konkurencja = bean.find(idc);
        if (konkurencja != null ) {
            return bean.delete(konkurencja);
        }
        return Constants.FAILURE;
    }
}
