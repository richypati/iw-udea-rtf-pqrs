package co.com.inversionesxyz.bussinesslogic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.inversionesxyz.bussinesslogic.impl.SolicitudService;
import co.com.inversionesxyz.dao.IProductoDAO;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.dto.Sucursal;

@RunWith(MockitoJUnitRunner.class)
public class SolicitudServiceTest {

	@Mock
	private ISolicitudDAO solicitudDAO;
	
	@Mock
	private IProductoDAO productoDAO;
	
	@InjectMocks
	private ISolicitudService service = new SolicitudService();
	
	private Solicitud solicitud;
	
	private InformacionAnalista informacionAnalista;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		informacionAnalista =  new InformacionAnalista();
		informacionAnalista.setCorreo("analista@correo.com");
		informacionAnalista.setDni("C12345678");
		informacionAnalista.setNombre("analista");
		informacionAnalista.setTelefono("12345");
		
		Sucursal sucursal = new Sucursal();
		sucursal.setCiudad("Ciudad");
		sucursal.setCodigo("1");
		sucursal.setDireccion("CL 12 N 1");
		sucursal.setNombre("Sucursal");
		sucursal.setPais("pais");
		
		Producto producto = new Producto();
		producto.setCodigo("123");
		producto.setNombre("producto");
		producto.setSucursal(sucursal);
		
		solicitud = new Solicitud();
		solicitud.setComplejidad("ALTA");
		solicitud.setDescripcion("Nueva solicitud");
		solicitud.setEmailCliente("richypati@gmail.com");
		solicitud.setInformacionAnalista(informacionAnalista);
		solicitud.setNombreCliente("Cliente");
		solicitud.setPrioridad("ALTA");
		solicitud.setProducto(producto);
		solicitud.setTipo("QUEJA");
		solicitud.setTipoDocumento("C2345567789");
		solicitud.setEstado("ABIERTO");
		
		Solicitud solicitud2 = new Solicitud();
		solicitud2.setComplejidad("ALTA");
		solicitud2.setDescripcion("Solicitud numero 2");
		solicitud2.setEmailCliente("richypati@gmail.com");
		solicitud2.setInformacionAnalista(informacionAnalista);
		solicitud2.setNombreCliente("Cliente DOS");
		solicitud2.setPrioridad("ALTA");
		solicitud2.setProducto(producto);
		solicitud2.setTipo("PREGUNTA");
		solicitud2.setTipoDocumento("C654321789");
		solicitud2.setEstado("ABIERTO");
	}
	
	@Test
	public void testDebeObtenerSolicitud() {
		when(solicitudDAO.consultar(123)).thenReturn(solicitud);		
		service.consultarSolicitud(123);
		verify(solicitudDAO).consultar(123);
	}
	
	@Test (expected = NullPointerException.class)
	public void testRetornaExcepcionCampoVacío() {
		solicitud = null;
		service.guardarSolicitud(solicitud);
	}

	@Test
	public void testConsultarSolicitud() {
		service.consultarSolicitud(0);
		assertNotNull(solicitud);
	}
	
	@Test
	public void testConsultarSolicitudNoExistente() {
		solicitud = service.consultarSolicitud(1);
		assertNull(solicitud);
	}

	@Test (expected = NullPointerException.class)
	public void testDelegarSolicitudConInformacionAnalistaVacio() {
		
		informacionAnalista = null;
		solicitud.setInformacionAnalista(informacionAnalista);
		service.ActualizarSolicitud(solicitud);
	}
	
	@Test
	public void testObtenerSolicitudesPorEstado() {
		List<Solicitud> solicitudes = service.obtenerSolicitudesPorEstado("ABIERTO");
		assertNotNull(solicitudes);
	}
	
	@Test
	public void testObtenerListaVaciaDeSolicitudesPorEstado() {
		List<Solicitud> solicitudes = service.obtenerSolicitudesPorEstado("CERRADO");
		assertTrue(solicitudes.isEmpty());
	}

//	@Test
//	public void testCancelarSolicitud() throws EmailException {
//		
//		service.CancelarSolicitud(solicitud.getId(),
//				solicitud.getEmailCliente(), "Porque me da la gana");
//		assertEquals("CANCELADO", solicitud.getEstado());
//	}

//	@Test 
//	public void testActualizarSolicitudNula() {
//		solicitud = null;
//		service.ActualizarSolicitud(solicitud);
//	}

}
