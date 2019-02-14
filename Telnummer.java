package domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity (name = "Telnummer")
@Table (name = "telnummer")
public class Telnummer implements Serializable{
	private static final long serialVersionUID = 1L;


	
	@Id
	@Column (name = "telnummer", length = 9, updatable = false, nullable = false)
	private int telnummer;
	
	@ManyToOne
	@JoinColumn(name = "naam", foreignKey = @ForeignKey(name = "naam_ID_FK"))
	private Werknemer eigenaar;
	
	public Telnummer() {
		
	}

	public Telnummer(int telnummer, Werknemer eigenaar) {
		super();
		this.telnummer = telnummer;
		this.eigenaar = eigenaar;
	}

	public int getTelnummer() {
		return telnummer;
	}

	public void setTelnummer(int telnummer) {
		this.telnummer = telnummer;
	}


	public Werknemer getEigenaar() {
		return eigenaar;
	}

	public void setEigenaar(Werknemer eigenaar) {
		this.eigenaar = eigenaar;
	}

	@Override
	public String toString() {
		return "Telnummer [telnummer=" + telnummer + ", eigenaar=" + eigenaar + "]";
	}

	public void getTelnummer(int i) {
		
	}
}
