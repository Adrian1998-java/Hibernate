package aed.hibernate.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regimenes")
public class Regimenes {

	@Id
	@Column(columnDefinition = "integer")
	int codRegimen;

	@Id
	@Column(columnDefinition = "char(6)")
	String codHotel;

	@Id
	@Column(columnDefinition = "char(2)")
	String tipo;

	@Id
	@Column(columnDefinition = "integer")
	int precioDia;

	// AQUI VAN LAS RELACIONES

	//

	public int getCodRegimen() {
		return codRegimen;
	}

	public void setCodRegimen(int codRegimen) {
		this.codRegimen = codRegimen;
	}

	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(int precioDia) {
		this.precioDia = precioDia;
	}

}
