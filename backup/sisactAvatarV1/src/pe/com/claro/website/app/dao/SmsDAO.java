package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Sms;

public interface SmsDAO {

	public Sms selectById(Integer id);

	public void eliminar(Integer id);

	public List<Sms> listarAll(Integer id);

	public List<Sms> listarByLineaId(Integer id);
	
}
