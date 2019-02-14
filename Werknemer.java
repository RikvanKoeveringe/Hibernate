package domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "Werknemer")
@Table(name = "werknemer")
public class Werknemer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "w_code", length = 4, updatable = false, nullable = false)
	// mag niet
//	@ManyToOne
//	@JoinColumn(name = "w_code", foreignKey = @ForeignKey(name = "w_code_ID_FK"))
	private int w_code;
	private String naam;
	private String voorletters;
	private String tussenvoegsel;
	private String adres;
	private String woonplaats;
	@Temporal(TemporalType.DATE)
	private Calendar datum_in_dienst;
	private Double salaris;
	private Schaal schaalcode;
	@ManyToOne
	private Werknemer chef;
	//private Set<Werknemer> chef = new HashSet<>();

	@OneToMany(mappedBy = "p_leider")
	private Set<Project> leadedProjects = new HashSet<>();

//	@OneToMany(mappedBy = "schaalcode")
//	private List<Schaal> schaalcodes = new ArrayList<Schaal>();

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "Project", joinColumns = @JoinColumn(name = "p_leider"),
	 * inverseJoinColumns = @JoinColumn(name = "w_code") )
	 */
	@OneToMany(mappedBy = "w_code")
	private Set<Werk> heeftWcode = new HashSet<>();

	
	public Werknemer() {

	}

	public Werknemer(int w_code, String naam, String voorletters, String tussenvoegsel, String adres, String woonplaats,
			Calendar datum_in_dienst, Double salaris, Werknemer chef, Schaal schaalcode) {
		super();
		this.w_code = w_code;
		this.naam = naam;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.adres = adres;
		this.woonplaats = woonplaats;
		this.datum_in_dienst = datum_in_dienst;
		this.salaris = salaris;
		this.chef = chef;
		this.schaalcode = schaalcode;
	}

	public int getCode() {
		return w_code;
	}

	public void setCode(int code) {
		this.w_code = code;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public Calendar getDatum_in_dienst() {
		return datum_in_dienst;
	}

	public void setDatum_in_dienst(Calendar datum_in_dienst) {
		this.datum_in_dienst = datum_in_dienst;
	}

	public Double getSalaris() {
		return salaris;
	}

	public void setSalaris(Double salaris) {
		this.salaris = salaris;
	}

	public Werknemer getChef() {
		return chef;
	}

	public void setChef(Werknemer chef) {
		this.chef = chef;
	}

	public Schaal getLoonschaal() {
		return schaalcode;
	}

	public void setLoonschaal(Schaal schaalcode) {
		this.schaalcode = schaalcode;
	}

	public Schaal getSchaalcode() {
		return schaalcode;
	}

	public void setSchaalcode(Schaal schaalcode) {
		this.schaalcode = schaalcode;
	}

	public int getW_code() {
		return w_code;
	}

	public void setW_code(int w_code) {
		this.w_code = w_code;
	}

	public Set<Project> getLeadedProjects() {
		return leadedProjects;
	}

	public void setLeadedProjects(Set<Project> leadedProjects) {
		this.leadedProjects = leadedProjects;
	}

	@Override
	public String toString() {
		return "Werknemer [w_code=" + w_code + ", naam=" + naam + ", voorletters=" + voorletters + ", tussenvoegsel="
				+ tussenvoegsel + ", adres=" + adres + ", woonplaats=" + woonplaats + ", datum_in_dienst="
				+ datum_in_dienst + ", salaris=" + salaris + ", schaalcode=" + schaalcode + ", chef=" + chef
				+ ", leadedProjects=" + leadedProjects + ", getCode()=" + getCode() + ", getNaam()=" + getNaam()
				+ ", getVoorletters()=" + getVoorletters() + ", getTussenvoegsel()=" + getTussenvoegsel()
				+ ", getAdres()=" + getAdres() + ", getWoonplaats()=" + getWoonplaats() + ", getDatum_in_dienst()="
				+ getDatum_in_dienst() + ", getSalaris()=" + getSalaris() + ", getChef()=" + getChef()
				+ ", getLoonschaal()=" + getLoonschaal() + ", getSchaalcode()=" + getSchaalcode() + ", getW_code()="
				+ getW_code() + ", getLeadedProjects()=" + getLeadedProjects() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
