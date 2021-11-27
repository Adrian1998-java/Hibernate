package aed.hibernate.classes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estancias")
public class Estancias implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "integer")
	int codEstancia;

	@Column(columnDefinition = "date")
	Date fechaInicio;

	@Column(columnDefinition = "date")
	Date fechaFin;

	@Column(columnDefinition = "smallint")
	int ocupantes;

	@Column(columnDefinition = "integer")
	int precioestancia;

	@Column(columnDefinition = "bit")
	int pagado;

	// AQUI VAN LAS RELACIONES
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "CodHabitacion")
	private Habitaciones habitacionObj;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "CodRegimen")
	private Regimenes regimenObj;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "codDNIoNIE", referencedColumnName = "codDNIoNIE")
	private Clientes codDNIoNIEObj;

	//
	public int getPagado() {
		return pagado;
	}

	public void setPagado(int pagado) {
		this.pagado = pagado;
	}

	public Habitaciones getHabitacionObj() {
		return habitacionObj;
	}

	public void setHabitacionObj(Habitaciones habitacionObj) {
		this.habitacionObj = habitacionObj;
	}

	public Regimenes getRegimenObj() {
		return regimenObj;
	}

	public void setRegimenObj(Regimenes regimenObj) {
		this.regimenObj = regimenObj;
	}

	public Clientes getCodDNIoNIEObj() {
		return codDNIoNIEObj;
	}

	public void setCodDNIoNIEObj(Clientes codDNIoNIEObj) {
		this.codDNIoNIEObj = codDNIoNIEObj;
	}



	public int getCodEstancia() {
		return codEstancia;
	}

	public void setCodEstancia(int codEstancia) {
		this.codEstancia = codEstancia;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

}
