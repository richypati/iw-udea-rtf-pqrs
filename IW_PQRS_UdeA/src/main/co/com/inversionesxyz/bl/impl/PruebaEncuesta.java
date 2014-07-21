package co.com.inversionesxyz.bl.impl;

import co.com.inversionesxyz.dao.IEncuestaDAO;
import co.com.inversionesxyz.dao.impl.EncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class PruebaEncuesta {

	public static void main(String[] args) throws BasicDBOperationException {
		// TODO Auto-generated method stub
		IEncuestaDAO encuestaDAO = new EncuestaDAO();
		Encuesta encuesta = encuestaDAO.consultarPorSolicitud(1);
		System.out.println(encuesta.getRespuestaPreguntaA());
	}

}
