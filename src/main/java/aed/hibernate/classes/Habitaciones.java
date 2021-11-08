package aed.hibernate.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Habitaciones")
public class Habitaciones {

	@Id
	@Column(columnDefinition = "integer")
	int codHabitacion;

	@Id
	@Column(columnDefinition = "char(6)")
	String codHotel;

	@Id
	@Column(columnDefinition = "char(4)")
	String numHabitacion;

	@Id
	@Column(columnDefinition = "smallint")
	int capacidad;

	@Id
	@Column(columnDefinition = "integer")
	int preciodia;

	@Id
	@Column(columnDefinition = "tinyint")
	int activa;

	// AQUI VAN LAS RELACIONES

	//

	public int getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
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
