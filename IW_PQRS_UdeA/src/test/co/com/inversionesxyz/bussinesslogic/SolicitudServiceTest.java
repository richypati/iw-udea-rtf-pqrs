package co.com.inversionesxyz.bussinesslogic;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import co.com.inversionesxyz.bussinesslogic.impl.SolicitudService;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.dto.Sucursal;

@RunWith(MockitoJUnitRunner.class)
public class SolicitudServiceTest {

	@Mock
	private ISolicitudDAO dao;
	
	@InjectMocks
	private ISolicitudService service = new SolicitudService();
	
	private Solicitud solicitud;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		InformacionAnalista informacionAnalista =  new InformacionAnalista();
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
		solicitud.setEmailCliente("cliente@correo.com");
		solicitud.setInformacionAnalista(informacionAnalista);
		solicitud.setNombreCliente("Cliente");
		solicitud.setPrioridad("ALTA");
		solicitud.setProducto(producto);
		solicitud.setTipo("QUEJA");
		solicitud.setTipoDocumento("C2345567789");
	}
	
	@Test
	public void testDebeObtenerEncuesta() {
		when(dao.consultar(123)).thenReturn(solicitud);		
		service.consultarSolicitud(123);
		verify(dao).consultar(123);
	}

}
