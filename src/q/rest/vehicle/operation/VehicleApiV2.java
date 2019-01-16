package q.rest.vehicle.operation;

import q.rest.vehicle.dao.DAO;
import q.rest.vehicle.filter.ValidApp;
import q.rest.vehicle.model.contract.PublicModelYearContained;
import q.rest.vehicle.model.entity.ModelYear;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api/v2/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehicleApiV2 {


    @EJB
    private DAO dao;


    @ValidApp
    @POST
    @Path("model-year-from-ids")
    public Response getVehiclesFromIds(List<Integer> modelYearIds) {
        try {
            String sql = "select * from veh_year where id in (0";
            for (Integer myId : modelYearIds) {
                sql += "," + myId;
            }
            sql += ")";
            List<ModelYear> mys = dao.getNative(ModelYear.class, sql);
            List<PublicModelYearContained> publicMys = new ArrayList<>();
            for (ModelYear modelYear : mys) {
                PublicModelYearContained pm = new PublicModelYearContained(modelYear);
                publicMys.add(pm);
            }
            return Response.status(200).entity(publicMys).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }





}
