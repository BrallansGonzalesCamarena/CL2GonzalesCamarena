package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "TipoCuenta")
@Entity(name = "TipoCuenta")
public class TipoCuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion",length = 225,nullable = false)
	private String descripcion;
	
	@Column(name = "moneda",length = 225,nullable = false)
	private String moneda;
	
	public TipoCuenta() {
		super();
	}

	public TipoCuenta(Long id, String descripcion, String moneda) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.moneda = moneda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	
}
