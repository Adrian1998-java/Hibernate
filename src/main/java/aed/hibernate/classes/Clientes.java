package aed.hibernate.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable{
	@Id
	@Column(columnDefinition = "char(9)")
	String codDNIoNIE;

	
	@Column(columnDefinition = "varchar(50)")
	String nombre;

	
	@Column(columnDefinition = "varchar(40)")
	String nacionalidad;

	// AQUI VAN LAS RELACIONES
	@OneToMany (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "codDNIoNIEObj")
	List<Estancias> estancias = new ArrayList<>();
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
