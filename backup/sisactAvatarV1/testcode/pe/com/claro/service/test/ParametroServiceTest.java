package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.ParametroDAO;
import pe.com.claro.website.app.domain.Parametro;
import pe.com.claro.website.app.service.impl.ParametroServiceImpl;

public class ParametroServiceTest {

	
	
	@Mock
	private ParametroDAO dao;
	
	@InjectMocks
	private ParametroServiceImpl parametroServiceImpl;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void listarTodoTest() throws Exception {
		Parametro parametro = new Parametro();
		parametro.setId(1);
		List<Parametro> list = parametroServiceImpl.listarTodo(parametro);
		assertNotNull(list);
	}
	
}