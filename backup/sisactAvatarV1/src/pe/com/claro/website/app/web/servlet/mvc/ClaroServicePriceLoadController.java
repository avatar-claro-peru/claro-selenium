package pe.com.claro.website.app.web.servlet.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.domain.service.MostrarCheckProcessStatusPriceType;
import pe.com.claro.website.app.domain.service.MostrarExecutePriceProcessType;
import pe.com.claro.website.app.domain.service.ObtenerCheckProcessStatusPriceType;
import pe.com.claro.website.app.domain.service.ObtenerExecutePriceProcessType;
import pe.com.claro.website.app.service.ClaroServicePriceLoadService;

/**
 * @author Alfredo Rojas Cabezas
 * 
 */
public class ClaroServicePriceLoadController extends MultiActionController {

	static Logger log = Logger.getLogger(ClaroServicePriceLoadController.class);
	
	private String commandName;

	public static final String LISTA = "lista";

	private String claroServicePriceLoadView;

	private String checkProcessStatusSuccessfullView;

	private String executePriceProcessSuccessfullView;

	private String executePriceProcessErrorView;

	private String checkProcessStatusErrorView;

	private ClaroServicePriceLoadService service;

	protected ClaroServicePriceLoadController() {
		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		setMethodNameResolver(resolver);
	}

	public ModelAndView claroServicePriceLoadView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = getAdicionalModelCrear();
		return new ModelAndView(getClaroServicePriceLoadView(), model);
	}

	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}

	/* Metodo doCheckProcessStatus */
	public ModelAndView doCheckProcessStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("doCheckProcessStatus:");
		Map<String, Object> modelError = new HashMap<String, Object>();

		try {
			ObtenerCheckProcessStatusPriceType command = getCommand(request);
			MostrarCheckProcessStatusPriceType salida = new MostrarCheckProcessStatusPriceType();
			// process
			modelError = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			model.putAll(getModel(command));
			model.putAll(getAdicionalModelCrear());
			salida = getService().checkProcessStatusService(command);
			
			List<MostrarCheckProcessStatusPriceType> lista = new ArrayList<MostrarCheckProcessStatusPriceType>();
			MostrarCheckProcessStatusPriceType objeto = new MostrarCheckProcessStatusPriceType();
			
			if (salida != null) {
				objeto.setCodeReply(salida.getCodeReply());
				objeto.setIdEvent(salida.getIdEvent());
				objeto.setMessageReply(salida.getMessageReply());
				lista.add(objeto);
				model.put(LISTA, lista);
				log.info("doExecutePriceProcess fin");
				return new ModelAndView(getCheckProcessStatusSuccessfullView(), model);
			}else {
				
				modelError.put("errorConexion", Constante.ERROR_CONEXION);
				log.info("doExecutePriceProcess fin error");
				return new ModelAndView(getCheckProcessStatusErrorView(), modelError);
			}


		} catch (Exception e) {
			modelError.put("errorConexion", Constante.ERROR_CONEXION);
			log.info("doExecutePriceProcess fin error");
			return new ModelAndView(getCheckProcessStatusErrorView(), modelError);
		}
	}

	/* Metodo doExecutePriceProcess */
	public ModelAndView doExecutePriceProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info("doExecutePriceProcess inicio");
		Map<String, Object> modelError = new HashMap<String, Object>();

		try {

			ObtenerExecutePriceProcessType command = getCommandExecutePriceProcess(request);
			MostrarExecutePriceProcessType salida = new MostrarExecutePriceProcessType();
			// process
			modelError = getModelMensajesObtenerExecutePriceProcessType(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			Map<String, Object> model = getModelMensajesObtenerExecutePriceProcessType(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
			model.putAll(getModelExecutePriceProcessType(command));
			model.putAll(getAdicionalModelCrear());
			salida = getService().executePriceProcessService(command);
			if (salida != null) {

				List<MostrarExecutePriceProcessType> lista = new ArrayList<MostrarExecutePriceProcessType>();
				MostrarExecutePriceProcessType objeto = new MostrarExecutePriceProcessType();

				objeto.setCodeReply(salida.getCodeReply());
				objeto.setIdEvent(salida.getIdEvent());
				objeto.setMessageReply(salida.getMessageReply());
				lista.add(objeto);
				model.put(LISTA, lista);
				log.info("doExecutePriceProcess fin");
				return new ModelAndView(getExecutePriceProcessSuccessfullView(), model);
			}else {
				modelError.put("errorConexion", Constante.ERROR_CONEXION);
				log.info("doExecutePriceProcess fin error");
				return new ModelAndView(getExecutePriceProcessErrorView(), modelError);
			}

		} catch (Exception e) {
			modelError.put("errorConexion", Constante.ERROR_CONEXION);
			log.info("doExecutePriceProcess fin error");
			return new ModelAndView(getExecutePriceProcessErrorView(), modelError);
		}
	}

	protected ObtenerExecutePriceProcessType getCommandExecutePriceProcess(HttpServletRequest request) throws Exception {
		ObtenerExecutePriceProcessType command = getCommandInstanceExecutePriceProcessType();
		bind(request, command);
		return command;
	}

	protected ObtenerCheckProcessStatusPriceType getCommand(HttpServletRequest request) throws Exception {
		ObtenerCheckProcessStatusPriceType command = getCommandInstance();
		bind(request, command);
		return command;
	}

	protected String getMensajeRegistrarError() {
		return Constante.ERROR_PROCESS_LOAD_STOK_PRECIOS;
	}

	protected String getMensajeRegistrarSatisfactorio() {
		return Constante.SUCCESSFULL_PROCESS_LOAD_STOK_PRECIOS;
	}

	protected Map<String, Object> getModelMensajes(ObtenerCheckProcessStatusPriceType command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModel(ObtenerExecutePriceProcessType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	protected boolean tieneErrores(ObtenerCheckProcessStatusPriceType command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
	}

	protected Map<String, Object> getModel(ObtenerCheckProcessStatusPriceType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/* procesos ExecutePriceProcessType */

	protected Map<String, Object> getModelMensajesObtenerExecutePriceProcessType(ObtenerExecutePriceProcessType command, String mensajeError, String mensajeExito) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErroresObtenerExecutePriceProcessType(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		} else {
			model.put(Constante.KEY_TIPO_MENSAJE_EXITO, mensajeExito);
		}
		return model;
	}

	protected boolean tieneErroresObtenerExecutePriceProcessType(ObtenerExecutePriceProcessType command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
	}

	protected Map<String, Object> getModelExecutePriceProcessType(ObtenerExecutePriceProcessType command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/* fin proceso ExecutePriceProcessType */

	@SuppressWarnings("unchecked")
	protected ObtenerCheckProcessStatusPriceType getCommandInstance() throws Exception {
		ObtenerCheckProcessStatusPriceType command = new ObtenerCheckProcessStatusPriceType();
		return command;
	}

	@SuppressWarnings("unchecked")
	protected ObtenerExecutePriceProcessType getCommandInstanceExecutePriceProcessType() throws Exception {
		ObtenerExecutePriceProcessType command = new ObtenerExecutePriceProcessType();
		return command;
	}

	/* METHODS GETS AND SETTERS */

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getClaroServicePriceLoadView() {
		return claroServicePriceLoadView;
	}

	public void setClaroServicePriceLoadView(String claroServicePriceLoadView) {
		this.claroServicePriceLoadView = claroServicePriceLoadView;
	}

	public ClaroServicePriceLoadService getService() {
		return (ClaroServicePriceLoadService) service;
	}

	public void setService(ClaroServicePriceLoadService service) {
		this.service = service;
	}

	public String getCheckProcessStatusSuccessfullView() {
		return checkProcessStatusSuccessfullView;
	}

	public void setCheckProcessStatusSuccessfullView(String checkProcessStatusSuccessfullView) {
		this.checkProcessStatusSuccessfullView = checkProcessStatusSuccessfullView;
	}

	public String getExecutePriceProcessSuccessfullView() {
		return executePriceProcessSuccessfullView;
	}

	public void setExecutePriceProcessSuccessfullView(String executePriceProcessSuccessfullView) {
		this.executePriceProcessSuccessfullView = executePriceProcessSuccessfullView;
	}

	public String getExecutePriceProcessErrorView() {
		return executePriceProcessErrorView;
	}

	public void setExecutePriceProcessErrorView(String executePriceProcessErrorView) {
		this.executePriceProcessErrorView = executePriceProcessErrorView;
	}

	public String getCheckProcessStatusErrorView() {
		return checkProcessStatusErrorView;
	}

	public void setCheckProcessStatusErrorView(String checkProcessStatusErrorView) {
		this.checkProcessStatusErrorView = checkProcessStatusErrorView;
	}

}
