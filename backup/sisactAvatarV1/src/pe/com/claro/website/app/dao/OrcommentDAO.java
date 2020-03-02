package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Orcomment;

public interface OrcommentDAO {

	public List<Orcomment> findByField(String field);
}
