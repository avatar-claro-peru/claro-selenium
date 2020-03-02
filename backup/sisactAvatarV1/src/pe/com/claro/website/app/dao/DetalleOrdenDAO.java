package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.DetalleOrden;

public interface DetalleOrdenDAO {
	
	public void registrar(DetalleOrden detalleOrden);
	public List<DetalleOrden> selectDetalleOrdenxIDOrden(Integer id);
}