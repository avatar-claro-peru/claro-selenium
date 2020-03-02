package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.TipoPlanDAO;
import pe.com.claro.website.app.domain.TipoPlan;
import pe.com.claro.website.app.service.impl.TipoPlanServiceImpl;

public class TipoPlanServiceTest {

	
	@Mock
	private TipoPlanDAO dao;
	
	@InjectMocks
	private TipoPlanServiceImpl tipoPlanServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listarAllTest() {
		TipoPlan tipoPlan = new TipoPlan();
		tipoPlan.setId(1);
		List <TipoPlan> list = null;
		
		list = tipoPlanServiceImpl.listarAll(tipoPlan);
		assertNotNull(list);
	}

}
