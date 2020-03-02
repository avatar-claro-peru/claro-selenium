package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.TipoPlan;

public interface TipoPlanDAO {
	
	public void registrar(TipoPlan tipoPLan);

	public void update(TipoPlan tipoPLan);

	public TipoPlan selectById(Integer id);

	public void eliminar(Integer id);

	public List<TipoPlan> listarAll(TipoPlan tipoPLan);
	/* comunes */
	
	public List<TipoPlan> listarForName(TipoPlan tipoPLan);
	
	public List<TipoPlan> listarForTipoNumero(TipoPlan tipoPLan);
	
	public List<TipoPlan> listarByTopeConsumoID(Integer id);
}
