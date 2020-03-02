package pe.com.claro.service.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pe.com.claro.website.admin.exception.AbstractException;
import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.dao.EvaluacionDAO;
import pe.com.claro.website.app.dao.OrcommentDAO;
import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.app.domain.Evaluacion;
import pe.com.claro.website.app.domain.Orcomment;
import pe.com.claro.website.app.service.impl.EvaluacionServiceImpl;

public class EvaluacionServiceTest {
	
	@Mock
	private EvaluacionDAO dao;
	
	@Mock
	private OrcommentDAO daoOrcomment;
	
	@InjectMocks
	private EvaluacionServiceImpl evaluacionServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listarAllTest() throws Exception {
		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setId(1);
		List<Evaluacion> list = evaluacionServiceImpl.listarTodo(evaluacion);
		assertNotNull(list);
	}
	
	@Test
	public void listarCamposPorParamTest() throws Exception {
		List<Evaluacion> list = null;
		list = evaluacionServiceImpl.listarCamposPorParam(1);
		assertNotNull(list);
	}
	
	
	
//	@Test
//	public void selectByIdTest() throws Exception {
//		//Cliente cliente = new Cliente();
//		//cliente.setNombre("Rodrigo");
//		//when(clienteServiceImpl.selectById(11)).thenReturn(cliente);
//		Evaluacion evaluacion = evaluacionServiceImpl.selectById(11);
//		assertNotNull(evaluacion);
//	}
	
//	@Override
//	public Evaluacion selectById(Integer id) throws Exception {
//		Evaluacion parametro = null;
//		List<Orcomment> lstParametroOrcomment = new ArrayList<Orcomment>();
//		try {
//			parametro = new Evaluacion();
//			parametro = getDao().selectById(id);
//			lstParametroOrcomment = findByField(parametro.getOrdenId());
//
//			if (lstParametroOrcomment != null && !lstParametroOrcomment.isEmpty()) {
//				for (Orcomment orcomment : lstParametroOrcomment) {
//					if (orcomment.getKeyComment().equalsIgnoreCase("NombreTopeConsumo")) {
//						parametro.setDescripcionTopeConsumo(orcomment.getValueComment());
//						break;
//					}
//				}
//			}
//		} catch (Exception e) {
//			throw new AbstractException(Constante.KEY_UPDATE_ERROR + e.getMessage());
//		}
//		return parametro;
//	}
}
