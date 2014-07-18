package co.com.inversionesxyz.dao.impl;

// default package
// Generated 18/07/2014 03:16:24 PM by Hibernate Tools 3.4.0.CR1

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dao.IDetalleClienteDAO;
import co.com.inversionesxyz.dto.DetalleCliente;

/**
 * Home object for domain model class DetalleCliente.
 * @see .DetalleCliente
 * @author Hibernate Tools
 */
public class DetalleClienteDAO extends AbstractDAO implements IDetalleClienteDAO {

	private static final Log log = LogFactory.getLog(DetalleClienteDAO.class);

	private final SessionFactory sessionFactory = getSessionFactory();

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


	public DetalleCliente findById(java.lang.String id) {
		log.debug("getting DetalleCliente instance with id: " + id);
		try {
			DetalleCliente instance = (DetalleCliente) sessionFactory
					.getCurrentSession().get("DetalleCliente", id);
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
