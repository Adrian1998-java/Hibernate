package aed.hibernate.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitaciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11)")
	private int codHabitacion;

	@Column(columnDefinition = "char(4)")
	private String numHabitacion;

	@Column(columnDefinition = "smallint")
	private int capacidad;

	@Column(columnDefinition = "integer")
	private int preciodia;

	@Column(columnDefinition = "bit")
	private int activa;

	// AQUI VAN LAS RELACIONES
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private HabitacionesObservaciones habitacionObs;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "CodHotel")
	private Hoteles hotelObj;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "habitacionObj")
	private List<Estancias> estancias = new ArrayList<>();

	public HabitacionesObservaciones getHabitacionObs() {
		return habitacionObs;
	}

	public void setHabitacionObs(HabitacionesObservaciones habitacionObs) {
		this.habitacionObs = habitacionObs;
	}

	public Hoteles getHotelObj() {
		return hotelObj;
	}

	public void setHotelObj(Hoteles hotelObj) {
		this.hotelObj = hotelObj;
	}

	public List<Estancias> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancias> estancias) {
		this.estancias = estancias;
	}

	public int getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public String getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getPreciodia() {
		return preciodia;
	}

	public void setPreciodia(int preciodia) {
		this.preciodia = preciodia;
	}

	public int getActiva() {
		return activa;
	}

	public void setActiva(int activa) {
		this.activa = activa;
	}

}
