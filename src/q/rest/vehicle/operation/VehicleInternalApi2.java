package q.rest.vehicle.operation;

import q.rest.vehicle.dao.DAO;
import q.rest.vehicle.filter.SecuredUser;
import q.rest.vehicle.filter.ValidApp;
import q.rest.vehicle.model.entity.Make;
import q.rest.vehicle.model.entity.MakeBrand;
import q.rest.vehicle.model.entity.Model;
import q.rest.vehicle.model.entity.ModelYear;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/internal/api/v2/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehicleInternalApi2 {


    @EJB
    private DAO dao;


    @SecuredUser
    @GET
    @Path("all-makes")
    public Response getAllVehicles() {
        try {
            List<Make> makes = dao.getOrderBy(Make.class, "name");
            for (Make make : makes) {
                addBrandIds(make);
                String sql = "select b from Model b where b.make = :value0 order by b.name";
                List<Model> models = dao.getJPQLParams(Model.class, sql, make);
                make.setModels(models);

                for (Model model : models) {
                    String sql2 = "select b from ModelYear b where b.model = :value0 order by b.year";
                    List<ModelYear> modelYears = dao.getJPQLParams(ModelYear.class, sql2, model);
                    model.setModelYears(modelYears);
                }
            }
            return Response.status(200).entity(makes).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    // idempotent
    @SecuredUser
    @POST
    @Path("make")
    public Response createVehicle(Make make) {
        try {
            List<Make> makes = dao.getCondition(Make.class, "name", make.getName());
            if (makes.isEmpty()) {
                dao.persist(make);
                return Response.status(200).build();
            } else {
                return Response.status(409).build();
            }

        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }


    // idempotent
    @SecuredUser
    @POST
    @Path("model")
    public Response createModel(Model model) {
        try {
            List<Model> types = dao.getTwoConditions(Model.class, "name", "make", model.getName(), model.getMake());
            if (types.isEmpty()) {
                dao.persist(model);
                return Response.status(200).build();
            } else {
                return Response.status(409).build();
            }
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    // idempotent
    @SecuredUser
    @POST
    @Path("model-year")
    public Response createYear(ModelYear modelYear) {
        try {
            List<ModelYear> years = dao.getTwoConditions(ModelYear.class, "year", "model", modelYear.getYear(),
                    modelYear.getModel());
            if (years.isEmpty()) {
                modelYear.setCreated(new Date());
                dao.persist(modelYear);
                return Response.status(200).build();
            } else {
                return Response.status(409).build();
            }

        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    @SecuredUser
    @PUT
    @Path("make")
    public Response updateMake(Make make) {
        try {
            dao.update(make);
            return Response.status(200).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    @SecuredUser
    @PUT
    @Path("model")
    public Response updateModel(Model model) {
        try {
            dao.update(model);
            return Response.status(200).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    @SecuredUser
    @PUT
    @Path("model-year")
    public Response updateModelYear(ModelYear modelYear) {
        try {
            dao.update(modelYear);
            return Response.status(200).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    @ValidApp
    @GET
    @Path("all-active-makes")
    public Response getAllActiveVehicles() {
        try {
            String sql = "select b from Make b where b.status =:value0 order by b.name";
            List<Make> makes = dao.getJPQLParams(Make.class, sql , 'A');
            for (Make make : makes) {
                addBrandIds(make);
                String sql2 = "select b from Model b where b.make =:value0 and b.status = :value1 order by b.name";
                List<Model> models = dao.getJPQLParams(Model.class, sql2, make, 'A');
                make.setModels(models);
                for (Model model : models) {
                    String sql3 = "select b from ModelYear b where b.model = :value0 and b.status =:value1 order by b.year asc";
                    List<ModelYear> modelYears = dao.getJPQLParams(ModelYear.class, sql3, model, 'A');
                    model.setModelYears(modelYears);
                }
            }
            return Response.status(200).entity(makes).build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    private void addBrandIds(Make make){
        String sql = "select b from MakeBrand b where b.makeId= :value0";
        List<MakeBrand> makeBrands = dao.getJPQLParams(MakeBrand.class, sql, make.getId());
        make.setBrandIds(new ArrayList<>());
        for(MakeBrand makeBrand : makeBrands){
            make.getBrandIds().add(makeBrand.getBrandId());
        }
    }

}
