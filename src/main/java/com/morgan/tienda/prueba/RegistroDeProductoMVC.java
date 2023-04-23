package com.morgan.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.morgan.tienda.dao.CategoriaDAO;
import com.morgan.tienda.dao.ProductoDAO;
import com.morgan.tienda.modelo.Categoria;
import com.morgan.tienda.modelo.Producto;
import com.morgan.tienda.utils.JPAUtils;

public class RegistroDeProductoMVC {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		
		Producto celular = new Producto("Samsung","Telefono Usado", new BigDecimal("100"),celulares);
		
		
		//Conexion con la base de datos
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		em.getTransaction().begin();//Indicamos que va a iniciar una transaccion
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		em.getTransaction().commit();
		em.close();//cerramos la conexion
	}

}
