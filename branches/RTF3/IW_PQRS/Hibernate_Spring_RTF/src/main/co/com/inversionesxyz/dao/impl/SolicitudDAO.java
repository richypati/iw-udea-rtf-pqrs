package co.com.inversionesxyz.dao.impl;

import java.text.MessageFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.com.inversionesxyz.dao.ISolicitudDAO;
import co.com.inversionesxyz.dto.Solicitud;
import co.com.inversionesxyz.exception.BasicDBOperationException;

/**
 * Clase que define las operaciones a realizar en base de datos sobre una
 * Solicitud
 * 
 * @see .Solicitud
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class SolicitudDAO extends AbstractDAO<Solicitud> implements
		ISolicitudDAO {

	public SolicitudDAO() {
		super(Solicitud.class);
	}

	@Override
	public Solicitud consultar(int idSolicitud) {
		try {
			return getByField(idSolicitud);
		} catch (Exception e) {
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible consultar la solicitud {0}", idSolicitud),
					e.getCause());
		}
	}

	@Override
	public int insertar(Solicitud solicitud) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = getCurrentSession();
			transaction = session.beginTransaction();			
			session.save(solicitud);			
			transaction.commit();
			session.flush();
			return solicitud.getId();
		} catch (Exception e) {
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible insertar la solicitud del cliente {0}",
					solicitud.getEmailCliente()), e.getCause());
		}finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> consultarColeccion(String campo, String valor) {
		List<Solicitud> solicitudes = null;
		try {
			String query = MessageFormat.format(
					"SELECT * FROM SOLICITUD WHERE {0}='{1}'", campo, valor);
			solicitudes = (List<Solicitud>) executeSQLQuery(query);
			return solicitudes;
		} catch (Exception e) {
			throw new BasicDBOperationException(
					MessageFormat.format(
							"No fue posible consultar la lista de solicitudes por campo: {0}",
							campo), e.getCause());
		}
	}

	@Override
	public void actualizar(Solicitud solicitud) {
		try {
			update(solicitud);
		} catch (Exception e) {
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible actualizar la solicitud {0}",
					solicitud.getId()), e.getCause());
		}
	}

	@Override
	public void actualizarEstado(int idSolicitud, String estado) {
		try {
			String query = MessageFormat.format(
					"UPDATE SOLICITUD SET estado='{0}' WHERE id={1}", estado,
					idSolicitud);
			executeSQLQuery(query);
		} catch (Exception e) {
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible actualizar la solicitud {0}", idSolicitud),
					e.getCause());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> consultarSolicitudPorSucursal(String codigoSucursal) {
		Session session = null;
		List<Solicitud> solicitudes=null;
		try{
			session = getCurrentSession();
			String query = MessageFormat.format(
					"SELECT s.* FROM SOLICITUD AS s, PRODUCTO AS p WHERE s.PRODUCTO_codigo=p.codigo AND p.SUCURSAL_codigo={0}", codigoSucursal);
			solicitudes = (List<Solicitud>)session.createSQLQuery(query).list();
			return solicitudes;
		}catch (Exception e) {
			e.printStackTrace();
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible encontrar las solicitudes realizadas a la sucursal con codigo: ", codigoSucursal),
					e.getCause());
		}finally{
			close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> consultarSolicitudPorEstado(String estado) {
		Session session = null;
		List<Solicitud> solicitudes = null;
		try{
			session = getCurrentSession();
			String query = "SELECT * FROM SOLICITUD WHERE estado ='" + estado +"'";
			solicitudes = (List<Solicitud>)session.createSQLQuery(query).list();
			return solicitudes;
		}catch(Exception e){
			e.printStackTrace();
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible encontrar las solicitudes con estado: ", estado),
					e.getCause());
		}finally{
			close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> consultarSolicitudesPorAnalista(String dni) {
		Session session = null;
		List<Solicitud> solicitudes = null;
		try{
			session = getCurrentSession();
			String query = "SELECT * FROM SOLICITUD WHERE INFORMACION_ANALISTA_dni ='" + dni +"'";
			solicitudes = (List<Solicitud>)session.createSQLQuery(query).list();
			return solicitudes;
		}catch(Exception e){
			e.printStackTrace();
			throw new BasicDBOperationException(MessageFormat.format(
					"No fue posible encontrar las solicitudes asignadas al analista con DNI: ", dni),
					e.getCause());
		}finally{
			close();
		}
	}	
}
