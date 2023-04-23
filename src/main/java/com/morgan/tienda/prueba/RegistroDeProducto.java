package com.morgan.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.morgan.tienda.modelo.Producto;

public class RegistroDeProducto {

	public static void main(String[] args) {
		//Creando nuestro Objeto Producto
		Producto celular = new Producto();
		celular.setNombre("Samsung");
		celular.setDescripcion("Telefono Usado");
		celular.setPrecio(new BigDecimal("1000"));
		
		//Conexion con la base de datos
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");//El nombre de nuestra Persistence en persistence.xml
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();//Indicamos que va a iniciar una transaccion
		em.persist(celular);//Guardamos (Persistimos) nuestro Objeto(Producto) Celular
		em.getTransaction().commit();//Enviamos los valores a la base de datos (INSERT)
		em.close();//cerramos la conexion
	}

}
