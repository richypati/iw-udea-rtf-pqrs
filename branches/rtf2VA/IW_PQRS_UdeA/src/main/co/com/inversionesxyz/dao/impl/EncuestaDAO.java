package co.com.inversionesxyz.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;

/**
 * Home object for domain model class Encuesta.
 * @see .Encuesta
 * @author Hibernate Tools
 */
public class EncuestaDAO extends AbstractDAO implements IEncuestaDAO{

	private static final Log log = LogFactory.getLog(EncuestaDAO.class);
	
	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Encuesta transientInstance) {
		log.debug("persisting Encuesta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Encuesta instance) {
		log.debug("attaching dirty Encuesta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Encuesta persistentInstance) {
		log.debug("deleting Encuesta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Encuesta findById(java.lang.String id) {
		log.debug("getting Encuesta instance with id: " + id);
		try {
			Encuesta instance = (Encuesta) sessionFactory.getCurrentSession()
					.get("Encuesta", id);
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
