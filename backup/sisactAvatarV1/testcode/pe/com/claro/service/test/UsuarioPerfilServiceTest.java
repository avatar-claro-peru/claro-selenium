package pe.com.claro.service.test;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.seguridad.dao.UsuarioPerfilDAO;
import pe.com.claro.website.seguridad.service.impl.UsuarioPerfilServiceImpl;

public class UsuarioPerfilServiceTest {

	
	@Mock
	private UsuarioPerfilDAO dao;
	
	@InjectMocks
    private UsuarioPerfilServiceImpl usuarioPerfilServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void registrarUsuarioPerfilTest() {
		int[] perfiles = {1,2};
		usuarioPerfilServiceImpl.registrarUsuarioPerfil(1,perfiles);
	}

}
