package aed.hibernate.classes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habitacionesobservaciones")
public class HabitacionesObservaciones implements Serializable{

	@Id
	@Column(columnDefinition = "integer")
	int codHabitacion;
	
	@Id
	@Column(columnDefinition = "varchar(200)")
	String observaciones;


	// AQUI VAN LAS RELACIONES

	//
	
	
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
