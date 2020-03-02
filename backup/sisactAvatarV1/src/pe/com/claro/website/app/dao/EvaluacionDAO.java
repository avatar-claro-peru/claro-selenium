package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Evaluacion;

public interface EvaluacionDAO {

	public List<Evaluacion> listarTodo(Evaluacion param);
	
	public List<Evaluacion> listarCamposPorParam(Integer paramID);

	public void registrar(Evaluacion param);

	public void actualizar(Evaluacion param);

	public void eliminar(Evaluacion param);

	public Evaluacion seleccionarPorId(Integer id);
	
	public Evaluacion selectById(Integer id);
}
