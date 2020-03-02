package pe.com.claro.website.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.OrcommentDAO;
import pe.com.claro.website.app.dao.OrdenDAO;
import pe.com.claro.website.app.domain.Orcomment;
import pe.com.claro.website.app.domain.Orden;
import pe.com.claro.website.app.service.OrcommentService;
import pe.com.claro.website.app.service.OrdenesService;

public class OrdenesServiceImpl implements OrdenesService, OrcommentService {
	
	private OrdenDAO dao;
	
	private OrcommentDAO daoOrcomment;

	@Override
	public List<Orden> listarTodo(Orden orden) throws Exception {
		List<Orden> lista = null;
		try {
			lista = new ArrayList<Orden>();
			lista = getDao().listarTodo(orden);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return lista;
	}
	
	@Override
	public Orden seleccionarPorPedidoId(Integer id) throws Exception {
		Orden parametro = null;
		List<Orcomment> lstParametroOrcomment = new ArrayList<Orcomment>();
		try {
			parametro = new Orden();
			parametro = getDao().seleccionarPorPedidoId(id);
			
			lstParametroOrcomment = findByField(parametro.getIdPedido());

			if (lstParametroOrcomment != null && !lstParametroOrcomment.isEmpty()) {
				for (Orcomment orcomment : lstParametroOrcomment) {
					if (orcomment.getKeyComment().equalsIgnoreCase("CodigoTopeConsumo")) {
						parametro.setCodigoTopeConsumo(orcomment.getValueComment());
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
	public Orden selectByIdOrdenDetalle(Integer id) throws Exception {
		Orden orden = null;
		
		orden = getDao().selectByIdOrdenDetalle(id);
		
		return orden;
	}
	
	@Override
	public Orden seleccionarPorId(Integer id) throws Exception{
		Orden orden = null;
		List<Orcomment> lstParametroOrcomment = new ArrayList<Orcomment>();
		try{
			orden = new Orden();
			orden = getDao().selectById(id);
			
			lstParametroOrcomment = findByField(orden.getIdPedido());

			if (lstParametroOrcomment != null && !lstParametroOrcomment.isEmpty()) {
				for (Orcomment orcomment : lstParametroOrcomment) {
					if (orcomment.getKeyComment().equalsIgnoreCase("CodigoTopeConsumo")) {
						orden.setCodigoTopeConsumo(orcomment.getValueComment());
						break;
					}
				}
			}

			
		}catch(Exception e){
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
		return orden;
	}

	public OrdenDAO getDao() {
		return dao;
	}

	public void setDao(OrdenDAO dao) {
		this.dao = dao;
	}

	@Override
	public void actualizar(Orden orden) throws Exception {
		// TODO Auto-generated method stub
		try {
			getDao().actualizar(orden);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
		}
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
