package pe.com.claro.website.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.ParametroDAO;
import pe.com.claro.website.app.dao.ibatis.ParametroDAOiBatis;
import pe.com.claro.website.app.domain.Parametro;
import pe.com.claro.website.app.service.ParametroService;

public class ParametroServiceImpl implements ParametroService {

	private static Log log = LogFactory.getLog(ParametroServiceImpl.class);
	
	private ParametroDAO dao;

	@Override
	public List<Parametro> listarTodo(Parametro param) throws Exception {
		List<Parametro> lista = null;
		try {
			lista = new ArrayList<Parametro>();
			lista = getDao().listarTodo(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return lista;
	}

	@Override
	public void registrar(Parametro param) throws Exception {
		try {
			
			if (findBy(param) == null) {
				getDao().registrar(param);
			}else{
				log.info("Parametro ya esta registrado");
				param.setCodigoError(new Integer(-2));
				param.setMensajeError("Parametro ya esta registrado");
			}
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
	}
	
	public Parametro findBy(Parametro parametro) {
		log.info("findBy inicio");
		Parametro domain = null;
		List<Parametro> list=getDao().listarForTipoNumero(parametro);
		log.info("findByNombre domain:"+list.size());
		if (list.size()>0) {
			domain=list.get(0);
		}
		log.info("findBy domain:"+domain);
		log.info("findBy fin");
		return domain;
	}

	@Override
	public void actualizar(Parametro param) throws Exception {
		try {
			getDao().actualizar(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
	}

	@Override
	public void eliminar(Parametro param) throws Exception {
		try {
			getDao().eliminar(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
	}

	@Override
	public Parametro seleccionarPorId(Integer id) throws Exception {
		Parametro parametro = null;
		try {
			parametro = new Parametro();
			parametro = getDao().seleccionarPorId(id);

		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return parametro;
	}
	
	@Override
	public Parametro selectById(Integer id) throws Exception {
		Parametro parametro = null;
		try {
			parametro = new Parametro();
			parametro = getDao().selectById(id);

		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return parametro;
	}
	
	@Override
	public Parametro seleccionarPorNombre(String nombreParametro) throws Exception{
		Parametro parametro = null;
		try{
			parametro = new Parametro();
			if(dao==null){
				dao = new ParametroDAOiBatis();
			}
			parametro = getDao().seleccionarPorNombre(nombreParametro);
		} catch(Exception e){
			throw new AbstractException(Constante.KEY_TIPO_MENSAJE_ERROR + e.getMessage());
		}
		return parametro;
	}

	public List<Parametro> listarCamposPorParam(Integer paramID)
			throws Exception {
		List<Parametro> list = null;
		try {
			list = getDao().listarCamposPorParam(paramID);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}

	public ParametroDAO getDao() {
		return dao;
	}

	public void setDao(ParametroDAO dao) {
		this.dao = dao;
	}

}