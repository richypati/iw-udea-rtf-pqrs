package co.com.inversionesxyz.dao.impl;

import java.io.Serializable;
import java.text.MessageFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.com.inversionesxyz.exception.BasicDBOperationException;
import co.com.inversionesxyz.exception.SessionFactoryException;

public abstract class AbstractDAO<T> extends HibernateDaoSupport{
	
	private static final Log log = LogFactory.getLog(AbstractDAO.class);
	
	private Session session;
	private Class<T> type;
	
	public AbstractDAO(Class<T> type){
		this.type = type;
	}
	protected Session getCurrentSession() {
		try{
			session = getSessionFactory().getCurrentSession() ;
			return session;
		}catch(RuntimeException e){
			e.printStackTrace();
			log.error(MessageFormat.format(
					"No fue posible obtener la sesion. Causa {0}", 
					e.getMessage()));
			throw new SessionFactoryException("No fue posible obtener la sesion");
		}
	}
	
	protected void close(){
		if(session.isOpen()){
			session.close();
		}
	}
	
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

}
