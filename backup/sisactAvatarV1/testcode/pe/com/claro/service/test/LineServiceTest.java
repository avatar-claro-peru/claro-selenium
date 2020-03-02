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
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.LineDAO;
import pe.com.claro.website.app.domain.Line;
import pe.com.claro.website.app.service.impl.LineServiceImpl;

public class LineServiceTest {

	@Mock
	private LineDAO dao;
	
	@InjectMocks
	private LineServiceImpl lineServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void listarAllTest() {
		Line line = new Line();
		line.setId(1);
		List<Line> list = lineServiceImpl.listarAll(1);
		assertNotNull(list);
	}
	
	
	@Test
	public void selectByIdTest() {
		Line line = new Line();
		line.setId(1); 
		when(lineServiceImpl.selectById("1")).thenReturn(line);
		Line line2 = new Line();
		line2 = lineServiceImpl.selectById("1");
		
		assertNotNull(line2);
	}
	
	@Test
	public void encontrarLineaTest() {
		int respuesta = lineServiceImpl.encontrarLinea("1");
		assertNotEquals("no encontrado", 1,respuesta);
	}
	
	
}
