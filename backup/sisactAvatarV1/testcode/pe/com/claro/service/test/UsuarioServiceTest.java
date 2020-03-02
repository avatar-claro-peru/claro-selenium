package pe.com.claro.service.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.seguridad.dao.UsuarioDAO;
import pe.com.claro.website.seguridad.domain.Usuario;
import pe.com.claro.website.seguridad.service.impl.UsuarioServiceImpl;

public class UsuarioServiceTest {
	
	@Mock
	private UsuarioDAO dao;
	
	@InjectMocks
    private UsuarioServiceImpl userService;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = AbstractException.class)
	public void lanzarAbstractException() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		when(userService.listarAll(usuario)).thenThrow(new AbstractException("error de prueba"));
		userService.listarAll(usuario);
		//assertTrue(true);
	}
	
	@Test
	public void actualizarTest() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setPassword("password");
		//when(usuario.get()).thenReturn(1111);
		userService.actualizar(usuario);
		//assertNotNull(usuario.ge);
		assertNotEquals("password", "1111", usuario.getPassword());
	}
	
	@Test
	public void listarAllTest() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		List<Usuario> list = userService.listarAll(usuario);
		assertNotNull(list);
	}
	
	@Test
	public void selectByIdTest() {
		Usuario usuario1 = new Usuario();
		usuario1.setUsername("Rodrigo");
		when(userService.selectById(11)).thenReturn(usuario1);
		Usuario usuario = userService.selectById(11);
		assertNotNull(usuario);
	}

}
