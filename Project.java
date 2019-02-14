package domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "Project")
@Table(name = "project")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_code", length = 10, updatable = false, nullable = false)
	private int p_code;
	private String p_naam;
	private String locatie;
	@Temporal(TemporalType.DATE)
	private Calendar startdatum;
	private Double budget;
	@ManyToOne
	@JoinColumn(name = "p_leider", foreignKey = @ForeignKey(name = "p_leider_ID_FK"))
	private Werknemer p_leider;
	@ManyToMany
	@JoinColumn(name = "p_werknemer", foreignKey = @ForeignKey(name = "p_werknemer_ID_FK"))
	private Set<Werknemer> werknemers = new HashSet<>();
	private Werknemer chef;
	@OneToMany(mappedBy = "chef")
	private List<Werknemer> chefr = new ArrayList<Werknemer>();

	// @OneToMany(mappedBy = "w_code")
	// private List<Werknemer> w_code = new ArrayList<Werknemer>();
	@OneToMany(mappedBy = "p_code")
	private Set<Werk> heeftPcode = new HashSet<>();
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "Werk", joinColumns = @JoinColumn(name = "w_code"),
	 * inverseJoinColumns = @JoinColumn(name = "p_code") )
	 */

	public Project() {

	}

	public Project(String p_naam, String locatie) {
		this.p_naam = p_naam;
		this.locatie = locatie;
	}

	public Project(int p_code, String p_naam, String locatie, Calendar startdatum, Double budget, Werknemer p_leider) {
		super();
		this.p_code = p_code;
		this.p_naam = p_naam;
		this.locatie = locatie;
		this.startdatum = startdatum;
		this.budget = budget;
		this.p_leider = p_leider;
	}

	@Override
	public boolean equals(Object b) {
		if (this == b) {
			return true;
		}
		if (b == null && getClass() != b.getClass()) {
			return false;
		}
		Project pr = (Project) b;
		return Objects.equals(p_code, pr.p_code);
	}

	public int getP_code() {
		return p_code;
	}

	public void setP_code(int p_code) {
		this.p_code = p_code;
	}

	public String getP_naam() {
		return p_naam;
	}

	public void setP_naam(String p_naam) {
		this.p_naam = p_naam;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public Calendar getStartdatum() {
		return startdatum;
	}

	public void setStartdatum(Calendar startdatum) {
		this.startdatum = startdatum;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Werknemer getP_leider() {
		return p_leider;
	}

	public void setP_leider(Werknemer p_leider) {
		this.p_leider = p_leider;
	}

	@Override
	public String toString() {
		return "Project [p_code=" + p_code + ", p_naam=" + p_naam + ", locatie=" + locatie + ", startdatum="
				+ startdatum + ", budget=" + budget + ", p_leider=" + p_leider
				+ /* ", w_code=" + w_code + */", getP_code()=" + getP_code() + ", getP_naam()=" + getP_naam()
				+ ", getLocatie()=" + getLocatie() + ", getStartdatum()=" + getStartdatum() + ", getBudget()="
				+ getBudget() + ", getP_leider()=" + getP_leider() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Werknemer getChef() {
		return chef;
	}

	public void setChef(Werknemer chef) {
		this.chef = chef;
	}

}
