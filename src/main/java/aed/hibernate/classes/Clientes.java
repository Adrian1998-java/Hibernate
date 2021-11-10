package aed.hibernate.classes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable{
	@Id
	@Column(columnDefinition = "char(9)")
	String codDNIoNIE;

	@Id
	@Column(columnDefinition = "varchar(50)")
	String nombre;

	@Id
	@Column(columnDefinition = "varchar(40)")
	String nacionalidad;

	// AQUI VAN LAS RELACIONES

	//

	public String getCodDNIoNIE() {
		return codDNIoNIE;
	}

	public void setCodDNIoNIE(String codDNIoNIE) {
		this.codDNIoNIE = codDNIoNIE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
