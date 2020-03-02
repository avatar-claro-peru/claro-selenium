package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.TopeConsumoDAO;
import pe.com.claro.website.app.domain.TopeConsumo;
import pe.com.claro.website.app.service.impl.TopeConsumoServiceImpl;

public class TopeConsumoServiceTest {

	 @Mock
	 private TopeConsumoDAO dao;
	 
	 @InjectMocks
	 private TopeConsumoServiceImpl topeConsumoServiceImpl;
	 
	 @Before
	 public void setup() {
		 MockitoAnnotations.initMocks(this);
	 }
	
	@Test
	public void listaAllTest() {
		TopeConsumo tope = new TopeConsumo();
		List<TopeConsumo> list = null;
		list = topeConsumoServiceImpl.listarAll(tope);
		assertNotNull(list);
	}
		
}
