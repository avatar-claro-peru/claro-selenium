package pe.com.claro.website.app.service.impl;

import java.util.List;

import pe.com.claro.website.app.dao.OrcommentDAO;
import pe.com.claro.website.app.domain.Orcomment;
import pe.com.claro.website.app.service.OrcommentService;

public class OrcommentServiceImpl implements OrcommentService {

	private OrcommentDAO dao;

	public OrcommentDAO getDao() {
		return dao;
	}

	public void setdao(OrcommentDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Orcomment> findByField(String field) {
		return dao.findByField(field);
	}

}