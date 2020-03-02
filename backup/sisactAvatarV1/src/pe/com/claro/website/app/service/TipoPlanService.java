package pe.com.claro.website.app.service;

import java.util.List;

import org.acegisecurity.userdetails.UserDetailsService;

import pe.com.claro.website.app.domain.TipoPlan;

public interface TipoPlanService extends  UserDetailsService{
	
	/* comunes */
	public void registrar(TipoPlan tipoPlan) throws Exception;

	public void actualizar(TipoPlan tipoPlan) throws Exception;

	public void eliminar(Integer tipoPlan) throws Exception;

	public void eliminarArray(int[] ids) throws Exception;

	public List<TipoPlan> listarAll(TipoPlan tipoPlan) throws Exception;

	public TipoPlan selectById(Integer id) throws Exception;
	
}
