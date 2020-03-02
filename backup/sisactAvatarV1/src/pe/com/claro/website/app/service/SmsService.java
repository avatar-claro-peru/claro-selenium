package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Sms;

public interface SmsService {
	
//	public void registrar(Line line) throws Exception;
//
//	public void actualizar(Line line) throws Exception;
	
	public void eliminar(Integer sms) throws Exception;

	public List<Sms> listarAll(Integer id) throws Exception;
	
	public List<Sms> listarByLineaId(Integer id) throws Exception;

	public Sms selectById(Integer id) throws Exception;

}
