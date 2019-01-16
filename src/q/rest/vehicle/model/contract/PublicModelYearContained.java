package q.rest.vehicle.model.contract;

import q.rest.vehicle.model.entity.ModelYear;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PublicModelYearContained implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int id;
    private final Map<String,Object> model;
    private final Map<String,Object> make;
    private final int year;

    public PublicModelYearContained(ModelYear modelYear) {
        this.id = modelYear.getId();
        this.year = modelYear.getYear();

        model = new HashMap<>();
        model.put("id", modelYear.getModel().getId());
        model.put("name", modelYear.getModel().getName());
        model.put("nameAr", modelYear.getModel().getNameAr());

        make = new HashMap<>();
        make.put("id", modelYear.getMake().getId());
        make.put("name", modelYear.getMake().getName());
        make.put("nameAr", modelYear.getMake().getNameAr());
    }

    public int getId() {
        return id;
    }


    public Map<String, Object> getModel() {
        return model;
    }


    public Map<String, Object> getMake() {
        return make;
    }


    public int getYear() {
        return year;
    }
}
