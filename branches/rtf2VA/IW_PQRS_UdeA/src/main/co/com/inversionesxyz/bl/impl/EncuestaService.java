package co.com.inversionesxyz.bl.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.inversionesxyz.bl.IEncuestaService;
import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

@Service("encuestaService")
public class EncuestaService implements IEncuestaService{

	@Autowired
	IEncuestaDAO encuestaDAO;

	@Override
	@Transactional
	public Encuesta consultarPorSolicitud(int idSolicitud) throws BasicDBOperationException {
		return encuestaDAO.consultarPorSolicitud(idSolicitud);
	}
	
	public IEncuestaDAO getEncuestaDAO() {
		return encuestaDAO;
	}
	
	public void setEncuestaDAO(IEncuestaDAO encuestaDAO) {
		this.encuestaDAO = encuestaDAO;
	}
	
}
