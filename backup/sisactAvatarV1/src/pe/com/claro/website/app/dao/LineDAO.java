package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Line;


public interface LineDAO {
	
	public void registrar(Line line);

	public void update(Line line);

	public Line selectById(String id);

	public void eliminar(String id);

	public List<Line> listarAll(Integer id);
	/* comunes */
	
	public List<Line> listarForName(Line line);

	public Line listarForNombre(Line line);
	/* lsoto: 29:06:19: Creamos la función para validar si existe la línea ingresada: INICIO*/
	public int encontrarLinea(String numeroLinea);
	/* lsoto: 29:06:19: Creamos la función para validar si existe la línea ingresada: FIN*/
}
