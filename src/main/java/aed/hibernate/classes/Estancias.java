package aed.hibernate.classes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estancias")
public class Estancias implements Serializable{

	@Id
	@Column(columnDefinition = "integer")
	int codEstancia;
	
	@Id
	@Column(columnDefinition = "char(9)")
	String codDNIoNIE;

	@Id
	@Column(columnDefinition = "integer")
	int codHabitacion;
	
	@Id
	@Column(columnDefinition = "date")
	Date fechaIncio;
	
	@Id
	@Column(columnDefinition = "date")
	Date fechaFin;
	
	@Id
	@Column(columnDefinition = "integer")
	int codRegimen;
	
	@Id
	@Column(columnDefinition = "smallint")
	int ocupantes;
	
	@Id
	@Column(columnDefinition = "integer")
	int precioestancia;
	
	@Id
	@Column(columnDefinition = "tinyint")
	int pagado;

	// AQUI VAN LAS RELACIONES

	//
	
	public int getCodEstancia() {
		return codEstancia;
	}

	public void setCodEstancia(int codEstancia) {
		this.codEstancia = codEstancia;
	}

	public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}

	public int getCodHabitacion() {
		return codHabitacion;
	}

	public void setCodHabitacion(int codHabitacion) {
		this.codHabitacion = codHabitacion;
	}

	public Date getFechaIncio() {
		return fechaIncio;
	}

	public void setFechaIncio(Date fechaIncio) {
		this.fechaIncio = fechaIncio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCodRegimen() {
		return codRegimen;
	}

	public void setCodRegimen(int codRegimen) {
		this.codRegimen = codRegimen;
	}

	public int getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}

	public int getPrecioestancia() {
		return precioestancia;
	}

	public void setPrecioestancia(int precioestancia) {
		this.precioestancia = precioestancia;
	}

	public int getPagado() {
		return pagado;
	}

	public void setPagado(int pagado) {
		this.pagado = pagado;
	}
	
	
}
