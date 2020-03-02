package pe.com.claro.website.app.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.LineDAO;
import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.app.domain.Line;
import pe.com.claro.website.app.service.LineService;

public class LineServiceImpl implements LineService {
	
	private static Log log = LogFactory.getLog(LineServiceImpl.class);
	
	private LineDAO dao;

	/**
	 * @return
	 */
	protected LineDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(LineDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#actualizar(java
	 * .lang.Object)
	 */
	public void actualizar(Line to) throws AbstractException {
		try {
			getDao().update(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#listar(java.lang
	 * .Object)
	 */
	public List<Line> listarAll(Integer id) throws AbstractException {
		List<Line> list = null;
		try {
			list = getDao().listarAll(id);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#registrar(java.
	 * lang.Object)
	 */
/*	public void registrar(Line to) throws AbstractException {
		try {
			getDao().registrar(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_REGISTRAR_ERROR + e.getMessage());
		}

	}*/
	
	/* lsoto: 29:06:19: Agregar la validación de línea repetida al momento del registro: INICIO*/
	
	public void registrar(Line to) throws AbstractException {
		try {
			//*String valor = to.getNumberLine();
			if(encontrarLinea(to.getNumberLine())==0){
				getDao().registrar(to);
			}else{
				to.setCodigoError(new Integer(-2));
				to.setMensajeError("La línea que intenta agregar, ya existe.");
			}
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_REGISTRAR_ERROR + e.getMessage());
		}

	}

	public int encontrarLinea(String numeroLinea) {
		int existe=0;
		
		try{
			existe = getDao().encontrarLinea(numeroLinea);
		}catch(Exception e){
			throw new AbstractException(Constante.KEY_VALIDAR_EXISTENCIA_LINEA_ERROR + e.getMessage());
		}
		return existe;
	}
	/* lsoto: 29:06:19: Agregar la validación de línea repetida al momento del registro: FIN*/


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#buscarPorId(java
	 * .lang.String)
	 */
	public Line selectById(String id) throws AbstractException {
		Line domain = null;

		try {
			domain = getDao().selectById(id);

		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_SELECT_BYID);
		}

		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#eliminar(java.lang
	 * .Object)
	 */
	public void eliminar(String to) throws AbstractException {
		try {
			getDao().eliminar(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_DELETE_ERROR);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#eliminar(java.lang
	 * .Object)
	 */
//	public void eliminarArray(int[] ids) throws AbstractException {
//		try {
//			for (int i = 0; i < ids.length; i++) {
//
//				getDao().eliminar(ids[i]);
//			}
//
//		} catch (Exception e) {
//			throw new AbstractException(Constante.KEY_DELETE_ERROR);
//		}
//
//	}
//	

	
//	private List<Cliente> findByFilter(Cliente cliente) {
//		List<Cliente> list=getDao().listarForName(cliente);
//		return list;
//	}


	public Line findByNombre(Line line) {
		Line domain=null;
		List<Line> list=getDao().listarForName(line);
		if (list.size()>0) {
			domain=list.get(0);
		}
		return domain;
	}
}
