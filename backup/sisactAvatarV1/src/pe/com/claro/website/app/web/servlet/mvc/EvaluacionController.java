package pe.com.claro.website.app.web.servlet.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.app.domain.Evaluacion;
import pe.com.claro.website.app.enums.MensajePortabilidadEnum;
import pe.com.claro.website.app.service.EvaluacionService;

public class EvaluacionController extends MultiActionController {

	public static final String LISTA_CAMPOS = "listaCampos";
	public static final String LISTA = "lista";
	public static final String LISTA_SIZE = "listaSize";
	private static final String PREFIX_SESSION_ = "SessionScope";
	private static final String ID = "id";
	private String commandName;
	private String listarEvaluacionView;
	private String actualizarEvaluacionView;
	private EvaluacionService service;

	protected EvaluacionController() {

		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		resolver.setDefaultMethodName("doListarEvaluacion");
		setMethodNameResolver(resolver);
	}

	/**
	 * Metodo Actualiza el estado de parametro a 'I'
	 * */
	@SuppressWarnings("unchecked")
	public ModelAndView doEliminarParametro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Evaluacion command = getCommand(request);
		getService().eliminar(command);
		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);
		model.putAll(doListarEvaluacion(request, response).getModel());
		return new ModelAndView(getListarEvaluacionView(), model);
	}

	// public ModelAndView doDeleteField(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// // input
	// Parametro command = getCommand(request);
	//
	// getService().eliminarCampo(command);
	//
	// List<Parametro> lista =
	// getService().listarCamposPorParam(command.getId());
	// // output
	//
	// Map<String, Object> model = getModelMensajes(command,
	// Constante.KEY_DELETE_ERROR,
	// Constante.KEY_DELETE_SATISFACTORIO);
	//
	// // regresar a listar
	// model.put(LISTA_CAMPOS, lista);
	// model.putAll(getAdicionalModelListar(command));
	// model.putAll(getModel(command));
	//
	// return new ModelAndView(getEliminarCampoView(), model);
	//
	// }

	public ModelAndView doBuscar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// input
		Evaluacion command = getCommand(request);
		setSessionCommand(command, request);

		return listarInternal(request, command);
	}
	
	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected final void setSessionCommand(Evaluacion command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	
	@SuppressWarnings("unchecked")
	public ModelAndView doSave(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Evaluacion command = getCommand(request);
		// process
		getService().registrar(command);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		// regresa a listar
		model.putAll(doListarEvaluacion(request, response).getModel());

		return new ModelAndView(getListarEvaluacionView(), model);
	}

	/**
	 * Metodo para grabar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	// public ModelAndView doSaveField(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	//
	// Parametro command = getCommand(request);
	// // Se registra un nuevo campo
	// getService().registrarCampo(command);
	//
	// //Se lista los campos
	// List<Parametro> lista =
	// getService().listarCamposPorParam(command.getId());
	// //output
	// Map<String, Object> model = getModelMensajes(command,
	// getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
	// model.put(LISTA_CAMPOS, lista);
	// model.putAll(getModel(command));
	// model.putAll(getAdicionalModelCrear());
	//
	// return new ModelAndView(getRegistrarCampoView(), model);
	// }

	/**
	 * Metodo para actualizar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Evaluacion command = getCommand(request);

		// process
		getService().actualizar(command);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);

		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());

		// Regresa a listar
		model.putAll(doListarEvaluacion(request, response).getModel());

		return new ModelAndView(getListarEvaluacionView(), model);
	}

	/**
	 * Metodo para actulizar
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	// public ModelAndView doUpdateField(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// // input
	// Parametro command = getCommand(request);
	//
	// // process
	// getService().actualizarCampo(command);
	//
	// //Se lista los campos
	// List<Parametro> lista =
	// getService().listarCamposPorParam(command.getId());
	//
	// // output
	//
	// Map<String, Object> model = getModelMensajes(command,
	// Constante.KEY_UPDATE_ERROR,
	// Constante.KEY_UPDATE_SATISFACTORIO);
	//
	// model.put(LISTA_CAMPOS, lista);
	// model.putAll(getModel(command));
	// model.putAll(getAdicionalModelCrear());
	//
	// return new ModelAndView(getActualizarCampoView(), model);
	// }

	@SuppressWarnings("unchecked")
	public ModelAndView doEditView(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// input
		Integer id = getId(request);

		// process
		Evaluacion command = getCommand(id);

		Map<String, Object> model = getModelMensajes(command, "", "");
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		List<MensajePortabilidadEnum> msgPortabilidad=MensajePortabilidadEnum.listAll();
		model.put("msgPortabilidad", msgPortabilidad);
		return new ModelAndView(getActualizarEvaluacionView(), model);
	}

	// public ModelAndView doEditFieldView(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	//
	// // input
	// Parametro param = getCommand(request);
	// //String idCampo = request.getParameter("idCampo").toString();
	// //String idPadre = request.getParameter("idPadre").toString();
	// String nomParam =
	// ((Parametro)getService().selectById(param.getIdPadre())).getNombre();
	// request.setAttribute("nombreParamPadre", nomParam);
	//
	// Parametro command = (Parametro)getService().selectOneField(param);
	// // output
	// Map<String, Object> model = getModelMensajes(command,
	// Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);
	// //Map<String, Object> model = getModelMensajesError(command,
	// getMensajeRegistrarError());
	// model.putAll(getModel(command));
	// model.putAll(getAdicionalModelCrear());
	//
	// return new ModelAndView(getEditarCampoPopupView(), model);
	// }

	/**
	 * Lista todos los parametros con estado 'A'
	 * */
	public ModelAndView doListarEvaluacion(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
		Evaluacion command = getSessionCommand(request);
		return listarInternal(request, command);
	}

	private ModelAndView listarInternal(HttpServletRequest request, Evaluacion command) throws Exception {

		Map<String, Object> model = doListar(command);
		model.putAll(getModel(command));

		return new ModelAndView(getListarEvaluacionView(), model);
	}

	protected Map<String, Object> doListar(Evaluacion command) throws Exception {
		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	protected Map<String, Object> doListarInternal(Evaluacion command) throws Exception {
		List lista = getService().listarTodo(command);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		return model;
	}

	protected Map<String, Object> getAdicionalModelListar(Evaluacion command) throws Exception {
		return new HashMap<String, Object>();
	}

	protected Map<String, Object> getModel(Evaluacion command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}


	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}

	@SuppressWarnings("unchecked")
	protected final Evaluacion getSessionCommand(HttpServletRequest request) throws Exception {
		Evaluacion command = (Evaluacion) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

		if (command == null) {
			command = getCommandInstance();
		}
		return command;
	}

	protected Map<String, Object> getModelMensajes(Evaluacion command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModelMensajesError(Evaluacion command, String mensajeError) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErrores(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		}
		return model;
	}

	protected boolean tieneErrores(Evaluacion command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}

	protected String getMensajeRegistrarSatisfactorio() {
		return Constante.KEY_REGISTRAR_SATISFACTORIO;
		// return null;
	}

	protected String getMensajeRegistrarError() {
		return Constante.KEY_REGISTRAR_ERROR;
		// return null;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Integer getId(HttpServletRequest request) throws Exception {
		Evaluacion command = getCommand(request);
		return command.getId();
	}

	/**
	 * @param id
	 * @return
	 */
	protected Evaluacion getCommand(Integer id) throws Exception {
		return (Evaluacion) getService().seleccionarPorId(id);
	}

	protected Evaluacion getCommand(HttpServletRequest request) throws Exception {
		Evaluacion command = getCommandInstance();
		bind(request, command);
		return command;
	}

	@SuppressWarnings("unchecked")
	protected Evaluacion getCommandInstance() throws Exception {
		Evaluacion command = new Evaluacion();
		return command;
	}

	
	public String getListarEvaluacionView() {
		return listarEvaluacionView;
	}

	public void setListarEvaluacionView(String listarEvaluacionView) {
		this.listarEvaluacionView = listarEvaluacionView;
	}

	public String getActualizarEvaluacionView() {
		return actualizarEvaluacionView;
	}

	public void setActualizarEvaluacionView(String actualizarEvaluacionView) {
		this.actualizarEvaluacionView = actualizarEvaluacionView;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public EvaluacionService getService() {
		return service;
	}

	public void setService(EvaluacionService service) {
		this.service = service;
	}
}