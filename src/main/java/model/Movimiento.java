package model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "Movimiento")
@Entity(name = "Movimiento")
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descripcion",length = 225,nullable = false)
	private String descripcion;
	
	@Column(name = "fecha",length = 225,nullable = false)
	private LocalDate fecha;
	
	@Column(name = "monto",length = 225,nullable = false)
	private Double monto;
	
	@ManyToOne
	@JoinColumn(name = "cuenta_id")
	private  Cuenta cuenta; 
	
	public Movimiento() {
		super();
	}

	public Movimiento(Long id, String descripcion, LocalDate fecha, Double monto) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.monto = monto;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	
	
}
