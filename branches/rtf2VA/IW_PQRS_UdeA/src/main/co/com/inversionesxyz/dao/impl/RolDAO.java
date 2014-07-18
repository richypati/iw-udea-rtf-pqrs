package co.com.inversionesxyz.dao.impl;

// default package
// Generated 18/07/2014 03:16:24 PM by Hibernate Tools 3.4.0.CR1

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dao.IRolDAO;
import co.com.inversionesxyz.dto.Rol;

/**
 * Home object for domain model class Rol.
 * @see .Rol
 * @author Hibernate Tools
 */
public class RolDAO extends AbstractDAO implements IRolDAO{

	private static final Log log = LogFactory.getLog(RolDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Rol transientInstance) {
		log.debug("persisting Rol instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Rol instance) {
		log.debug("attaching dirty Rol instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Rol persistentInstance) {
		log.debug("deleting Rol instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}


	public Rol findById(java.lang.String id) {
		log.debug("getting Rol instance with id: " + id);
		try {
			Rol instance = (Rol) sessionFactory.getCurrentSession().get("Rol",
					id);
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
