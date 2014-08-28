package co.com.inversionesxyz.bussinesslogic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.inversionesxyz.bussinesslogic.IAnalistaService;
import co.com.inversionesxyz.dao.IAnalistaDAO;
import co.com.inversionesxyz.dto.InformacionAnalista;

/**
 * Clase que define las operaciones a realizar sobre la información
 * de los Analistas
 * 
 * @author Jennifer Perez
 * @author Ricardo Patino
 */
public class AnalistaService implements IAnalistaService{

	@Autowired
	IAnalistaDAO analistaDAO;
	
	@Override
	public List<InformacionAnalista> consultarAnalistas() {
		return analistaDAO.consultarTodos();
	}
	
	public void setAnalistaDAO(IAnalistaDAO analistaDAO){
		this.analistaDAO = analistaDAO;
	}

}
