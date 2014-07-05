package com.xyz.dao;

// Generated 4/07/2014 07:36:05 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.xyz.dto.DetalleCliente;

/**
 * Home object for domain model class DetalleCliente.
 * @see com.xyz.dto.DetalleCliente
 * @author Hibernate Tools
 */
public class DetalleClienteHome {

	private static final Log log = LogFactory.getLog(DetalleClienteHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DetalleCliente transientInstance) {
		log.debug("persisting DetalleCliente instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DetalleCliente instance) {
		log.debug("attaching dirty DetalleCliente instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(DetalleCliente instance) {
		log.debug("attaching clean DetalleCliente instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DetalleCliente persistentInstance) {
		log.debug("deleting DetalleCliente instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DetalleCliente merge(DetalleCliente detachedInstance) {
		log.debug("merging DetalleCliente instance");
		try {
			DetalleCliente result = (DetalleCliente) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DetalleCliente findById(java.lang.String id) {
		log.debug("getting DetalleCliente instance with id: " + id);
		try {
			DetalleCliente instance = (DetalleCliente) sessionFactory
					.getCurrentSession().get("com.xyz.dto.DetalleCliente", id);
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

	@SuppressWarnings("unchecked")
	public List<DetalleCliente> findByExample(DetalleCliente instance) {
		log.debug("finding DetalleCliente instance by example");
		try {
			List<DetalleCliente> results = sessionFactory.getCurrentSession()
					.createCriteria("com.xyz.dto.DetalleCliente")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
