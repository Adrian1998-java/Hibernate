package aed.hibernate.classes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hoteles")
public class Hoteles implements Serializable{
	@Id
	@Column(columnDefinition = "char(6)")
	String codHotel;

	@Id
	@Column(columnDefinition = "varchar(60)")
	String nomHotel;

	// AQUI VAN LAS RELACIONES

	//

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
}
