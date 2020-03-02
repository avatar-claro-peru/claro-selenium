package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Parametro;

public interface ParametroService  {

	public List<Parametro> listarTodo(Parametro param) throws Exception;
	public List<Parametro> listarCamposPorParam(Integer paramID) throws Exception;
	public void registrar(Parametro param) throws Exception;
	public void actualizar(Parametro param) throws Exception;
	public void eliminar(Parametro param) throws Exception;
	public Parametro selectById(Integer paramID) throws Exception;
	public Parametro seleccionarPorId(Integer paramID) throws Exception;
	public Parametro seleccionarPorNombre(String nombreParametro) throws Exception;
	
}
