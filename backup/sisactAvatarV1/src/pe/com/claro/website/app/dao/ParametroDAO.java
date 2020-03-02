package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Parametro;

public interface ParametroDAO {

	public List<Parametro> listarTodo(Parametro param);
	
	public List<Parametro> listarCamposPorParam(Integer paramID);

	public void registrar(Parametro param);

	public void actualizar(Parametro param);

	public void eliminar(Parametro param);

	public Parametro seleccionarPorId(Integer id);
	
	public Parametro selectById(Integer id);

	public List<Parametro> listarForTipoNumero(Parametro parametro);
	
	public Parametro seleccionarPorNombre(String nombre);
}
