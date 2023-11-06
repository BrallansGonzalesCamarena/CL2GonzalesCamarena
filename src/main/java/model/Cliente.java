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
import jakarta.persistence.Table;
@Table(name = "Cliente")
@Entity(name = "Cliente")
public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "apellidoMaterno",length = 225,nullable = false)
private String apeMater;

@Column(name = "apellidoPaterno",length = 225,nullable = false)
private String apePater;

@Column(name = "nombres",length = 225,nullable = false)
private String nom;

public Long getId() {
	return id;
}

@OneToMany(mappedBy ="cliente",cascade = CascadeType.PERSIST)
private List<Cuenta>cuenta;

@ManyToMany(cascade = CascadeType.PERSIST)
private List<Rol>rol;


public Cliente() {
	super();
}

public Cliente(Long id, String apeMater, String apePater, String nom, List<Cuenta> cuenta, List<Rol> rol) {
	super();
	this.id = id;
	this.apeMater = apeMater;
	this.apePater = apePater;
	this.nom = nom;
	this.cuenta = cuenta;
	this.rol = rol;
}

public String getApeMater() {
	return apeMater;
}

public void setApeMater(String apeMater) {
	this.apeMater = apeMater;
}

public String getApePater() {
	return apePater;
}

public void setApePater(String apePater) {
	this.apePater = apePater;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public List<Cuenta> getCuenta() {
	return cuenta;
}

public void setCuenta(List<Cuenta> cuenta) {
	this.cuenta = cuenta;
}

public List<Rol> getRol() {
	return rol;
}

public void setRol(List<Rol> rol) {
	this.rol = rol;
}

public void setId(Long id) {
	this.id = id;
}



}
