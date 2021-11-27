package aed.hibernate.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Hoteles")
public class Hoteles implements Serializable {
	@Id
	@Column(columnDefinition = "char(6)")
	private String codHotel;

	@Column(columnDefinition = "varchar(60)")
	private String nomHotel;

	// AQUI VAN LAS RELACIONES
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "hotelObj")
	private List<Habitaciones> habitaciones = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotelObj")
	private List<Regimenes> regimenes = new ArrayList<>();
	//

	public List<Habitaciones> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitaciones> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Regimenes> getRegimenes() {
		return regimenes;
	}

	public void setRegimenes(List<Regimenes> regimenes) {
		this.regimenes = regimenes;
	}

	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	@Override
	public String toString() {
		return "CodHotel = " + codHotel + ", nomHotel = " + nomHotel + "\n";
	}
}
