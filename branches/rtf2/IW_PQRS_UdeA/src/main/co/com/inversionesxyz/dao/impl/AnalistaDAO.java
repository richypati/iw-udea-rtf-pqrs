package co.com.inversionesxyz.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dao.IAnalistaDAO;


/**
 * Home object for domain model class Analista.
 * @see .Analista
 * @author Hibernate Tools
 */
public class AnalistaDAO extends AbstractDAO implements IAnalistaDAO{

	private static final Log log = LogFactory.getLog(AnalistaDAO.class);
	
	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(AnalistaDAO transientInstance) {
		log.debug("persisting Analista instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnalistaDAO instance) {
		log.debug("attaching dirty Analista instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnalistaDAO persistentInstance) {
		log.debug("deleting Analista instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnalistaDAO findById(java.lang.String id) {
		log.debug("getting Analista instance with id: " + id);
		try {
			AnalistaDAO instance = (AnalistaDAO) sessionFactory.getCurrentSession()
					.get("Analista", id);
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
