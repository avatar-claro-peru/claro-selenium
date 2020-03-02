
package pe.com.claro.website.seguridad.web.servlet.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.context.SecurityContextHolder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.seguridad.domain.Perfil;
import pe.com.claro.website.seguridad.domain.Usuario;
import pe.com.claro.website.seguridad.service.PerfilService;
import pe.com.claro.website.seguridad.service.UsuarioPerfilService;
import pe.com.claro.website.seguridad.service.UsuarioService;

/**
 * @author lucio
 * 
 */
public class UsuarioController extends MultiActionController {

	private static Log log = LogFactory.getLog(UsuarioController.class);
	
	public static final String LISTA = "lista";

	public static final String LISTA_SIZE = "listaSize";

	// private static final String METHOD_NAME = "metodo";

	private static final String PREFIX_SESSION_ = "SessionScope";

	private static final String IDS = "ids";

	private static final String ID = "id";

	private UsuarioService service;
	
	private PerfilService servicePerfil;
	
	private UsuarioPerfilService serviceUsuarioPerfil;

	private String commandName;

	private String listarView;

	private String registrarView;

	private String actualizarView;
	
	private String addRolView;

	protected UsuarioController() {

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
		log.info("ingreso al metodo doListar");
		Usuario command = getSessionCommand(request);
		log.info("salio al metodo doListar");
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
	public ModelAndView doAddRoles(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info("ingreso al metodo doAddRoles");
		Usuario command = getCommand(request);
		// process
		List<Perfil> listPerfilesAsignados=getServicePerfil().listarRolesByUsuario(command);
		List<Perfil> listPerfiles=getServicePerfil().listarAll(null);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.put("listPerfilesAsignados",listPerfilesAsignados);
		model.put("listPerfiles",listPerfiles);
		
		return new ModelAndView(getAddRolView(), model);
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
		Usuario command = getCommand(request);
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
		log.info("ingreso al metodo doSave");
		Usuario command = getCommand(request);
		// process
		getService().registrar(command);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		model.putAll(doListar(request, response).getModel());
		log.info("salio al metodo doListar");
		return new ModelAndView(getListarView(), model);
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
		Usuario command = getCommand(request);

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
		log.info("doDelete inicio");
		// input
		Integer id = getId(request);
		log.info("doDelete id:"+id);
		
		// process
		Usuario command = getCommand(id);
		getService().eliminar(command);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());
		log.info("doDelete fin");
		return new ModelAndView(getListarView(), model);

	}

	public ModelAndView doDeleteArrays(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		int[] ids = ServletRequestUtils.getIntParameters(request, IDS);
		// Integer id = getId(request);

		// process
		Usuario command = getCommand(ids[0]);
		getService().eliminarArray(ids);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListarView(), model);

	}
	
	
	public ModelAndView doActualizarRoles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Integer id = getId(request);
		
		int[] idRoles = ServletRequestUtils.getIntParameters(request, "idRol");
		// Integer id = getId(request);

		// process
		Usuario command = getCommand(id);
		//Eliminar los roles que tiene el usuario y luego registrar los que selecciono.
		getServiceUsuarioPerfil().eliminarByUsuarioId(command);
		getServiceUsuarioPerfil().registrarUsuarioPerfil(id,idRoles);
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
		Usuario command = getCommand(id);

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
	private ModelAndView listarInternal(HttpServletRequest request, Usuario command) throws Exception {
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
	protected Map<String, Object> doListar(Usuario command) throws Exception {

		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> doListarInternal(Usuario command) throws Exception {
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
	protected Map<String, Object> getAdicionalModelListar(Usuario command) throws Exception {
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
	protected Map<String, Object> getModelMensajes(Usuario command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModelMensajesError(Usuario command, String mensajeError) {
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
	protected boolean tieneErrores(Usuario command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Integer getId(HttpServletRequest request) throws Exception {
		Usuario command = getCommand(request);
		return command.getId();
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> getModel(Usuario command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/**
	 * @param id
	 * @return
	 */
	protected Usuario getCommand(Integer id) throws Exception {
		log.info("getCommand inicio");
		return (Usuario) getService().selectById(id);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected Usuario getCommand(HttpServletRequest request) throws Exception {
		Usuario command = getCommandInstance();
		bind(request, command);
		return command;
	}

	@SuppressWarnings("unchecked")
	protected Usuario getCommandRequest(HttpServletRequest request) {
		return (Usuario) request.getAttribute(getCommandName());
	}

	protected void setCommandRequest(HttpServletRequest request, Usuario command) {
		request.setAttribute(getCommandName(), command);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected final Usuario getSessionCommand(HttpServletRequest request) throws Exception {
		Usuario command = (Usuario) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

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
	protected final void setSessionCommand(Usuario command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Usuario getCommandInstance() throws Exception {
		Usuario command= new Usuario();
		//Usuario command = (Usuario) GenericUtil.instanciarGenericClass(getClass());
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
	public UsuarioService getService() {
		return (UsuarioService) service;
	}

	/**
	 * @param service
	 */
	public void setService(UsuarioService service) {
		this.service = service;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map model = new HashMap();
		Usuario obj = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		obj = getService().selectById(obj.getId());
		System.out.println("id:" + obj.getId() + "Paa:" + obj.getPassword());
		model.put(getCommandName(), obj);
		return new ModelAndView("", model);
	}

	public String getAddRolView() {
		return addRolView;
	}

	public void setAddRolView(String addRolView) {
		this.addRolView = addRolView;
	}

	public PerfilService getServicePerfil() {
		return servicePerfil;
	}

	public void setServicePerfil(PerfilService servicePerfil) {
		this.servicePerfil = servicePerfil;
	}

	public UsuarioPerfilService getServiceUsuarioPerfil() {
		return serviceUsuarioPerfil;
	}

	public void setServiceUsuarioPerfil(UsuarioPerfilService serviceUsuarioPerfil) {
		this.serviceUsuarioPerfil = serviceUsuarioPerfil;
	}
	
	
}
