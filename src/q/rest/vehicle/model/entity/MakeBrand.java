package q.rest.vehicle.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="veh_make_brand")
@IdClass(MakeBrand.MakeBrandPK.class)
public class MakeBrand implements Serializable {

    @Id
    @Column(name="make_id")
    private int makeId;

    @Id
    @Column(name="brand_id")
    private int brandId;

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public static class MakeBrandPK implements Serializable{

        private static final long serialVersionUID = 1L;
        protected int makeId;
        protected int brandId;


        public int getMakeId() {
            return makeId;
        }

        public void setMakeId(int makeId) {
            this.makeId = makeId;
        }


        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MakeBrandPK that = (MakeBrandPK) o;
            return makeId == that.makeId &&
                    brandId == that.brandId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(makeId, brandId);
        }
    }

}
