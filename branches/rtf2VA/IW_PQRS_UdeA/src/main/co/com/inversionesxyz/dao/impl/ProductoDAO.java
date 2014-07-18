package co.com.inversionesxyz.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import co.com.inversionesxyz.dao.IProductoDAO;
import co.com.inversionesxyz.dto.Producto;

/**
 * Home object for domain model class Producto.
 * @see .Producto
 * @author Hibernate Tools
 */
public class ProductoDAO extends AbstractDAO implements IProductoDAO{

	private static final Log log = LogFactory.getLog(ProductoDAO.class);
	
	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Producto transientInstance) {
		log.debug("persisting Producto instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Producto instance) {
		log.debug("attaching dirty Producto instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Producto persistentInstance) {
		log.debug("deleting Producto instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Producto merge(Producto detachedInstance) {
		log.debug("merging Producto instance");
		try {
			Producto result = (Producto) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Producto findById(java.lang.String id) {
		log.debug("getting Producto instance with id: " + id);
		try {
			Producto instance = (Producto) sessionFactory.getCurrentSession()
					.get("Producto", id);
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
