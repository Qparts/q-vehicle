package q.rest.vehicle.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name="veh_model")
public class Model implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "veh_model_id_seq_gen",  sequenceName = "veh_model_id_seq", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veh_model_id_seq_gen")
	@Column(name="id")
	private int id;
	@JoinColumn(name="make_id")
	@ManyToOne
	private Make make;
	@Column(name="name")
	private String name;
	@Column(name="name_ar")
	private String nameAr;
	@Column(name="status")
	private char status;
	@Column(name="created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="created_by")
	private int createdBy;
	@Transient
	private List<ModelYear> modelYears;
	
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	public List<ModelYear> getModelYears() {
		return modelYears;
	}
	public void setModelYears(List<ModelYear> modelYears) {
		this.modelYears = modelYears;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	

	
	public int getId() {
		return id;
	}
	public Make getMake() {
		return make;
	}
	public String getName() {
		return name;
	}
	public String getNameAr() {
		return nameAr;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMake(Make make) {
		this.make = make;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
