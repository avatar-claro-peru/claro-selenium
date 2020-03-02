/**
 * 
 */
package pe.com.claro.website.seguridad.web.servlet.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.seguridad.domain.Opcion;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.service.OpcionService;
import pe.com.claro.website.seguridad.service.PerfilOpcionService;
import pe.com.claro.website.seguridad.service.PerfilService;

/**
 * @author lucio
 * 
 */
public class PerfilController extends MultiActionController {

	public static final String LISTA = "lista";

	public static final String LISTA_SIZE = "listaSize";

	// private static final String METHOD_NAME = "metodo";

	private static final String PREFIX_SESSION_ = "SessionScope";

	private static final String IDS = "ids";

	private static final String ID = "id";

	private PerfilService service;
	
	private OpcionService serviceOpcion;
	
	private PerfilOpcionService servicePerfilOpcion;

	private String commandName;

	private String listarView;

	private String registrarView;

	private String actualizarView;
	
	private String addOpcionView;

	protected PerfilController() {

		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		// resolver.setParamName(METHOD_NAME);
		resolver.setDefaultMethodName("doListar");
		setMethodNameResolver(resolver);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doListar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Perfil command = getSessionCommand(request);

		return listarInternal(request, command);
	}

	
	/**
	 * Metodo para listar los roles asociados al usuario
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView doAddOpciones(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Perfil command = getCommand(request);
		// process
		List<Opcion> listOpcionesAsignados=getServiceOpcion().listarOpcionesByPerfil(command);
		List<Opcion> listOpciones=getServiceOpcion().listarAll(null);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.put("listOpcionesAsignados",listOpcionesAsignados);
		model.put("listOpciones",listOpciones);
		
		return new ModelAndView(getAddOpcionView(), model);
	}	
	

	public ModelAndView doActualizarOpciones(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Integer id = getId(request);
		
		int[] idOpciones = ServletRequestUtils.getIntParameters(request, "idOpcion");
		// Integer id = getId(request);

		// process
		Perfil command = getCommand(id);
		//Eliminar las opciones que tiene el rol y luego registrar los que selecciono.
		getServicePerfilOpcion().eliminarByPerfilId(command);
		getServicePerfilOpcion().registrarPerfilOpcion(id,idOpciones);
		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListarView(), model);

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
		Perfil command = getCommand(request);
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
		return new ModelAndView(getRegistrarView(), model);
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

		Perfil command = getCommand(request);
		// process
		getService().registrar(command);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());

		return new ModelAndView(getRegistrarView(), model);
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
		Perfil command = getCommand(request);

		// process
		getService().actualizar(command);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);

		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());

		return new ModelAndView(getActualizarView(), model);
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
		Perfil command = getCommand(id);
		getService().eliminar(id);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListarView(), model);

	}

	public ModelAndView doDeleteArrays(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		int[] ids = ServletRequestUtils.getIntParameters(request, IDS);
		// Integer id = getId(request);

		// process
		Perfil command = getCommand(ids[0]);
		getService().eliminarArray(ids);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListarView(), model);

	}

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
		Integer id = getId(request);

		// process
		Perfil command = getCommand(id);

		// output
		Map<String, Object> model = getModelMensajesError(command, getMensajeRegistrarError());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());

		return new ModelAndView(getActualizarView(), model);
	}

	/**
	 * @param request
	 * @param command
	 * @return
	 * @throws Exception
	 */
	private ModelAndView listarInternal(HttpServletRequest request, Perfil command) throws Exception {
		// process
		Map<String, Object> model = doListar(command);

		// output
		model.putAll(getModel(command));

		return new ModelAndView(getListarView(), model);
	}

	/**
	 * @param command
	 * @return
	 * @throws Exception
	 */
	protected Map<String, Object> doListar(Perfil command) throws Exception {

		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> doListarInternal(Perfil command) throws Exception {
		List lista = getService().listarAll(command);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		return model;
	}

	/**
	 * Metodo para agregar objetos adicionales al formulario de listar
	 * 
	 * @return
	 */
	protected Map<String, Object> getAdicionalModelListar(Perfil command) throws Exception {
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
	protected Map<String, Object> getModelMensajes(Perfil command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModelMensajesError(Perfil command, String mensajeError) {
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
	protected boolean tieneErrores(Perfil command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Integer getId(HttpServletRequest request) throws Exception {
		Perfil command = getCommand(request);
		return command.getId();
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> getModel(Perfil command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/**
	 * @param id
	 * @return
	 */
	protected Perfil getCommand(Integer id) throws Exception {
		return (Perfil) getService().selectById(id);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected Perfil getCommand(HttpServletRequest request) throws Exception {
		Perfil command = getCommandInstance();
		bind(request, command);
		return command;
	}

	@SuppressWarnings("unchecked")
	protected Perfil getCommandRequest(HttpServletRequest request) {
		return (Perfil) request.getAttribute(getCommandName());
	}

	protected void setCommandRequest(HttpServletRequest request, Perfil command) {
		request.setAttribute(getCommandName(), command);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected final Perfil getSessionCommand(HttpServletRequest request) throws Exception {
		Perfil command = (Perfil) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

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
	protected final void setSessionCommand(Perfil command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Perfil getCommandInstance() throws Exception {
		Perfil command = new Perfil();
		return command;
	}

	/**
	 * @return
	 */
	public String getRegistrarView() {
		return registrarView;
	}

	/**
	 * @param crearView
	 */
	public void setRegistrarView(String crearView) {
		this.registrarView = crearView;
	}

	/**
	 * @return
	 */
	public String getActualizarView() {
		return actualizarView;
	}

	/**
	 * @param editarView
	 */
	public void setActualizarView(String editarView) {
		this.actualizarView = editarView;
	}

	/**
	 * @return
	 */
	public String getListarView() {
		return listarView;
	}

	/**
	 * @param listarView
	 */
	public void setListarView(String listarView) {
		this.listarView = listarView;
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
	public PerfilService getService() {
		return (PerfilService) service;
	}

	/**
	 * @param service
	 */
	public void setService(PerfilService service) {
		this.service = service;
	}

	public OpcionService getServiceOpcion() {
		return serviceOpcion;
	}

	public void setServiceOpcion(OpcionService serviceOpcion) {
		this.serviceOpcion = serviceOpcion;
	}

	public PerfilOpcionService getServicePerfilOpcion() {
		return servicePerfilOpcion;
	}

	public void setServicePerfilOpcion(PerfilOpcionService servicePerfilOpcion) {
		this.servicePerfilOpcion = servicePerfilOpcion;
	}

	public String getAddOpcionView() {
		return addOpcionView;
	}

	public void setAddOpcionView(String addOpcionView) {
		this.addOpcionView = addOpcionView;
	}

	
	
}
