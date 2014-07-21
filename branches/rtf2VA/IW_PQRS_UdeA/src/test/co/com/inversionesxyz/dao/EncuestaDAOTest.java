package co.com.inversionesxyz.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.inversionesxyz.dao.impl.EncuestaDAO;
import co.com.inversionesxyz.dto.Encuesta;
import co.com.inversionesxyz.exception.BasicDBOperationException;

public class EncuestaDAOTest {
	
	private IEncuestaDAO dao;
	
	@Before
	public void setUp() {
		dao = new EncuestaDAO();
	}
	

	@Test
	public void testDebeObtenerEncuestaPorIDSolicitid() throws BasicDBOperationException {
		int idSolicitud = 1;
		Encuesta encuesta = dao.consultarPorSolicitud(idSolicitud);
		
		Assert.assertNotNull(encuesta);
	}

}
