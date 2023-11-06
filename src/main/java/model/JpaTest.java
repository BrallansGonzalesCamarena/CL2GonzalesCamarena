package model;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaTest {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
			
		//INSERTAR CLIENTE
		Cliente cli = new Cliente();
		cli.setApeMater("CHAVEZ");
		cli.setApePater("TORRES");
		cli.setNom("LUIS");
		//INSERTAR CUENTA
		Cuenta c = new Cuenta();
		c.setActiva(true);
		c.setNumeroCuenta("9658234812");
		c.setSaldo(3500.00); manager.persist(c);
		//INSERTAR TIPO DE CUENTA
		TipoCuenta tc = new TipoCuenta();
		tc.setDescripcion("CUENTA CORRIENTE");
		tc.setMoneda("SOLES"); 
		//INSERTAR MOVIMIENTO
		Movimiento m = new Movimiento();
		m.setDescripcion("PAGO DE SERVICIOS");
		m.setFecha(LocalDate.now());
		m.setMonto(1000.00);
		//INSERTAR ROL
		Rol r = new Rol();
		r.setDescripcion("TITULAR");
		r.setActivo(true);
		
		Rol r2 = new Rol();
		r2.setDescripcion("DEPOSITADO");
		r2.setActivo(true);
		
		c.setTipoCuenta(tc);
		c.getMovimientos().add(m);
		
		cli.getCuenta().add(c);
		cli.getRol().add(r);
		cli.getRol().add(r2);
		//INSERTAR
		manager.persist(cli);
		tx.commit();
		List<Cliente>listaCliente=manager.createQuery("from Cliente",Cliente.class).getResultList();
		for (Cliente cliente :listaCliente) {
			System.out.println(cliente);
			
		}
		
	}

}
