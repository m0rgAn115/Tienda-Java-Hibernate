package com.morgan.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.morgan.tienda.dao.CategoriaDAO;
import com.morgan.tienda.dao.ProductoDAO;
import com.morgan.tienda.modelo.Categoria;
import com.morgan.tienda.modelo.Producto;
import com.morgan.tienda.utils.JPAUtils;

public class CicloDeVidaEntidad {
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");//LA ENTIDAD SE ENCUENTRA EN ESTADO TRANSIENTE
			
		EntityManager em = JPAUtils.getEntityManager();
		
		/*
		em.getTransaction().begin();//Indicamos que va a iniciar una transaccion
		
		em.persist(celulares); //La entidad cambia a estado Managed(INSERT)
		
		//Si hacemos cambios en la entidad cuando está se encuentra en estado Managed, los cambios se actualizaran en la bd (UPDATE)
		
		celulares.setNombre("LIBROS"); //Se actualiza en nombre en la db porque esta en Managed (UPDATE)
		
		
		em.getTransaction().commit();//SE GUARDAS LOS CAMBIOS Y NO PERMITE HACER OTRO COMMIT
		
		
		em.close();//cerramos el entity Manager//LA ENTIDAD PASA A ESTAR EN ESTADO  DETACHED SIMILAR AL TRANSIENTE
		
		celulares.setNombre("CELULARES"); //SOLO SE CAMBIARA EN NUESTRA ENTIDAD PORQUE LA ENTIDAD YA NO ESTA EN EL ESTADO MANAGED
		
		*/
		
		em.getTransaction().begin();
		
		em.persist(celulares);
		
		celulares.setNombre("LIBROS");
		
		em.flush(); // GUARDA LOS CAMBIOS A LA BASE DE DATOS, PERO PERMITE GUARDAS  MAS COSAS CON COMMIT O FLUSH
		em.clear();//Limpia todo y pone las entidades en estado detached
		
		
		/*Se puede hacer asi
		celulares.setNombre("Celulares");
		em.merge(celulares);//Copia los valores de la entidad de la tabla y la reasignamos a nuestra clase Java, haciendo
										//que nuestra clase pase a estado managed de nuevo
		*/
		
		//O ASI
		celulares = em.merge(celulares);//Copia los valores de la entidad de la tabla y la reasignamos a nuestra clase Java, haciendo
										//que nuestra clase pase a estado managed de nuevo
		celulares.setNombre("Celulares");
		em.flush();
		
		em.remove(celulares);//elimina el registro
		em.flush();
		}

}
