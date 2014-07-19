package co.com.inversionesxyz.dao.cfg;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import co.com.inversionesxyz.exception.SessionFactoryException;

public class HibernateSessionFactory {
	
	private static final Log log = LogFactory.getLog(HibernateSessionFactory.class);
	
	private static HibernateSessionFactory instancia = null;
	private static SessionFactory sessionFactory = null;
	private static Configuration configuration = new Configuration();

	private HibernateSessionFactory() {}
		
	public static HibernateSessionFactory getInstance(){
		if(instancia == null)
			instancia = new HibernateSessionFactory();		
		return instancia;
	}	
	
	/**
	 * Construye la factoria de sesiones con el archivo de configuración de Hibernate dado
	 * @throws SessionFactoryException
	 */
	private static void rebuildSessionFactory() throws SessionFactoryException{
		try{
			configuration.configure("co/com/inversionesxyz/dao/cfg/hibernate.cfg.xml");	
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
												 .applySettings(configuration.getProperties())
												 .build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}catch(HibernateException e){
			log.error(MessageFormat.format(
					"No fue posible construir el SessionFactory. Causa {0}", 
					e.getMessage()));
			throw new SessionFactoryException("No fue posible construir el SessionFactory");
		}
	}
	
	/**
	 * Obtiene una sesión activa
	 * @return
	 */
	public Session getSession() {
		if(sessionFactory == null)
			rebuildSessionFactory();
		return sessionFactory.openSession();
		
	}

}
