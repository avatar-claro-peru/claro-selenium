package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.SolicitudDAO;
import pe.com.claro.website.app.domain.Solicitud;
import pe.com.claro.website.app.service.impl.SolicitudServiceImpl;

public class SolicitudServiceTest {

	
	@Mock
	private SolicitudDAO dao;
	
	@InjectMocks
	private SolicitudServiceImpl solicitudSAerviceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() throws Exception {
		Solicitud solicitud = new Solicitud();
		solicitud.setDni("45491015");
		List<Solicitud> list = null;
		list = solicitudSAerviceImpl.listarTodo(solicitud);
		assertNotNull(list);
	}
	
}
