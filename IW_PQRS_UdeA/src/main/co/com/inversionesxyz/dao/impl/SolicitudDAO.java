package co.com.inversionesxyz.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;

/**
 * Home object for domain model class Solicitud.
 * @see .Solicitud
 * @author Hibernate Tools
 */
public class SolicitudDAO extends AbstractDAO implements ISolicitudDAO{

	private static final Log log = LogFactory.getLog(SolicitudDAO.class);
	
	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Solicitud transientInstance) {
		log.debug("persisting Solicitud instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Solicitud instance) {
		log.debug("attaching dirty Solicitud instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Solicitud persistentInstance) {
		log.debug("deleting Solicitud instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Solicitud merge(Solicitud detachedInstance) {
		log.debug("merging Solicitud instance");
		try {
			Solicitud result = (Solicitud) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Solicitud findById(java.lang.String id) {
		log.debug("getting Solicitud instance with id: " + id);
		try {
			Solicitud instance = (Solicitud) sessionFactory.getCurrentSession()
					.get("Solicitud", id);
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
