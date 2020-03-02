/**
 * 
 */
package pe.com.claro.website.app.web.servlet.mvc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.admin.util.Fecha;
import pe.com.claro.website.app.domain.Line;
import pe.com.claro.website.app.service.LineService;
//import pe.com.claro.website.seguridad.domain.Usuario;

/**
 * @author lucio
 * 
 */
public class LineController extends MultiActionController {

	public static final String LISTA = "lista";

	public static final String LISTA_SIZE = "listaSize";

	// private static final String METHOD_NAME = "metodo";

	private static final String PREFIX_SESSION_ = "SessionScope";

	private static final String IDS = "ids";

	private static final String ID = "id";

	private LineService service;

	private String commandName;

	private String listView;

	private String registerView;

	private String updateView;

//	protected LineController() {
//
//		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
//		// resolver.setParamName(METHOD_NAME);
//		resolver.setDefaultMethodName("doListar");
//		setMethodNameResolver(resolver);
//	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doListar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Line command = getSessionCommand(request);

		return listarInternal(request, command);
	}

	/**
	 * Metodo para realizar una busqueda
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doBuscar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// input
		Line command = getCommand(request);
		setSessionCommand(command, request);

		return listarInternal(request, command);
	}

	/**
	 * Metodo que muestra la vista para crear
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doNuevoView(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// output
		Map<String, Object> model = getAdicionalModelCrear();
		return new ModelAndView(getRegisterView(), model);
	}

	/**
	 * Metodo para grabar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doSave(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Line command = getCommand(request);
		
		Fecha fecha = new Fecha();
		Date fechaactual = fecha.getFechaActual();
		command.setDateRegister(fechaactual);
		command.setDateUpdate(fechaactual);
		// process
		getService().registrar(command);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		//regresa a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListView(), model);
	}

	/**
	 * Metodo para actulizar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Line command = getCommand(request);
		
		Fecha fecha = new Fecha();
		Date fechaactual = fecha.getFechaActual();
		command.setDateUpdate(fechaactual);

		// process
		getService().actualizar(command);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);

		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());
		
		//Regresa a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListView(), model);
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
		String id = getId(request);

		// process
		Line command = getCommand(id);
		getService().eliminar(id);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListView(), model);

	}

//	public ModelAndView doDeleteArrays(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// input
//		int[] ids = ServletRequestUtils.getIntParameters(request, IDS);
//		// Integer id = getId(request);
//
//		// process
//		Line command = getCommand(ids[0]);
//		getService().eliminarArray(ids);
//
//		// output
//
//		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);
//
//		// regresar a listar
//		model.putAll(doListar(request, response).getModel());
//
//		return new ModelAndView(getListarView(), model);
//
//	}

	/**
	 * Metodo que muestra la vista para editar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doEditView(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// input
		String id = getId(request);

		// process
		Line command = getCommand(id);

		// output
		Map<String, Object> model = getModelMensajesError(command, getMensajeRegistrarError());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());
//		List lista = getService().listarAll(command);
//		model.put(LISTA, lista);
		return new ModelAndView(getUpdateView(), model);
	}

	/**
	 * @param request
	 * @param command
	 * @return
	 * @throws Exception
	 */
	private ModelAndView listarInternal(HttpServletRequest request, Line command) throws Exception {
		// process
		
		Integer id = getIdClient(request);
		Map<String, Object> model = doListar(command , id);

		// output
		model.putAll(getModel(command));

		return new ModelAndView(getListView(), model);
	}

	/**
	 * @param command
	 * @return
	 * @throws Exception
	 */
	protected Map<String, Object> doListar(Line command , Integer id) throws Exception {

		Map<String, Object> model = doListarInternal(command ,id);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> doListarInternal(Line command, Integer id) throws Exception {
		
		List lista = getService().listarAll(id);
		
//		Fecha fecha = new Fecha();
//		Date fechaactual = fecha.getFechaActual();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
//		model.put("fecha", fechaactual);
		return model;
	}

	/**
	 * Metodo para agregar objetos adicionales al formulario de listar
	 * 
	 * @return
	 */
	protected Map<String, Object> getAdicionalModelListar(Line command) throws Exception {
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
	protected Map<String, Object> getModelMensajes(Line command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModelMensajesError(Line command, String mensajeError) {
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
	protected boolean tieneErrores(Line command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}

	/**
	 * @param request
	 * @return
	 */
	protected String getId(HttpServletRequest request) throws Exception {
		Line command = getCommand(request);
		return command.getNumberLine();
	}
	
	protected Integer getIdClient(HttpServletRequest request) throws Exception {
		Line command = getCommand(request);
		return command.getIdClient();
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> getModel(Line command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/**
	 * @param id
	 * @return
	 */
	protected Line getCommand(String id) throws Exception {
		return (Line) getService().selectById(id);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected Line getCommand(HttpServletRequest request) throws Exception {
		Line command = getCommandInstance();
		bind(request, command);
		return command;
	}

	@SuppressWarnings("unchecked")
	protected Line getCommandRequest(HttpServletRequest request) {
		return (Line) request.getAttribute(getCommandName());
	}

	protected void setCommandRequest(HttpServletRequest request, Line command) {
		request.setAttribute(getCommandName(), command);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected final Line getSessionCommand(HttpServletRequest request) throws Exception {
		Line command = (Line) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

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
	protected final void setSessionCommand(Line command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Line getCommandInstance() throws Exception {
		Line command = new Line();
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
	public String getListView() {
		return listView;
	}

	/**
	 * @param listarView
	 */
	public void setListView(String listView) {
		this.listView = listView;
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
	public LineService getService() {
		return (LineService) service;
	}

	/**
	 * @param service
	 */
	public void setService(LineService service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map model = new HashMap();
		Line obj = (Line) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		obj = getService().selectById(obj.getNumberLine());
		System.out.println("numberLine : " + obj.getNumberLine() + "State : " + obj.getState());
		model.put(getCommandName(), obj);
		return new ModelAndView("", model);
	}

}
