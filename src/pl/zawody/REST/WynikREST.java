package pl.zawody.REST;

import pl.zawody.Beans.WynikEJB;
import pl.zawody.Entities.Containers.WynikiList;
import pl.zawody.Entities.Wyniki;
import pl.zawody.Utility.Constants;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/wyniki")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class WynikREST {
    @EJB
    WynikEJB bean;

    @Path("/create")
    @POST
    public String create(Wyniki wynik) {

        return bean.create(wynik);
    }

    @GET
    @Path("/{idc}")
    public Wyniki findbyID(@PathParam("idc") Long idc) {
       return bean.find(idc);
    }
    @GET
    public WynikiList findAll(){
        return new WynikiList(bean.findAll());
    }

    @PUT
    public String update(Wyniki wynik) {
        bean.update(wynik);
        return "Wynik updated";
    }

    @DELETE
    @Path("/{idc}")
    public String delete(@PathParam("idc") Long idc) {
        Wyniki wyniki = bean.find(idc);
        if (wyniki != null ) {
            return bean.delete(wyniki);
        }
        return Constants.FAILURE;
    }
}
