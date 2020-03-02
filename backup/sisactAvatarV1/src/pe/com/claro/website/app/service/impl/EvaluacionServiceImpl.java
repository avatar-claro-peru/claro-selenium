package pe.com.claro.website.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.EvaluacionDAO;
import pe.com.claro.website.app.dao.OrcommentDAO;
import pe.com.claro.website.app.domain.Evaluacion;
import pe.com.claro.website.app.domain.Orcomment;
import pe.com.claro.website.app.service.EvaluacionService;
import pe.com.claro.website.app.service.OrcommentService;

public class EvaluacionServiceImpl implements EvaluacionService, OrcommentService {

	private EvaluacionDAO dao;
	
	private OrcommentDAO daoOrcomment;
		
	@Override
	public List<Evaluacion> listarTodo(Evaluacion param) throws Exception {
		List<Evaluacion> lista = null;
		try {
			lista = new ArrayList<Evaluacion>();
			lista = getDao().listarTodo(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return lista;
	}

	@Override
	public void registrar(Evaluacion param) throws Exception {
		try {
			getDao().registrar(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
	}

	@Override
	public void actualizar(Evaluacion param) throws Exception {
		try {
			getDao().actualizar(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
	}

	@Override
	public void eliminar(Evaluacion param) throws Exception {
		try {
			getDao().eliminar(param);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
	}

	@Override
	public Evaluacion seleccionarPorId(Integer id) throws Exception {
		Evaluacion parametro = null;
		List<Orcomment> lstParametroOrcomment = new ArrayList<Orcomment>();
		try {
			parametro = new Evaluacion();
			parametro = getDao().selectById(id);
			lstParametroOrcomment = findByField(parametro.getOrdenId());

			if (lstParametroOrcomment != null && !lstParametroOrcomment.isEmpty()) {
				for (Orcomment orcomment : lstParametroOrcomment) {
					if (orcomment.getKeyComment().equalsIgnoreCase("NombreTopeConsumo")) {
						parametro.setDescripcionTopeConsumo(orcomment.getValueComment());
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return parametro;
	}
	
	@Override
	public Evaluacion selectById(Integer id) throws Exception {
		Evaluacion parametro = null;
		List<Orcomment> lstParametroOrcomment = new ArrayList<Orcomment>();
		try {
			parametro = new Evaluacion();
			parametro = getDao().selectById(id);
			lstParametroOrcomment = findByField(parametro.getOrdenId());

			if (lstParametroOrcomment != null && !lstParametroOrcomment.isEmpty()) {
				for (Orcomment orcomment : lstParametroOrcomment) {
					if (orcomment.getKeyComment().equalsIgnoreCase("NombreTopeConsumo")) {
						parametro.setDescripcionTopeConsumo(orcomment.getValueComment());
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return parametro;
	}

	public List<Evaluacion> listarCamposPorParam(Integer paramID)
			throws Exception {
		List<Evaluacion> list = null;
		try {
			list = getDao().listarCamposPorParam(paramID);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}

	public EvaluacionDAO getDao() {
		return dao;
	}

	public void setDao(EvaluacionDAO dao) {
		this.dao = dao;
	}

	public OrcommentDAO getDaoOrcomment() {
		return daoOrcomment;
	}

	public void setDaoOrcomment(OrcommentDAO daoOrcomment) {
		this.daoOrcomment = daoOrcomment;
	}

	@Override
	public List<Orcomment> findByField(String field) {
		return daoOrcomment.findByField(field);
	}
	
	
}