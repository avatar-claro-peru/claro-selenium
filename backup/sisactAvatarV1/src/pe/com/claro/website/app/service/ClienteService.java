package pe.com.claro.website.app.service;

import java.util.List;

import org.acegisecurity.userdetails.UserDetailsService;

import pe.com.claro.website.app.domain.Cliente;

public interface ClienteService extends  UserDetailsService{
	
	/* comunes */
	public void registrar(Cliente cliente) throws Exception;

	public void actualizar(Cliente cliente) throws Exception;

	public void eliminar(Integer cliente) throws Exception;

	public void eliminarArray(int[] ids) throws Exception;

	public List<Cliente> listarAll(Cliente cliente) throws Exception;

	public Cliente selectById(Integer id) throws Exception;
	
//	/* comunes */
//	
//	public Cliente findByNombre(Cliente cliente);

}
