//package co.com.inversionesxyz.dao.impl;
//
//import java.text.MessageFormat;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.Session;
//
//import co.com.inversionesxyz.dao.IAnalistaDAO;
//import co.com.inversionesxyz.dto.Analista;
//import co.com.inversionesxyz.exception.InexistentObjectException;
//
//
///**
// * Clase que define las operaciones las operaciones a realizar en base de datos sobre un Analista como detalle de un mensaje
// * @see .Analista
// * @author Jennifer Pérez
// * @author Ricardo Patiño
// */
//public class AnalistaDAO extends AbstractDAO implements IAnalistaDAO{
//
//	private static final Log log = LogFactory.getLog(AnalistaDAO.class);
//
//	@Override
//	public Analista consultarPorCodigo(String codigo) throws InexistentObjectException {
//		Session session = null;
//		
//		try{
//			session = getSession();
//			return (Analista)session.get(Analista.class, codigo);
//		}catch (Exception e) {
//			log.error(MessageFormat.format(
//					"No fue posible consultar el analista con codigo {0}. Causa {1}",
//					codigo,
//					e.getCause()));
//			throw new InexistentObjectException(MessageFormat.format(
//					"No fue posible consultar el analista con codigo {0}",
//					codigo));
//		}finally{
//			close();
//		}
//		
//	}
//		
//	
//	
//}
