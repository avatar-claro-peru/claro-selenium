package pe.com.claro.website.app.dao;
import pe.com.claro.website.app.domain.TipoPlanxTopeConsumo;

public interface TipoPlanxTopeConsumoDAO {
	
	public void registrarTipoPlanxTopeConsumo(TipoPlanxTopeConsumo to);
	
	public void eliminarByTopeConsumoId(Integer id);
}