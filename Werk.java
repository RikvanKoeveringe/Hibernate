package domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity (name = "Werk")
@Table (name = "werk")
public class Werk implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@Column (updatable = false, nullable = false)
	private int id;
	@ManyToOne
	@JoinColumn(name = "w_code", foreignKey = @ForeignKey(name = "w_code_ID_FK"))
	private Werknemer w_code;
	@ManyToOne
	@JoinColumn(name = "p_code", foreignKey = @ForeignKey(name = "P_code_ID_FK"))
	private Project p_code;
	private int uren;
	
	
	public Werk() {
		
	}

	public Werk(Werknemer w_code, Project p_code, int uren) {
		super();
		this.w_code = w_code;
		this.p_code = p_code;
		this.uren = uren;
	}

	
	

	public Werknemer getW_code() {
		return w_code;
	}

	public void setW_code(Werknemer w_code) {
		this.w_code = w_code;
	}

	public Project getP_code() {
		return p_code;
	}

	public void setP_code(Project p_code) {
		this.p_code = p_code;
	}

	public int getUren() {
		return uren;
	}

	public void setUren(int uren) {
		this.uren = uren;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Werk [id=" + id + ", w_code=" + w_code + ", p_code=" + p_code + ", uren=" + uren + ", getW_code()="
				+ getW_code() + ", getP_code()=" + getP_code() + ", getUren()=" + getUren() + ", getId()=" + getId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


}
