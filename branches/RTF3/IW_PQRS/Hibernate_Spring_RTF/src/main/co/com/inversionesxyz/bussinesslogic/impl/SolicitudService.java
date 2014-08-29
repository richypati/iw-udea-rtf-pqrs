package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.ISolicitudService;
import co.com.inversionesxyz.bussinesslogic.IUtilService;
import co.com.inversionesxyz.dao.IAnalistaDAO;
import co.com.inversionesxyz.dao.IProductoDAO;
import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dao.ISucursalDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;
import co.com.inversionesxyz.dto.Producto;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.dto.Sucursal;
import co.com.inversionesxyz.exception.EmailException;
import co.com.inversionesxyz.webservices.dto.SolicitudWS;

/**
 * Clase que define las operaciones a realizar sobre las solicitudes
 * 
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class SolicitudService implements ISolicitudService {

	@Autowired
	ISolicitudDAO solicitudDAO;

	@Autowired
	IAnalistaDAO analistaDAO;

	@Autowired
	IProductoDAO productoDAO;

	@Autowired
	ISucursalDAO sucursalDAO;
	
	IUtilService utilService = new UtilService();

	@Override
	public int guardarSolicitud(SolicitudWS solicitudWS) throws EmailException {
		Solicitud solicitud = new Solicitud();
		solicitud.setEmailCliente(solicitudWS.getEmailCliente());
		solicitud.setTipoDocumento(solicitudWS.getTipoDocumento());
		solicitud.setNombreCliente(solicitudWS.getNombreCliente());
		solicitud.setDescripcion(solicitudWS.getDescripcion());
		solicitud.setTipo(solicitudWS.getTipo());
		Calendar calendar = Calendar.getInstance();
		solicitud.setEstado("ABIERTO");
		solicitud.setFechaCreacion(calendar.getTime());
		
		InformacionAnalista infoAnalista = analistaDAO
				.consultarPorCodigo(solicitudWS.getDniAnalista());
		solicitud.setInformacionAnalista(infoAnalista);

		Producto producto = productoDAO.consultarPorCodigo(solicitudWS
				.getCodigoProducto());
		
		Sucursal sucursal = sucursalDAO.consultarPorCodigo(producto.getSucursal().getCodigo());
		producto.setSucursal(sucursal);
		
		solicitud.setProducto(producto);
		
		int idSolicitud = solicitudDAO.insertar(solicitud);
		
		utilService.notificarSolicitudACliente(solicitud.getId(), solicitud.getNombreCliente(), solicitud.getEmailCliente());
		return idSolicitud;
	}

	@Override
	public Solicitud consultarSolicitud(int idSolicitud) {
		return solicitudDAO.consultar(idSolicitud);
	}

	@Override
	public void DelegarSolicitud(int idSolicitud, String dni)
			throws EmailException {
		Solicitud solicitud = solicitudDAO.consultar(idSolicitud);
		InformacionAnalista infoAnalista = analistaDAO.consultarPorCodigo(dni);
		solicitud.setInformacionAnalista(infoAnalista);
		solicitudDAO.actualizar(solicitud);
		utilService.notificarSolicitudDelegada(idSolicitud,
				infoAnalista.getNombre(), infoAnalista.getCorreo());
	}

	@Override
	public void ResponderSolicitud(Solicitud solicitud) throws EmailException {
		Calendar calendar = Calendar.getInstance();
		solicitud.setEstado("RESUELTO");
		solicitud.setFechaAtencion(calendar.getTime());
		solicitudDAO.actualizar(solicitud);
		utilService.notificarRespuestaALaSolicitud(solicitud,
				solicitud.getEmailCliente());
	}

	@Override
	public List<Solicitud> obtenerSolicitudesPorEstado(String estado) {
		return solicitudDAO.consultarColeccion("estado", estado);
	}

	@Override
	public void CancelarSolicitud(int idSolicitud, String emailCliente,
			String motivo) throws EmailException {
		solicitudDAO.actualizarEstado(idSolicitud, "CANCELADO");
		utilService.notificarSolicitudCancelada(idSolicitud, emailCliente,
				motivo);
	}

	@Override
	public void ActualizarSolicitud(Solicitud solicitud) {
		solicitudDAO.actualizar(solicitud);
	}

	@Override
	public List<Solicitud> consultarPorSucursal(String codigoSucursal) {
		return solicitudDAO.consultarSolicitudPorSucursal(codigoSucursal);
	}

	@Override
	public List<Solicitud> consultarPorEstado(String estado) {
		return solicitudDAO.consultarSolicitudPorEstado(estado);
	}

	public void setSolicitudDAO(ISolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	public void setAnalistaDAO(IAnalistaDAO analistaDAO) {
		this.analistaDAO = analistaDAO;
	}

	public void setProductoDAO(IProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}
	
	public void setSucursalDAO(ISucursalDAO sucursalDAO){
		this.sucursalDAO = sucursalDAO;
	}

	@Override
	public List<Solicitud> consultarSolicitudesPorAnalista(String dni) {
		return solicitudDAO.consultarSolicitudesPorAnalista(dni);
	}

}
