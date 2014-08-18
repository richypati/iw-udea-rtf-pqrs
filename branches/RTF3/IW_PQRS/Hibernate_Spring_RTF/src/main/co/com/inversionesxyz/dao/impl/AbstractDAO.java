package co.com.inversionesxyz.dao.impl;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.exception.BasicDBOperationException;
import co.com.inversionesxyz.exception.SessionFactoryException;

/**
 * Clase abstracta ue define las operaciones generales a realizar sobre la base de datos
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public abstract class AbstractDAO<T> {
	
	private static final Log log = LogFactory.getLog(AbstractDAO.class);
	
	@Autowired
    private SessionFactory sessionFactory;
    
	private Session session;
	private Class<T> type;
	
	public AbstractDAO(Class<T> type){
		this.type = type;
	}
	
	/**
	 * Permite obtener la sesion para el dao que extienda de esta clase
	 * @return Session la sesion generada
	 */
	protected Session getCurrentSession() {
		try{
			session = sessionFactory.openSession();
			return session;
		}catch(RuntimeException e){
			e.printStackTrace();
			log.error(MessageFormat.format(
					"No fue posible obtener la sesion. Causa {0}", 
					e.getMessage()));
			throw new SessionFactoryException("No fue posible obtener la sesion");
		}
	}
	
	/**
	 * Permite cerrar una sesion previamente abierta
	 */
	protected void close(){
		if(session.isOpen()){
			session.close();
		}
	}
	
	/**
	 * Permite consultar un objeto por un criterio cualquiera
	 * @param field criterio de busqueda
	 * @return T objeto que cumple con el criterio de busqueda
	 */
	@SuppressWarnings("unchecked")
	protected T getByField(Object field) throws BasicDBOperationException{
		try{
			session = getCurrentSession();
			return (T)session.get(type, (Serializable)field);
		}catch(Exception e){
			throw new BasicDBOperationException(e);
		}finally{
			close();
		}
	}
	
	/**
	 * Permite consultar una coleccion de objetos que cumplan con un cierto criterio de busqueda
	 * @param field criterio de busqueda
	 * @return List<T> lista de objetos que cumplen con el criterio de busqueda
	 */
	@SuppressWarnings("unchecked")
	protected List<T> getCollectionByField(Object field) throws BasicDBOperationException{
		try{
			session = getCurrentSession();
			return (List<T>)session.get(type, (Serializable)field);
		}catch(Exception e){
			throw new BasicDBOperationException(e);
		}finally{
			close();
		}
		
	}
	
	/**
	 * Permite insertar un objeto
	 * @param object objeto a insertar
	 */
	protected void insert(Object object) throws BasicDBOperationException{
		Transaction transaction = null;
		try{
			session = getCurrentSession();
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		}catch(Exception e){
			throw new BasicDBOperationException(e);
		}finally{
			close();
		}
	}
	
	/**
	 * Permite eliminar un objeto
	 * @param object objeto a eliminar
	 */
	protected void delete(Object object) throws BasicDBOperationException{
		Transaction transaction = null;
		try{
			session = getCurrentSession();
			transaction = session.beginTransaction();
			session.delete(object);
			transaction.commit();
		}catch(Exception e){
			throw new BasicDBOperationException(e);
		}finally{
			close();
		}
	}
	
	/**
	 * Permite actualizar un objeto 
	 * @param object objeto a actualizar
	 */
	protected void update(Object object) throws BasicDBOperationException{
		Transaction transaction = null;
		try{
			session = getCurrentSession();
			transaction = session.beginTransaction();
			session.update(object);
			transaction.commit();
		}catch(Exception e){
			throw new BasicDBOperationException(e);
		}finally{
			close();
		}
	}
	
	/**
	 * Permite ejecutar una sentencia SQL
	 * @param query Sentencia a ejecutar
	 */
	protected Object executeSQLQuery(String query){
		Transaction transaction = null;
		Object o=null;
		try{
			session = getCurrentSession();
			transaction = session.beginTransaction();
			o = session.createSQLQuery(query);
			transaction.commit();
			return o;
		}catch(Exception e){
			throw new BasicDBOperationException(e);
		}finally{
			close();
		}
	}
	
	/**
	 * Permite actualizar el sessionFactory. Es imperativa su implementacion para las dependecias de Spring
	 * @param sessionFactory sessionFactory a actualizar
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	
}
