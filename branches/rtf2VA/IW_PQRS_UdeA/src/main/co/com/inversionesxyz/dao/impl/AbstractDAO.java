package co.com.inversionesxyz.dao.impl;

import org.hibernate.Session;

import co.com.inversionesxyz.dao.cfg.HibernateSessionFactory;
import co.com.inversionesxyz.exception.InexistentObjectException;

public abstract class AbstractDAO<T> {
	
	private Session session;
	private Class<T> type;
	
	public AbstractDAO(Class<T> type){
		this.type = type;
	}
	protected Session getSession() {
		return HibernateSessionFactory.getInstance().getSession();
	}
	
	protected void close(){
		if(session.isOpen()){
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected T consultar(String field) throws InexistentObjectException{
		try{
			session = getSession();
			return (T)session.get(type, field);
		}catch(Exception e){
			e.printStackTrace();
			throw new InexistentObjectException(e);
		}finally{
			close();
		}
		
	}

}
