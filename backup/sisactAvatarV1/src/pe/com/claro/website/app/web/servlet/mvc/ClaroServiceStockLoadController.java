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
import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusStockType;
import pe.com.claro.website.app.domain.service.MostrarExecuteStockProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusStockType;
import pe.com.claro.website.app.domain.service.ObtenerExecuteStockProcessType;
import pe.com.claro.website.app.service.ClaroServiceStockLoadService;

/**
 * @author Alfredo Rojas Cabezas
 * 
 */
public class ClaroServiceStockLoadController extends MultiActionController {

	private static Log log = LogFactory.getLog(ClaroServiceStockLoadController.class);

	private String commandName;

	public static final String LISTA = "lista";

	private String claroServiceStockLoadView;

	private String checkProcessStockStatusSuccessfullView;

	private String executeStockProcessSuccessfullView;

	private String executeStockProcessErrorView; 

	private String checkProcessStockStatusErrorView;

	private ClaroServiceStockLoadService service;

	protected ClaroServiceStockLoadController() {
		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		setMethodNameResolver(resolver);
	}

	public ModelAndView claroServiceStockLoadView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = getAdicionalModelCrear();
		return new ModelAndView(getClaroServiceStockLoadView(), model);
	}

	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}

	/* Metodo doCheckProcessStatus */
	public ModelAndView doCheckProcessStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ingreso al metodo doCheckProcessStatus inicio");
		Map<String, Object> modelError = new HashMap<String, Object>();

		try {
			ObtenerCheckProcessStatusStockType command = getCommand(request);
			MostrarCheckProcessStatusStockType salida = new MostrarCheckProcessStatusStockType();
			// process
			modelError = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			model.putAll(getModel(command));
			model.putAll(getAdicionalModelCrear());
			salida = getService().checkProcessStatusService(command);

			if (salida != null) {

				List<MostrarCheckProcessStatusStockType> lista = new ArrayList<MostrarCheckProcessStatusStockType>();
				MostrarCheckProcessStatusStockType objeto = new MostrarCheckProcessStatusStockType();

				objeto.setCodeReply(salida.getCodeReply());
				objeto.setIdEvent(salida.getIdEvent());
				objeto.setMessageReply(salida.getMessageReply());
				lista.add(objeto);
				model.put(LISTA, lista);
			}
			log.info("ingreso al metodo doCheckProcessStatus fin");
			return new ModelAndView(getCheckProcessStockStatusSuccessfullView(), model);

		} catch (Exception e) {
			log.info("exception:"+e.getMessage());
			modelError.put("errorConexion", Constante.ERROR_CONEXION);
			log.info("ingreso al metodo doCheckProcessStatus fin");
			return new ModelAndView(getCheckProcessStockStatusErrorView(), modelError);
		}
		
	}

	/* Metodo doExecutePriceProcess */
	public ModelAndView doExecuteStockProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("ingreso al metodo doExecuteStockProcess inicio");
		Map<String, Object> modelError = new HashMap<String, Object>();

		try {

			ObtenerExecuteStockProcessType command = getCommandExecuteStockProcess(request);
			MostrarExecuteStockProcessType salida = new MostrarExecuteStockProcessType();
			// process
			modelError = getModelMensajesObtenerExecuteStockProcessType(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			Map<String, Object> model = getModelMensajesObtenerExecuteStockProcessType(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			model.putAll(getModelExecuteStockProcessType(command));
			model.putAll(getAdicionalModelCrear());
			salida = getService().executeStockProcessService(command);
			log.debug("salida:"+salida);
			if (salida != null) {

				List<MostrarExecuteStockProcessType> lista = new ArrayList<MostrarExecuteStockProcessType>();
				MostrarExecuteStockProcessType objeto = new MostrarExecuteStockProcessType();

				objeto.setCodeReply(salida.getCodeReply());
				objeto.setIdEvent(salida.getIdEvent());
				objeto.setMessageReply(salida.getMessageReply());
				lista.add(objeto);
				model.put(LISTA, lista);
			}
			log.info("ingreso al metodo doExecuteStockProcess fin");
			return new ModelAndView(getExecuteStockProcessSuccessfullView(), model);
		} catch (Exception e) {
			log.info("ingreso al metodo doExecuteStockProcess fin");
			modelError.put("errorConexion", Constante.ERROR_CONEXION);
			return new ModelAndView(getExecuteStockProcessErrorView(), modelError);
		}
	}

	protected ObtenerExecuteStockProcessType getCommandExecuteStockProcess(HttpServletRequest request) throws Exception {
		ObtenerExecuteStockProcessType command = getCommandInstanceExecuteStockProcessType();
		bind(request, command);
		return command;
	}

	protected ObtenerCheckProcessStatusStockType getCommand(HttpServletRequest request) throws Exception {
		log.info("ingreso al metodo getCommand inicio");
		ObtenerCheckProcessStatusStockType command = getCommandInstance();
		bind(request, command);
		log.info("ingreso al metodo getCommand fin");
		return command;
	}

	protected String getMensajeRegistrarError() {
		return Constante.ERROR_PROCESS_LOAD_STOK_PRECIOS;
	}

	protected String getMensajeRegistrarSatisfactorio() {
		return Constante.SUCCESSFULL_PROCESS_LOAD_STOK_PRECIOS;
	}

	protected Map<String, Object> getModelMensajes(ObtenerCheckProcessStatusStockType command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModel(ObtenerCheckProcessStatusStockType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	protected boolean tieneErrores(ObtenerCheckProcessStatusStockType command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
	}

	protected Map<String, Object> getModel(ObtenerExecuteStockProcessType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/* procesos ExecutePriceProcessType */

	protected Map<String, Object> getModelMensajesObtenerExecuteStockProcessType(ObtenerExecuteStockProcessType command, String mensajeError, String mensajeExito) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErroresObtenerExecuteStockProcessType(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		} else {
			model.put(Constante.KEY_TIPO_MENSAJE_EXITO, mensajeExito);
		}
		return model;
	}

	protected boolean tieneErroresObtenerExecuteStockProcessType(ObtenerExecuteStockProcessType command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
	}

	protected Map<String, Object> getModelExecuteStockProcessType(ObtenerExecuteStockProcessType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/* fin proceso ExecutePriceProcessType */

	@SuppressWarnings("unchecked")
	protected ObtenerCheckProcessStatusStockType getCommandInstance() throws Exception {
		ObtenerCheckProcessStatusStockType command = new ObtenerCheckProcessStatusStockType();
		return command;
	}

	@SuppressWarnings("unchecked")
	protected ObtenerExecuteStockProcessType getCommandInstanceExecuteStockProcessType() throws Exception {
		ObtenerExecuteStockProcessType command = new ObtenerExecuteStockProcessType();
		return command;
	}

	/* METHODS GETS AND SETTERS */

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}


	public String getClaroServiceStockLoadView() {
		return claroServiceStockLoadView;
	}

	public void setClaroServiceStockLoadView(String claroServiceStockLoadView) {
		this.claroServiceStockLoadView = claroServiceStockLoadView;
	}


	public ClaroServiceStockLoadService getService() {
		return (ClaroServiceStockLoadService) service;
	}

	public void setService(ClaroServiceStockLoadService service) {
		this.service = service;
	}


	public String getCheckProcessStockStatusSuccessfullView() {
		return checkProcessStockStatusSuccessfullView;
	}

	public void setCheckProcessStockStatusSuccessfullView(String checkProcessStockStatusSuccessfullView) {
		this.checkProcessStockStatusSuccessfullView = checkProcessStockStatusSuccessfullView;
	}

	public String getExecuteStockProcessSuccessfullView() {
		return executeStockProcessSuccessfullView;
	}

	public void setExecuteStockProcessSuccessfullView(String executeStockProcessSuccessfullView) {
		this.executeStockProcessSuccessfullView = executeStockProcessSuccessfullView;
	}


	public String getExecuteStockProcessErrorView() {
		return executeStockProcessErrorView;
	}

	public void setExecuteStockProcessErrorView(String executeStockProcessErrorView) {
		this.executeStockProcessErrorView = executeStockProcessErrorView;
	}

	public String getCheckProcessStockStatusErrorView() {
		return checkProcessStockStatusErrorView;
	}

	public void setCheckProcessStockStatusErrorView(String checkProcessStockStatusErrorView) {
		this.checkProcessStockStatusErrorView = checkProcessStockStatusErrorView;
	}



}
