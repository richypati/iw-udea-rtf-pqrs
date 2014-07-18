package co.com.inversionesxyz.dao.impl;

// Generated 18/07/2014 03:16:24 PM by Hibernate Tools 3.4.0.CR1

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dto.Cuenta;

/**
 * Home object for domain model class Cuenta.
 * @see .Cuenta
 * @author Hibernate Tools
 */
public class CuentaDAO extends AbstractDAO {

	private static final Log log = LogFactory.getLog(CuentaDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Cuenta transientInstance) {
		log.debug("persisting Cuenta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cuenta instance) {
		log.debug("attaching dirty Cuenta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}


	public void delete(Cuenta persistentInstance) {
		log.debug("deleting Cuenta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	public Cuenta findById(java.lang.String id) {
		log.debug("getting Cuenta instance with id: " + id);
		try {
			Cuenta instance = (Cuenta) sessionFactory.getCurrentSession().get(
					"Cuenta", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
