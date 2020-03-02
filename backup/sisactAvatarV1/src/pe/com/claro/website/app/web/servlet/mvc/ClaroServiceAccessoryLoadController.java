
package pe.com.claro.website.app.web.servlet.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusAccessoryType;
import pe.com.claro.website.app.domain.service.MostrarExecuteAccessoryProcessType;
import pe.com.claro.website.app.domain.service.MostrarExecuteStockProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusAccessoryType;
import pe.com.claro.website.app.domain.service.ObtenerExecuteAccessoryProcessType;
import pe.com.claro.website.app.service.ClaroServiceAccessoryLoadService;

/**
 * The Class ClaroServiceAccessoryLoadController.
 * 
 * @author Elmer Terrones Fernandez
 * @company AVATAR
 * @since 21/12/2017
 * @project Platform Migration - E-Commerce Platform for Claro
 */
public class ClaroServiceAccessoryLoadController extends MultiActionController {
	
	private static Log LOGGER = LogFactory.getLog(ClaroServiceAccessoryLoadController.class);

	private String commandName;

	public static final String LISTA = "lista";

	private String claroServiceAccessoryLoadView;
	
	private String checkProcessAccessoryStatusSuccessfullView;

	private String executeAccessoryProcessSuccessfullView;

	private String executeAccessoryProcessErrorView;

	private String checkProcessAccessoryStatusErrorView;

	private ClaroServiceAccessoryLoadService service;

	protected ClaroServiceAccessoryLoadController() {
		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		setMethodNameResolver(resolver);
	}

	public ModelAndView claroServiceAccessoryLoadView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = getAdicionalModelCrear();
		return new ModelAndView(getClaroServiceAccessoryLoadView(), model);
	}

	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}
	
	public ModelAndView doCheckProcessStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info("doCheckProcessStatus: inicio");
		
		Map<String, Object> modelError = null;
		
		try {
			
			ObtenerCheckProcessStatusAccessoryType command = getCommand(request);
			MostrarCheckProcessStatusAccessoryType salida = new MostrarCheckProcessStatusAccessoryType();
			
			modelError = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			model.putAll(getModel(command));
			model.putAll(getAdicionalModelCrear());
			salida = getService().checkProcessStatusService(command);
			
			if( salida != null ){
				
				List<MostrarCheckProcessStatusAccessoryType> lista = new ArrayList<MostrarCheckProcessStatusAccessoryType>();
				MostrarCheckProcessStatusAccessoryType objeto = new MostrarCheckProcessStatusAccessoryType();

				objeto.setCodeReply(salida.getCodeReply());
				objeto.setIdEvent(salida.getIdEvent());
				objeto.setMessageReply(salida.getMessageReply());
				lista.add(objeto);
				model.put(LISTA, lista);
				
			}
			
			return new ModelAndView(getCheckProcessAccessoryStatusSuccessfullView(), model);
			
		} catch (Exception e) {
			
			modelError = new HashMap<String, Object>();
			modelError.put("errorConexion", Constante.ERROR_CONEXION);
			
			return new ModelAndView(getCheckProcessAccessoryStatusErrorView(), modelError);
		}	
		
	}
	
	public ModelAndView doExecuteAccessoryProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info("doExecuteAccessoryProcess: inicio");
		
		Map<String, Object> modelError = null;
		
		try {
			
			ObtenerExecuteAccessoryProcessType command = getCommandExecuteAccessoryProcess(request);
			MostrarExecuteAccessoryProcessType salida = new MostrarExecuteAccessoryProcessType();
			
			modelError = getModelMensajesObtenerExecuteAccessoryProcessType(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			Map<String, Object> model = getModelMensajesObtenerExecuteAccessoryProcessType(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			model.putAll(getModelExecuteAccessoryProcessType(command));
			model.putAll(getAdicionalModelCrear());
			salida = getService().executeAccessoryProcessService(command);
			LOGGER.debug("Salida: " + salida);
			if (salida != null) {

				List<MostrarExecuteStockProcessType> lista = new ArrayList<MostrarExecuteStockProcessType>();
				MostrarExecuteStockProcessType objeto = new MostrarExecuteStockProcessType();

				objeto.setCodeReply(salida.getCodeReply());
				objeto.setIdEvent(salida.getIdEvent());
				objeto.setMessageReply(salida.getMessageReply());
				lista.add(objeto);
				model.put(LISTA, lista);
			}
			
			LOGGER.info("doExecuteAccessoryProcess: fin");
			
			return new ModelAndView(getExecuteAccessoryProcessSuccessfullView(), model);
			
		} catch (Exception e) {
			
			modelError = new HashMap<String, Object>();
			modelError.put("errorConexion", Constante.ERROR_CONEXION);
			
			return new ModelAndView(getCheckProcessAccessoryStatusErrorView(), modelError);
		}		
		
	}
	
	protected Map<String, Object> getModelMensajesObtenerExecuteAccessoryProcessType(ObtenerExecuteAccessoryProcessType command, String mensajeError, String mensajeExito) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErroresObtenerExecuteAccessoryProcessType(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		} else {
			model.put(Constante.KEY_TIPO_MENSAJE_EXITO, mensajeExito);
		}
		return model;
	}
	
	protected boolean tieneErroresObtenerExecuteAccessoryProcessType(ObtenerExecuteAccessoryProcessType command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
	}
	
	protected ObtenerExecuteAccessoryProcessType getCommandExecuteAccessoryProcess(HttpServletRequest request) throws Exception {
		ObtenerExecuteAccessoryProcessType command = getCommandInstanceExecuteAccessoryProcessType();
		bind(request, command);
		return command;
	}

	protected ObtenerCheckProcessStatusAccessoryType getCommand(HttpServletRequest request) throws Exception {
		ObtenerCheckProcessStatusAccessoryType command = getCommandInstance();
		bind(request, command);
		return command;
	}

	protected String getMensajeRegistrarError() {
		return Constante.ERROR_PROCESS_LOAD_STOK_PRECIOS;
	}

	protected String getMensajeRegistrarSatisfactorio() {
		return Constante.SUCCESSFULL_PROCESS_LOAD_STOK_PRECIOS;
	}

	protected Map<String, Object> getModelMensajes(ObtenerCheckProcessStatusAccessoryType command, String mensajeError, String mensajeExito) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErrores(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		} else {
			model.put(Constante.KEY_TIPO_MENSAJE_EXITO, mensajeExito);
		}
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> getModel(ObtenerExecuteAccessoryProcessType command) { 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	protected boolean tieneErrores(ObtenerCheckProcessStatusAccessoryType command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
	}

	protected Map<String, Object> getModel(ObtenerCheckProcessStatusAccessoryType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	protected Map<String, Object> getModelExecuteAccessoryProcessType(ObtenerExecuteAccessoryProcessType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/* fin proceso ExecuteAccessoryProcessType */

	@SuppressWarnings("unchecked")
	protected ObtenerCheckProcessStatusAccessoryType getCommandInstance() throws Exception {
		ObtenerCheckProcessStatusAccessoryType command = new ObtenerCheckProcessStatusAccessoryType();
		return command;
	}

	@SuppressWarnings("unchecked")
	protected ObtenerExecuteAccessoryProcessType getCommandInstanceExecuteAccessoryProcessType() throws Exception {
		ObtenerExecuteAccessoryProcessType command = new ObtenerExecuteAccessoryProcessType();
		return command;
	}
	
	/* METHODS GETS AND SETTERS */

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getClaroServiceAccessoryLoadView() {
		return claroServiceAccessoryLoadView;
	}

	public void setClaroServiceAccessoryLoadView(String claroServiceAccessoryLoadView) {
		this.claroServiceAccessoryLoadView = claroServiceAccessoryLoadView;
	}

	public String getExecuteAccessoryProcessSuccessfullView() {
		return executeAccessoryProcessSuccessfullView;
	}

	public void setExecuteAccessoryProcessSuccessfullView(String executeAccessoryProcessSuccessfullView) {
		this.executeAccessoryProcessSuccessfullView = executeAccessoryProcessSuccessfullView;
	}

	public String getExecuteAccessoryProcessErrorView() {
		return executeAccessoryProcessErrorView;
	}

	public void setExecuteAccessoryProcessErrorView(String executeAccessoryProcessErrorView) {
		this.executeAccessoryProcessErrorView = executeAccessoryProcessErrorView;
	}

	public ClaroServiceAccessoryLoadService getService() {
		return service;
	}

	public void setService(ClaroServiceAccessoryLoadService service) {
		this.service = service;
	}

	public String getCheckProcessAccessoryStatusSuccessfullView() {
		return checkProcessAccessoryStatusSuccessfullView;
	}

	public void setCheckProcessAccessoryStatusSuccessfullView(String checkProcessAccessoryStatusSuccessfullView) {
		this.checkProcessAccessoryStatusSuccessfullView = checkProcessAccessoryStatusSuccessfullView;
	}

	public String getCheckProcessAccessoryStatusErrorView() {
		return checkProcessAccessoryStatusErrorView;
	}

	public void setCheckProcessAccessoryStatusErrorView(String checkProcessAccessoryStatusErrorView) {
		this.checkProcessAccessoryStatusErrorView = checkProcessAccessoryStatusErrorView;
	}
	
}
