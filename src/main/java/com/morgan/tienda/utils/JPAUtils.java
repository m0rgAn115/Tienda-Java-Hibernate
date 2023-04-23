package com.morgan.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
