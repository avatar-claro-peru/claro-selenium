package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Orden;

public interface OrdenDAO {
	
	public List<Orden> listarTodo(Orden orden);
	
	public List<Orden> listarCamposPorParam(Integer paramID);

	public void registrar(Orden param);

	public void actualizar(Orden param);

	public void eliminar(Orden param);

	public Orden seleccionarPorPedidoId(Integer id);
	
	public Orden selectById(Integer id);
	
	public Orden selectByIdOrdenDetalle(Integer id);
}
