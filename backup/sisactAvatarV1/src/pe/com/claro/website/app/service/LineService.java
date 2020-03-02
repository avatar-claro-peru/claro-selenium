package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Line;

public interface LineService {
	
	public void registrar(Line line) throws Exception;

	public void actualizar(Line line) throws Exception;

	public void eliminar(String line) throws Exception;

//	public void eliminarArray(int[] ids) throws Exception;

	public List<Line> listarAll(Integer id) throws Exception;

	public Line selectById(String id) throws Exception;

}
