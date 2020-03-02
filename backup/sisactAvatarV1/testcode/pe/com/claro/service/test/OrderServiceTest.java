package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.OrcommentDAO;
import pe.com.claro.website.app.dao.OrdenDAO;
import pe.com.claro.website.app.domain.Orden;
import pe.com.claro.website.app.service.impl.OrdenesServiceImpl;

public class OrderServiceTest {

	
	@Mock
	private OrdenDAO dao;
	
	@Mock
	private OrcommentDAO daoOrcomment;
	
	
	@InjectMocks
	private OrdenesServiceImpl orderServiceIpml;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void listarTodosTest() throws Exception {
		Orden orden = new Orden();
		orden.setId(1);
		List<Orden> list = orderServiceIpml.listarTodo(orden);
		assertNotNull(list);
	}

}
