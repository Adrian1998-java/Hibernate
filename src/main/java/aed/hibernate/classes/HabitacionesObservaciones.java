package aed.hibernate.classes;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "habitacionesobservaciones")
public class HabitacionesObservaciones implements Serializable {

	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator(name = "myForeign", strategy = "foreign", parameters = {
			@org.hibernate.annotations.Parameter(name = "property", value = "habitacion") })
	@Column(columnDefinition = "integer")
	int codHabitacion;

	@Column(columnDefinition = "varchar(200)")
	String observaciones;

	// AQUI VAN LAS RELACIONES
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Habitaciones habitacion;

//	

	public Habitaciones getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitaciones habitacion) {
		this.habitacion = habitacion;
	}

	public int getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
