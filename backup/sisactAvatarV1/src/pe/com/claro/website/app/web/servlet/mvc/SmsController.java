package pe.com.claro.website.app.web.servlet.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.admin.util.Fecha;
import pe.com.claro.website.app.dao.ibatis.LineDAOiBatis;
import pe.com.claro.website.app.domain.Line;
import pe.com.claro.website.app.domain.Sms;
import pe.com.claro.website.app.service.LineService;
import pe.com.claro.website.app.service.SmsService;

public class SmsController extends MultiActionController {
	
	private static Log log = LogFactory.getLog(SmsController.class);
	
	public static final String LISTA = "lista";

	public static final String LISTA_SIZE = "listaSize";

	// private static final String METHOD_NAME = "metodo";

	private static final String PREFIX_SESSION_ = "SessionScope";

	private static final String IDS = "ids";

	private static final String ID = "id";

	private SmsService service;

	private String commandName;

	private String listSmsView;

	private String registerView;

	private String updateView;

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doListar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Sms command = getSessionCommand(request);

		return listarInternal(request, command);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doListarByLineaId(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Sms command = getSessionCommand(request);

		return listarInternalByLineaId(request, command);
	}

	/**
	 * Metodo para eliminar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView doDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Integer id = getId(request);

		// process
		Sms command = getCommand(id);
		getService().eliminar(id);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListSmsView(), model);

	}

	/**
	 * @param request
	 * @param command
	 * @return
	 * @throws Exception
	 */
	private ModelAndView listarInternal(HttpServletRequest request, Sms command) throws Exception {
		// process
		
		Integer id = getId(request);
		Map<String, Object> model = doListar(command , id);

		// output
		model.putAll(getModel(command));

		return new ModelAndView(getListSmsView(), model);
	}
	
	/**
	 * @param request
	 * @param command
	 * @return
	 * @throws Exception
	 */
	private ModelAndView listarInternalByLineaId(HttpServletRequest request, Sms command) throws Exception {
		// process
		
		command = getCommand(request);
		Map<String, Object> model = doListarByLinea(command , command.getIdLinea());

		// output
		model.putAll(getModel(command));

		return new ModelAndView(getListSmsView(), model);
	}

	/**
	 * @param command
	 * @return
	 * @throws Exception
	 */
	protected Map<String, Object> doListar(Sms command , Integer id) throws Exception {

		Map<String, Object> model = doListarInternal(command ,id);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}
	
	/**
	 * @param command
	 * @return
	 * @throws Exception
	 */
	protected Map<String, Object> doListarByLinea(Sms command , Integer id) throws Exception {

		Map<String, Object> model = doListarByLineaId(command ,id);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> doListarInternal(Sms command, Integer id) throws Exception {
		log.debug("doListarInternal inicio");
		List<Sms> lista = getService().listarAll(id);
		log.info("lista cantidad:" + lista.size());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		log.debug("doListarInternal fin");
		return model;
	}
	
	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> doListarByLineaId(Sms command, Integer id) throws Exception {
		log.debug("doListarByLineaId inicio");
		List<Sms> lista = getService().listarByLineaId(id);
		log.info("lista cantidad:" + lista.size());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		log.debug("doListarByLineaId fin");
		return model;
	}	

	/**
	 * Metodo para agregar objetos adicionales al formulario de listar
	 * 
	 * @return
	 */
	protected Map<String, Object> getAdicionalModelListar(Sms command) throws Exception {
		return new HashMap<String, Object>();
	}

	/**
	 * Metodo para agregar objetos adicionales al formulario de listar
	 * 
	 * @return
	 */
	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	/**
	 * Metodo para agregar objetos adicionales al formulario de listar
	 * 
	 * @param request
	 * 
	 * @return
	 */
	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}

	/**
	 * Metodo para agregar objetos adicionales al formulario de listar
	 * 
	 * @return
	 */
	protected Map<String, Object> getAdicionalModelModificar() throws Exception {
		return new HashMap<String, Object>();
	}

	/**
	 * @return
	 */
	protected String getMensajeRegistrarSatisfactorio() {
		return Constante.KEY_REGISTRAR_SATISFACTORIO;
		// return null;
	}

	/**
	 * @return
	 */
	protected String getMensajeRegistrarError() {
		return Constante.KEY_REGISTRAR_ERROR;
		// return null;
	}

	/**
	 * Devuelve el mensaje de error o exito de acuerdo al resultado del command
	 * 
	 * @param command
	 * @param mensajeError
	 * @param mensajeExito
	 * @return
	 */
	protected Map<String, Object> getModelMensajes(Sms command, String mensajeError, String mensajeExito) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErrores(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		} else {
			model.put(Constante.KEY_TIPO_MENSAJE_EXITO, mensajeExito);
		}
		return model;
	}

	/**
	 * Devuelve el mensaje de error o exito de acuerdo al resultado del command
	 * 
	 * @param command
	 * @param mensajeError
	 * @param mensajeExito
	 * @return
	 */
	protected Map<String, Object> getModelMensajesError(Sms command, String mensajeError) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErrores(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		}
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	protected boolean tieneErrores(Sms command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Integer getId(HttpServletRequest request) throws Exception {
		Sms command = getCommand(request);
		return command.getId();
	}
	

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> getModel(Sms command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/**
	 * @param id
	 * @return
	 */
	protected Sms getCommand(Integer id) throws Exception {
		return (Sms) getService().selectById(id);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected Sms getCommand(HttpServletRequest request) throws Exception {
		Sms command = getCommandInstance();
		bind(request, command);
		return command;
	}

	@SuppressWarnings("unchecked")
	protected Sms getCommandRequest(HttpServletRequest request) {
		return (Sms) request.getAttribute(getCommandName());
	}

	protected void setCommandRequest(HttpServletRequest request, Sms command) {
		request.setAttribute(getCommandName(), command);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected final Sms getSessionCommand(HttpServletRequest request) throws Exception {
		Sms command = (Sms) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

		if (command == null) {
			command = getCommandInstance();
		} else {
			// el command ya esta instanciado no hacer nada
		}
		return command;
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected final void setSessionCommand(Sms command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Sms getCommandInstance() throws Exception {
		Sms command = new Sms();
		return command;
	}

	/**
	 * @return
	 */
	public String getRegisterView() {
		return registerView;
	}

	/**
	 * @param crearView
	 */
	public void setRegisterView(String crearView) {
		this.registerView = crearView;
	}

	/**
	 * @return
	 */
	public String getUpdateView() {
		return updateView;
	}

	/**
	 * @param editarView
	 */
	public void setUpdateView(String editarView) {
		this.updateView = editarView;
	}

	/**
	 * @return
	 */
	public String getListSmsView() {
		return listSmsView;
	}

	/**
	 * @param listarView
	 */
	public void setListSmsView(String listSmsView) {
		this.listSmsView = listSmsView;
	}

	/**
	 * @return
	 */
	public String getCommandName() {
		return commandName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.multiaction.MultiActionController
	 * #getCommandName(java.lang.Object)
	 */
	@Override
	protected String getCommandName(Object command) {
		return commandName;
	}

	/**
	 * @param commandName
	 */
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	/**
	 * @return
	 */
	public SmsService getService() {
		return (SmsService) service;
	}

	/**
	 * @param service
	 */
	public void setService(SmsService service) {
		this.service = service;
	}
/*
	@SuppressWarnings("unchecked")
	public ModelAndView actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map model = new HashMap();
		Sms obj = (Sms) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		obj = getService().selectById(obj.getNumberLine());
		System.out.println("numberLine : " + obj.getNumberLine() + "State : " + obj.getState());
		model.put(getCommandName(), obj);
		return new ModelAndView("", model);
	}*/

}
