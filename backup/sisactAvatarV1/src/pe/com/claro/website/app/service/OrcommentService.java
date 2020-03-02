package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Orcomment;

public interface OrcommentService {

	public List<Orcomment> findByField(String field);

}
