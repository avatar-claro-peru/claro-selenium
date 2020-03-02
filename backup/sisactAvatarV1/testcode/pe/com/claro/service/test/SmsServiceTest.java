package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.app.dao.SmsDAO;
import pe.com.claro.website.app.domain.Sms;
import pe.com.claro.website.app.service.impl.SmsServiceImpl;

public class SmsServiceTest {

	@Mock
	private SmsDAO dao;
	
	@InjectMocks
	private SmsServiceImpl smsServiceImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listarAllTest() {
		List<Sms> list = null;
		list = smsServiceImpl.listarAll(1);
		assertNotNull(list);
	}
}
