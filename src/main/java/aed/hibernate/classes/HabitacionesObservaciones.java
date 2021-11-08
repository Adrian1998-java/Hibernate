package aed.hibernate.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habitacionesObservaciones")
public class HabitacionesObservaciones {

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
