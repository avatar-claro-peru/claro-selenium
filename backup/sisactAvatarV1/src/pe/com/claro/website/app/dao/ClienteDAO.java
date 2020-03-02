package pe.com.claro.website.app.dao;

import java.util.List;

import pe.com.claro.website.app.domain.Cliente;

public interface ClienteDAO {
	
	public void registrar(Cliente Usuario);

	public void update(Cliente Usuario);

	public Cliente selectById(Integer id);

	public void eliminar(Integer id);

	public List<Cliente> listarAll(Cliente cliente);
	/* comunes */
	
	public List<Cliente> listarForName(Cliente cliente);
	
	public List<Cliente> listarForTipoNumero(Cliente cliente);

}
