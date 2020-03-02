package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Evaluacion;

public interface EvaluacionService  {

	public List<Evaluacion> listarTodo(Evaluacion param) throws Exception;
	public List<Evaluacion> listarCamposPorParam(Integer paramID) throws Exception;
	public void registrar(Evaluacion param) throws Exception;
	public void actualizar(Evaluacion param) throws Exception;
	public void eliminar(Evaluacion param) throws Exception;
	public Evaluacion selectById(Integer paramID) throws Exception;
	public Evaluacion seleccionarPorId(Integer paramID) throws Exception;
	
}
