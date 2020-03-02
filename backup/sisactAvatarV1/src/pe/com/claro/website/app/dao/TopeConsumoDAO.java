package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.TopeConsumo;
//import pe.com.claro.website.seguridad.domain.Opcion;

public interface TopeConsumoDAO {
	
	public void registrar(TopeConsumo topeConsumo);

	public void update(TopeConsumo topeConsumo);

	public TopeConsumo selectById(Integer id);

	public void eliminar(Integer id);

	public List<TopeConsumo> listarAll(TopeConsumo topeConsumo);
	/* comunes */
	
	public List<TopeConsumo> listarForName(TopeConsumo topeConsumo);
	
	public List<TopeConsumo> listarForTipoNumero(TopeConsumo topeConsumo);
	
	public List<TopeConsumo> listarByTipoPlanId(Integer id);
	
}
