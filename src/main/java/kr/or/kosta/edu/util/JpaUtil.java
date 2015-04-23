package kr.or.kosta.edu.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
			
		} catch (Throwable t) {
			t.printStackTrace();
			new ExceptionInInitializerError(t);
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static void shutdown() {
		getEntityManagerFactory().close();
	}
}
