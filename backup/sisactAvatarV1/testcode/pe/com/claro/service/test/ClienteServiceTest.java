package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.ClienteDAO;
import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.app.service.impl.ClienteServiceImpl;

public class ClienteServiceTest {

	@Mock
	private ClienteDAO dao;
	
	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;
	
	@Before
	public void setup() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listarAllTest() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		List<Cliente> list = clienteServiceImpl.listarAll(cliente);
		assertNotNull(list);
	}
	
	@Test
	public void selectByIdTest() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Rodrigo");
		when(clienteServiceImpl.selectById(11)).thenReturn(cliente);
		Cliente cliente1 = clienteServiceImpl.selectById(11);
		assertNotNull(cliente1);
	}
	
//	@Test
//	public void findByTipoNumeroTest() {
//		Cliente cliente = new Cliente();
//		cliente.setNombre("Rodrigo");
//		Cliente cliente2 = new Cliente();
//		cliente2.setNombre("Rodrigo2");		
//		when(clienteServiceImpl.findByTipoNumero(cliente)).thenReturn(cliente2);
//		when(clienteServiceImpl.getDao().listarForTipoNumero(cliente2)).thenReturn(Arrays.asList(cliente2));
//		
//		Cliente cliente1 = clienteServiceImpl.findByTipoNumero(cliente);
//		assertNotNull(cliente1);
//	}
}
