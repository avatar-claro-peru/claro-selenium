package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.seguridad.dao.PerfilDAO;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.service.impl.PerfilServiceImpl;

public class PerfilServiceTest {
	
	@Mock
	private PerfilDAO dao;
	
	@InjectMocks
    private PerfilServiceImpl perfilServiceImpl;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	public void listarAllTest() {
		Perfil perfil  = new Perfil();
		perfil.setId(1);
		List<Perfil> list = perfilServiceImpl.listarAll(perfil);
		assertNotNull(list);
	}
}
