package q.rest.vehicle.model.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="veh_make")
@Entity
public class PublicMake implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="name_ar")
    private String nameAr;
    @Column(name="status")
    @JsonIgnore
    private char status;
    @Column(name = "catalog_id")
    private String catalogId;
    @Transient
    private List<PublicModel> models;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<PublicModel> getModels() {
        return models;
    }

    public void setModels(List<PublicModel> models) {
        this.models = models;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }
}
