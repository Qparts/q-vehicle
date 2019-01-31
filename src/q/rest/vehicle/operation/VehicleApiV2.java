package q.rest.vehicle.operation;

import q.rest.vehicle.dao.DAO;
import q.rest.vehicle.filter.ValidApp;
import q.rest.vehicle.model.contract.PublicMake;
import q.rest.vehicle.model.contract.PublicModel;
import q.rest.vehicle.model.contract.PublicModelYear;
import q.rest.vehicle.model.contract.PublicModelYearContained;
import q.rest.vehicle.model.entity.Make;
import q.rest.vehicle.model.entity.ModelYear;

import javax.ejb.EJB;
import javax.ws.rs.*;
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


//    @ValidApp
    @GET
    @Path("makes")
    public Response getAllVehicles() {
        try {
            String sql = "select b from PublicMake b where b.status = :value0 order by b.name";
            List<PublicMake> makes = dao.getJPQLParams(PublicMake.class, sql, 'A');
            for(PublicMake publicMake : makes){
                sql = "select b from PublicModel b where b.makeId = :value0 and b.status =:value1 order by b.name";
                List<PublicModel> models = dao.getJPQLParams(PublicModel.class, sql, publicMake.getId(), 'A');
                publicMake.setModels(models);
                for(PublicModel model: models){
                    sql = "select b from PublicModelYear b where b.modelId = :value0 and b.status =:value1 order by b.year";
                    List<PublicModelYear> modelYears = dao.getJPQLParams(PublicModelYear.class, sql, model.getId(), 'A');
                    model.setModelYears(modelYears);
                }
            }
            return Response.status(200).entity(makes).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

}
