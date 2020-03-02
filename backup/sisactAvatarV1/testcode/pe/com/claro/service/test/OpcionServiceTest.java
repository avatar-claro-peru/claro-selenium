package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.seguridad.dao.OpcionDAO;
import pe.com.claro.website.seguridad.domain.Opcion;
import pe.com.claro.website.seguridad.service.impl.OpcionServiceImpl;

public class OpcionServiceTest {

	
	@Mock
	private OpcionDAO dao;
	
	@InjectMocks
	private OpcionServiceImpl opcionServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
		
	@Test
	public void listarAllTest() {
		Opcion opcion = new Opcion();
		opcion.setId(1);
		List<Opcion> list = opcionServiceImpl.listarAll(opcion);
		assertNotNull(list);
	}
	
	@Test
	public void selectByIdTest() {
		Opcion opcion = new Opcion();
		opcion.setNombre("Rodrigo");
		when(opcionServiceImpl.selectById(11)).thenReturn(opcion);
		Opcion opcion1 = opcionServiceImpl.selectById(11);
		assertNotNull(opcion1);
	}
	
}
