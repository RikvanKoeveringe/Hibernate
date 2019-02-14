package domain.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity (name = "Schaal")
@Table (name = "schaal")
public class Schaal implements Serializable {
	private static final long serialVersionUID = 1L;


	
	@Id
	@Column (name = "schaalcode", length = 10, updatable = false, nullable = false )
//	@ManyToOne
//	@JoinColumn(name = "schaalcode", foreignKey = @ForeignKey (name = "schaalcode_ID_FK"))
	private int schaalcode;
	private Double min;
	private Double max;
	
	
	public Schaal() {
		
	}


	public Schaal(int schaalcode, Double min, Double max) {
		super();
		this.schaalcode = schaalcode;
		this.min = min;
		this.max = max;
	}


	public int getSchaalcode() {
		return schaalcode;
	}


	public void setSchaalcode(int schaalcode) {
		this.schaalcode = schaalcode;
	}


	public Double getMin() {
		return min;
	}


	public void setMin(Double min) {
		this.min = min;
	}


	public Double getMax() {
		return max;
	}


	public void setMax(Double max) {
		this.max = max;
	}


	@Override
	public String toString() {
		return "Schaal [schaalcode=" + schaalcode + ", min=" + min + ", max=" + max + "]";
	}
}
