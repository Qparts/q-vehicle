package q.rest.vehicle.model.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="veh_model")
public class PublicModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private int id;
    @Column(name="make_id")
    private int makeId;
    @Column(name="name")
    private String name;
    @Column(name="name_ar")
    private String nameAr;
    @Column(name="status")
    @JsonIgnore
    private char status;
    @Transient
    private List<PublicModelYear> modelYears;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public List<PublicModelYear> getModelYears() {
        return modelYears;
    }

    public void setModelYears(List<PublicModelYear> modelYears) {
        this.modelYears = modelYears;
    }
}
