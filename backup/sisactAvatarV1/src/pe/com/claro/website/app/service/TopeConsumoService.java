package pe.com.claro.website.app.service;

import java.util.List;

import org.acegisecurity.userdetails.UserDetailsService;

import pe.com.claro.website.app.domain.TipoPlan;
import pe.com.claro.website.app.domain.TopeConsumo;
//import pe.com.claro.website.seguridad.domain.Opcion;
//import pe.com.claro.website.seguridad.domain.Perfil;

public interface TopeConsumoService extends  UserDetailsService{
	
	/* comunes */
	public void registrar(TopeConsumo topeConsumo) throws Exception;

	public void actualizar(TopeConsumo topeConsumo) throws Exception;

	public void eliminar(Integer topeConsumo) throws Exception;

	public void eliminarArray(int[] ids) throws Exception;

	public List<TopeConsumo> listarAll(TopeConsumo topeConsumo) throws Exception;

	public TopeConsumo selectById(Integer id) throws Exception;
	
	public List<TopeConsumo> listarTopesConsumoByTipoPlan(TipoPlan tipoPlan);
}
