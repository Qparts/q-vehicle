package q.rest.vehicle.model.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="veh_year")
public class PublicModelYear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    private int id;

    @Column(name="model_id")
    private int modelId;

    @Column(name="make_id")
    private int makeId;

    @Column(name="status")
    @JsonIgnore
    private char status;

    @Column(name="year")
    private int year;

    @Transient
    private String imageLarge;
    @Transient
    private String imageSmall;

    public String getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(String imageLarge) {
        this.imageLarge = imageLarge;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
