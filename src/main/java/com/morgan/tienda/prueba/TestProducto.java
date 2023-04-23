package com.morgan.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.morgan.tienda.dao.CategoriaDAO;
import com.morgan.tienda.dao.ProductoDAO;
import com.morgan.tienda.modelo.Categoria;
import com.morgan.tienda.modelo.Producto;
import com.morgan.tienda.utils.JPAUtils;

public class TestProducto {
	
	
	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		
		var producto = productoDAO.consultaPorId(1l);
		System.out.println(producto.getCategoria().getNombre());
		var productos = productoDAO.consultarTodos();
		productos.forEach(produc->System.out.println(produc.getNombre()));
		
		var productosPorNombre = productoDAO.consultarPorNombre("Xiaomi Redmi");
		productosPorNombre.forEach(produc -> System.out.println(produc.getNombre()));
		
		var productoPorCategoria = productoDAO.consultarPorNombreDeCategoria("CELULARES");
		System.out.println(productoPorCategoria.get(0).getCategoria().getNombre());
		
		var precio = productoDAO.consultarPrecioPorNombreDelProducto("Xiaomi Redmi");
		System.out.println(precio);
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Producto celular = new Producto("Xiaomi Redmi","Celular Usado", new BigDecimal("800"),celulares);
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
