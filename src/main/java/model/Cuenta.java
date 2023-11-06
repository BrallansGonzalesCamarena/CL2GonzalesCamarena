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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "Cuenta")
@Entity(name = "cuenta")
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "activa")
	private Boolean activa;
	
	@Column(name = "numeroCuenta",length = 225,nullable = false)
	private String numeroCuenta;
	
	@Column(name = "saldo",nullable = false)
	private Double saldo;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private  Cliente cliente; 
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	private TipoCuenta tipoCuenta;
	
	
	
	@OneToMany(mappedBy ="cuenta",cascade = CascadeType.PERSIST)
	private List<Movimiento>movimientos;
	
	public Cuenta() {
		super();
	}
	

	public Cuenta(Long id, Boolean activa, String numeroCuenta, Double saldo, TipoCuenta tipoCuenta,
			List<Movimiento> movimientos) {
		super();
		this.id = id;
		this.activa = activa;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
		this.movimientos = movimientos;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActiva() {
		return activa;
	}

	public void setActiva(Boolean activa) {
		this.activa = activa;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	
	
}
