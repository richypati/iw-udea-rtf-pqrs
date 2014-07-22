package co.com.inversionesxyz.bussinesslogic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.inversionesxyz.bussinesslogic.impl.EncuestaService;
import co.com.inversionesxyz.dao.IEncuestaDAO;

@RunWith(MockitoJUnitRunner.class)
public class EncuestaServiceTest {
	
	@Mock
	private IEncuestaDAO dao;
	
	@InjectMocks
	private IEncuestaService service = new EncuestaService();
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDebeRetornarExcepcionSiSeInsertaRespuestaVacia() {
		service.almacenarEncuesta(123, "", "S");
	}
	
	@Test (expected = NullPointerException.class)
	public void testDebeRetornarExcepcionSiSeInsertaRespuestaNula() {
		service.almacenarEncuesta(123, "S", null);
	}
	
}
