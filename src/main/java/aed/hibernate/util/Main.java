package aed.hibernate.util;

import org.hibernate.Session;

public class Main {

	static Session sesion = null;
	
	public static void main(String[] args) {
		
		sesion = HibernateUtil.getSessionFactory().openSession();

		sesion.close();
	}

}
