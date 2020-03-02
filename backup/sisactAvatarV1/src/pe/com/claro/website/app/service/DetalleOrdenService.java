package pe.com.claro.website.app.service;

import java.util.List;
import org.acegisecurity.userdetails.UserDetailsService;
import pe.com.claro.website.app.domain.DetalleOrden;

public interface DetalleOrdenService extends  UserDetailsService{
	
	public void registrar(DetalleOrden detalleOrden) throws Exception;
	public List<DetalleOrden> listarAll(Integer id) throws Exception;
}
