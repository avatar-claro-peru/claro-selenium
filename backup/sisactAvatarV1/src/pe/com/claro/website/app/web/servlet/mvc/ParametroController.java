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
import pe.com.claro.website.app.domain.Parametro;
import pe.com.claro.website.app.domain.service.MostrarSendEventStatusType;
import pe.com.claro.website.app.domain.service.ObtenerSendEventStatusType;
import pe.com.claro.website.app.service.ClaroServiceSyncOrderService;
import pe.com.claro.website.app.service.ParametroService;

public class ParametroController extends MultiActionController {

	public static final String LISTA_CAMPOS = "listaCampos";
	public static final String LISTA = "lista";
	public static final String LISTA_SIZE = "listaSize";
	private static final String PREFIX_SESSION_ = "SessionScope";
	private static final String ID = "id";
	private String commandName;
	private String listarParametroView;
	private String registrarParametroView;
	private String actualizarParametroView;
	private String eliminarParametroView;
	private ParametroService service;
	private ClaroServiceSyncOrderService serviceSync;
	
	private String listarCamposView;
	private String registrarCampoView;
	private String actualizarCampoView;
	private String eliminarCampoView;
	private String editarCampoPopupView;

	protected ParametroController() {

		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		resolver.setDefaultMethodName("doListarParametro");
		setMethodNameResolver(resolver);
	}
	
	
	/**
	 * Metodo Actualiza el estado de parametro a 'I'
	 * */
	@SuppressWarnings("unchecked")
	public ModelAndView doEliminarParametro(HttpServletRequest request, HttpServletResponse response) throws Exception {				
		Parametro command = getCommand(request);
		getService().eliminar(command);
		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);
		model.putAll(doListarParametro(request, response).getModel());
		return new ModelAndView(getListarParametroView(), model);
	}
	
//	public ModelAndView doDeleteField(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// input
//		Parametro command = getCommand(request);
//
//		getService().eliminarCampo(command);
//		
//		List<Parametro> lista = getService().listarCamposPorParam(command.getId());
//		// output
//		
//		Map<String, Object> model = getModelMensajes(command,
//				Constante.KEY_DELETE_ERROR,
//				Constante.KEY_DELETE_SATISFACTORIO);
//
//		// regresar a listar
//		model.put(LISTA_CAMPOS, lista);
//		model.putAll(getAdicionalModelListar(command));
//		model.putAll(getModel(command));
//		
//		return new ModelAndView(getEliminarCampoView(), model);
//
//	}
	 
	@SuppressWarnings("unchecked")
	public ModelAndView doSave(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Parametro command = getCommand(request);
		// process
		getService().registrar(command);
				
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		//regresa a listar
		//model.putAll(doListarParametro(request, response).getModel());

		return new ModelAndView(getRegistrarParametroView(), model);
	}
	
	/** Metodo para grabar
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
//	public ModelAndView doSaveField(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		
//		Parametro command = getCommand(request);
//		// Se registra un nuevo campo
//		getService().registrarCampo(command);
//		
//		//Se lista los campos
//		List<Parametro> lista = getService().listarCamposPorParam(command.getId());
//		//output
//		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
//		model.put(LISTA_CAMPOS, lista);
//		model.putAll(getModel(command));
//		model.putAll(getAdicionalModelCrear());
//		
//		return new ModelAndView(getRegistrarCampoView(), model);
//	}
	
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
		Parametro command = getCommand(request);

		// process
		getService().actualizar(command);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);

		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		
		//Regresa a listar
		model.putAll(doListarParametro(request, response).getModel());

		return new ModelAndView(getListarParametroView(), model);
	}
	
	/** Metodo para actulizar
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
//	public ModelAndView doUpdateField(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		// input
//		Parametro command = getCommand(request);
//
//		// process
//		getService().actualizarCampo(command);
//
//		//Se lista los campos
//		List<Parametro> lista = getService().listarCamposPorParam(command.getId());
//		
//		// output
//
//		Map<String, Object> model = getModelMensajes(command,
//				Constante.KEY_UPDATE_ERROR,
//				Constante.KEY_UPDATE_SATISFACTORIO);
//		
//		model.put(LISTA_CAMPOS, lista);
//		model.putAll(getModel(command));
//		model.putAll(getAdicionalModelCrear());
//
//		return new ModelAndView(getActualizarCampoView(), model);
//	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView doEditView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// input
		Integer id = getId(request);

		// process
		Parametro command = getCommand(id);
		
		Map<String, Object> model = getModelMensajes(command, "", "");
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		
		return new ModelAndView(getActualizarParametroView(), model);
	}
	
//	public ModelAndView doEditFieldView(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		// input
//		Parametro param = getCommand(request);
//		//String idCampo = request.getParameter("idCampo").toString();
//		//String idPadre = request.getParameter("idPadre").toString();
//		String nomParam = ((Parametro)getService().selectById(param.getIdPadre())).getNombre();
//		request.setAttribute("nombreParamPadre", nomParam);
//		
//		Parametro command = (Parametro)getService().selectOneField(param);
//		// output
//		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);
//		//Map<String, Object> model = getModelMensajesError(command, getMensajeRegistrarError());
//		model.putAll(getModel(command));
//		model.putAll(getAdicionalModelCrear());
//
//		return new ModelAndView(getEditarCampoPopupView(), model);
//	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doListarFields(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Integer id = getId(request);
		
		Parametro command = getCommand(id);

		List<Parametro> lista = getService().listarCamposPorParam(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA_CAMPOS, lista);
		model.putAll(getAdicionalModelListar(command));

		// output
		model.putAll(getModel(command));		
		
		return new ModelAndView( getListarCamposView(), model);
	}
	
	/**
	 * Lista todos los parametros con estado 'A'
	 * */
	public ModelAndView doListarParametro(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
		Parametro command = getSessionCommand(request);
		return listarInternal(request, command);
	}

	private ModelAndView listarInternal(HttpServletRequest request, Parametro command) throws Exception {

		Map<String, Object> model = doListar(command);
		model.putAll(getModel(command));

		return new ModelAndView(getListarParametroView(), model);
	}

	protected Map<String, Object> doListar(Parametro command) throws Exception {
		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	protected Map<String, Object> doListarInternal(Parametro command) throws Exception {
		List lista = getService().listarTodo(command);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		return model;
	}

	protected Map<String, Object> getAdicionalModelListar(Parametro command) throws Exception {
		return new HashMap<String, Object>();
	}

	protected Map<String, Object> getModel(Parametro command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	public ModelAndView doNuevoView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = getAdicionalModelCrear();
		return new ModelAndView(getRegistrarParametroView(), model);
	}
	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}
	
	@SuppressWarnings("unchecked")
	protected final Parametro getSessionCommand(HttpServletRequest request) throws Exception {
		Parametro command = (Parametro) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

		if (command == null) {
			command = getCommandInstance();
		}
		return command;
	}
	protected Map<String, Object> getModelMensajes(Parametro command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModelMensajesError(Parametro command,
			String mensajeError) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErrores(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : "
					+ command.getMensajeError());
		}
		return model;
	}
	protected boolean tieneErrores(Parametro command) {
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
		Parametro command = getCommand(request);
		return command.getId();
	}
	
	/**
	 * @param id
	 * @return
	 */
	protected Parametro getCommand(Integer id) throws Exception {
		return (Parametro) getService().seleccionarPorId(id);
	}
	
	protected Parametro getCommand(HttpServletRequest request) throws Exception {
		Parametro command = getCommandInstance();
		bind(request, command);
		return command;
	}
	@SuppressWarnings("unchecked")
	protected Parametro getCommandInstance() throws Exception {
		Parametro command = new Parametro();
		return command;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getListarParametroView() {
		return listarParametroView;
	}

	public void setListarParametroView(String listarParametroView) {
		this.listarParametroView = listarParametroView;
	}

	public ParametroService getService() {
		return service;
	}

	public void setService(ParametroService service) {
		this.service = service;
	}

	public String getRegistrarParametroView() {
		return registrarParametroView;
	}

	public void setRegistrarParametroView(String registrarParametroView) {
		this.registrarParametroView = registrarParametroView;
	}

	public String getActualizarParametroView() {
		return actualizarParametroView;
	}

	public void setActualizarParametroView(String actualizarParametroView) {
		this.actualizarParametroView = actualizarParametroView;
	}

	public String getEliminarParametroView() {
		return eliminarParametroView;
	}

	public void setEliminarParametroView(String eliminarParametroView) {
		this.eliminarParametroView = eliminarParametroView;
	}


	public String getListarCamposView() {
		return listarCamposView;
	}


	public void setListarCamposView(String listarCamposView) {
		this.listarCamposView = listarCamposView;
	}


	public String getRegistrarCampoView() {
		return registrarCampoView;
	}


	public void setRegistrarCampoView(String registrarCampoView) {
		this.registrarCampoView = registrarCampoView;
	}


	public String getActualizarCampoView() {
		return actualizarCampoView;
	}


	public void setActualizarCampoView(String actualizarCampoView) {
		this.actualizarCampoView = actualizarCampoView;
	}


	public String getEliminarCampoView() {
		return eliminarCampoView;
	}


	public void setEliminarCampoView(String eliminarCampoView) {
		this.eliminarCampoView = eliminarCampoView;
	}


	public String getEditarCampoPopupView() {
		return editarCampoPopupView;
	}


	public void setEditarCampoPopupView(String editarCampoPopupView) {
		this.editarCampoPopupView = editarCampoPopupView;
	}


	public ClaroServiceSyncOrderService getServiceSync() {
		return serviceSync;
	}


	public void setServiceSync(ClaroServiceSyncOrderService serviceSync) {
		this.serviceSync = serviceSync;
	}
	
	

}