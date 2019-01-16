package q.rest.vehicle.model.entity;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name="veh_year")
public class ModelYear implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name ="veh_year_id_seq_gen" , sequenceName = "veh_year_id_seq" , initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veh_year_id_seq_gen")
	@Column(name="id")
	private int id;
	
	@JoinColumn(name="model_id")
	@ManyToOne
	private Model model;
	
	@JoinColumn(name="make_id")
	@ManyToOne
	private Make make;
	
	@Column(name="status")
	private char status;
	
	@Column(name="year")
	private int year;
	
	@Column(name="created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name="created_by")
	private int createdBy;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Make getMake() {
		return make;
	}
	public void setMake(Make make) {
		this.make = make;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + createdBy;
		result = prime * result + id;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + status;
		result = prime * result + year;
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
		ModelYear other = (ModelYear) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (id != other.id)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (status != other.status)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
	
}
