package pe.com.claro.website.app.service;

import java.util.List;

import pe.com.claro.website.app.domain.Orden;

public interface OrdenesService {
	
	public List<Orden> listarTodo(Orden orden) throws Exception;
	public Orden seleccionarPorPedidoId(Integer id) throws Exception;
	public void actualizar(Orden orden) throws Exception;
	public Orden seleccionarPorId(Integer id) throws Exception;
    public Orden selectByIdOrdenDetalle(Integer id) throws Exception;
	
}
