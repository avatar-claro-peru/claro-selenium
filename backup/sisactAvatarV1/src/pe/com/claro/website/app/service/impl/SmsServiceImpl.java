package pe.com.claro.website.app.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.SmsDAO;
import pe.com.claro.website.app.domain.Sms;
import pe.com.claro.website.app.service.SmsService;

public class SmsServiceImpl implements SmsService{

	private static Log log = LogFactory.getLog(SmsServiceImpl.class);
	
	private SmsDAO dao;

	/**
	 * @return
	 */
	protected SmsDAO getDao() {
		return dao;
	}

	/**
	 * @param dao
	 */
	public void setDao(SmsDAO dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#listar(java.lang
	 * .Object)
	 */
	public List<Sms> listarAll(Integer id) throws AbstractException {
		List<Sms> list = null;
		try {
			list = getDao().listarAll(id);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}
	
	public List<Sms> listarByLineaId(Integer id) throws AbstractException {
		List<Sms> list = null;
		try {
			list = getDao().listarByLineaId(id);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_LISTAR_ERROR + e.getMessage());
		}
		return list;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gob.pe.bcrp.LBTRWeb.framework.service.AbstractService#buscarPorId(java
	 * .lang.String)
	 */
	public Sms selectById(Integer id) throws AbstractException {
		Sms domain = null;

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
	public void eliminar(Integer to) throws AbstractException {
		try {
			getDao().eliminar(to);
		} catch (Exception e) {
			throw new AbstractException(Constante.KEY_DELETE_ERROR);
		}

	}

}
