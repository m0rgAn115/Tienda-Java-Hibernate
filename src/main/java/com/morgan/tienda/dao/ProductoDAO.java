package com.morgan.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.morgan.tienda.modelo.Producto;

public class ProductoDAO {
	
	private EntityManager em;
	
	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public Producto consultaPorId(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jpql = "SELECT P FROM Producto AS P"; 
		return em.createQuery(jpql,Producto.class).getResultList();
	}
	
	public List<Producto> consultarPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
		
		/*
		 * Otra forma
		 * String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=1"; PODEMOS USAR NUMEROS PARA IDENTIFICAR
		   return em.createQuery(jpql,Producto.class).setParameter(1, nombre).getResultList();
		 * 
		 */
	}
	
	public List<Producto> consultarPorNombreDeCategoria(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal consultarPrecioPorNombreDelProducto(String nombre) {
		String jpql="SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
