package model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Table(name = "Rol")
@Entity(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "activo")
	private Boolean activo;
	
	@Column(name = "descripcion",length = 225,nullable = false)
	private String descripcion;

	@ManyToMany(mappedBy ="rol",cascade = CascadeType.PERSIST)
	private List<Cliente>clientes;
	
	
	public Rol() {
		super();
	}


	public Rol(Long id, Boolean activo, String descripcion) {
		super();
		this.id = id;
		this.activo = activo;
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getActivo() {
		return activo;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
