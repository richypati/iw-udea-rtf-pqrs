//package co.com.inversionesxyz.dao.impl;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.SessionFactory;
//
//import co.com.inversionesxyz.dao.ISucursalDAO;
//import co.com.inversionesxyz.dto.Sucursal;
//
///**
// * Home object for domain model class Sucursal.
// * @see .Sucursal
// * @author Hibernate Tools
// */
//public class SucursalDAO extends AbstractDAO implements ISucursalDAO{
//
//	private static final Log log = LogFactory.getLog(SucursalDAO.class);
//
//	private final SessionFactory sessionFactory = getSessionFactory();
//
//	public void persist(Sucursal transientInstance) {
//		log.debug("persisting Sucursal instance");
//		try {
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			log.debug("persist successful");
//		} catch (RuntimeException re) {
//			log.error("persist failed", re);
//			throw re;
//		}
//	}
//
//	public void attachDirty(Sucursal instance) {
//		log.debug("attaching dirty Sucursal instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Sucursal persistentInstance) {
//		log.debug("deleting Sucursal instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Sucursal merge(Sucursal detachedInstance) {
//		log.debug("merging Sucursal instance");
//		try {
//			Sucursal result = (Sucursal) sessionFactory.getCurrentSession()
//					.merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public Sucursal findById(java.lang.String id) {
//		log.debug("getting Sucursal instance with id: " + id);
//		try {
//			Sucursal instance = (Sucursal) sessionFactory.getCurrentSession()
//					.get("Sucursal", id);
//			if (instance == null) {
//				log.debug("get successful, no instance found");
//			} else {
//				log.debug("get successful, instance found");
//			}
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//
//}
