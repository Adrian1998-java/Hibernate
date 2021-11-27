package aed.hibernate.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regimenes")
public class Regimenes implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "integer")
	int codRegimen;

	@Column(columnDefinition = "char(2)")
	String tipo;

	@Column(columnDefinition = "integer")
	int precioDia;

	// AQUI VAN LAS RELACIONES
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "CodHotel")
	private Hoteles hotelObj;

	public Hoteles getHotelObj() {
		return hotelObj;
	}

	public void setHotelObj(Hoteles hotelObj) {
		this.hotelObj = hotelObj;
	}

	public List<Estancias> getEstancias() {
		return estancias;
	}

	public void setEstancias(List<Estancias> estancias) {
		this.estancias = estancias;
	}

	@OneToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "regimenObj")
	List<Estancias> estancias = new ArrayList<>();
	//

	public int getCodRegimen() {
		return codRegimen;
	}

	public void setCodRegimen(int codRegimen) {
		this.codRegimen = codRegimen;
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
