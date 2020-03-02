/**
 * 
 */
package pe.com.claro.website.app.web.servlet.mvc;

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
import pe.com.claro.website.app.domain.TipoPlan;
import pe.com.claro.website.app.domain.TopeConsumo;
import pe.com.claro.website.app.service.TipoPlanService;
import pe.com.claro.website.app.service.TopeConsumoService;
import pe.com.claro.website.seguridad.domain.Opcion;
import pe.com.claro.website.seguridad.domain.Perfil;

import pe.com.claro.website.seguridad.service.OpcionService;
import pe.com.claro.website.seguridad.service.PerfilOpcionService;
import pe.com.claro.website.seguridad.service.TopeConsumoTipoPlanOpcionService;

/**
 * @author Leonardo Soto
 * 
 */
public class TipoPlanController extends MultiActionController {

	public static final String LISTA = "lista";

	public static final String LISTA_SIZE = "listaSize";

	// private static final String METHOD_NAME = "metodo";

	private static final String PREFIX_SESSION_ = "SessionScope";

	private static final String IDS = "ids";

	private TipoPlanService service;

	private String commandName;

	private String listarView;
	//private String listarViewTopeConsumo;
	private String registrarView;

	private String actualizarView;
	
	//private TopeConsumoTipoPlanOpcionService serviceOpcion;
	private TopeConsumoService serviceTopeConsumo;
	
	//private PerfilOpcionService servicePerfilOpcion;
	private TopeConsumoTipoPlanOpcionService serviceTopeConsumoxTipoPlan;
	
	//Agregamos la validación de tipo de plan
	private TipoPlanService serviceTipoPLan;
	
	private String addOpcionView;
	
	private String addTopeConsumoView;

	protected TipoPlanController() {

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

		TipoPlan command = getSessionCommand(request);

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
		TipoPlan command = getCommand(request);
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

		TipoPlan command = getCommand(request);
		// process
		getService().registrar(command);
		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		//regresa a listar
		//model.putAll(doListar(request, response).getModel());
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
		TipoPlan command = getCommand(request);

		// process
		getService().actualizar(command);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);

		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());
		
		//Regresa a listar
		//model.putAll(doListar(request, response).getModel());

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
		TipoPlan command = getCommand(id);
		getService().eliminar(id);

		// output

		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListarView(), model);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView doDeleteArrays(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		int[] ids = ServletRequestUtils.getIntParameters(request, IDS);
		// Integer id = getId(request);

		// process
		TipoPlan command = getCommand(ids[0]);
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
		TipoPlan command = getCommand(id);

		// output
		Map<String, Object> model = getModelMensajesError(command, getMensajeRegistrarError());
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());
//		List lista = getService().listarAll(command);
//		model.put(LISTA, lista);
		return new ModelAndView(getActualizarView(), model);
	}
	
	//lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - INICIO
	public ModelAndView doAddTopesConsumo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		TipoPlan command = getCommand(request);

		// process
		List<TopeConsumo> listTopesCoonsumoAsignados=getServiceTopeConsumo().listarTopesConsumoByTipoPlan(command);
		List<TopeConsumo> listTopesConsumo=getServiceTopeConsumo().listarAll(null);
		TipoPlan tipoPlanSeleccionado=getServiceTipoPLan().selectById(command.getId());

		// output
		Map<String, Object> model = getModelMensajes(command, getMensajeRegistrarError(), getMensajeRegistrarSatisfactorio());
		model.putAll(getModel(command));
		model.put("listTopesCoonsumoAsignados",listTopesCoonsumoAsignados);
		model.put("listTopesConsumo",listTopesConsumo);
		model.put("tipoPlanSeleccionado", tipoPlanSeleccionado);
		
		return new ModelAndView(getAddTopeConsumoView(), model);
	}
	
	public ModelAndView doActualizarTopesConsumo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Integer id = getId(request);
		
		int[] idTopesConsumo = ServletRequestUtils.getIntParameters(request, "idTopeConsumo");
		// Integer id = getId(request);

		// process
		TipoPlan command = getCommand(id);
		
		//Eliminar los tipos de consumo que tiene el tipo de plan y luego registrar los que selecciono.
		getServiceTopeConsumoxTipoPlan().eliminarByTopeConsumoId(command);
		getServiceTopeConsumoxTipoPlan().registrarTipoPlanxTopeConsumo(id, idTopesConsumo);

		// output
		Map<String, Object> model = getModelMensajes(command, Constante.KEY_DELETE_ERROR, Constante.KEY_DELETE_SATISFACTORIO);

		// regresar a listar
		model.putAll(doListar(request, response).getModel());

		return new ModelAndView(getListarView(), model);

	}
	//lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - INICIO

	/**
	 * @param request
	 * @param command
	 * @return
	 * @throws Exception
	 */
	private ModelAndView listarInternal(HttpServletRequest request, TipoPlan command) throws Exception {
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
	protected Map<String, Object> doListar(TipoPlan command) throws Exception {

		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	/**
	 * @param command
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Map<String, Object> doListarInternal(TipoPlan command) throws Exception {
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
	protected Map<String, Object> getAdicionalModelListar(TipoPlan command) throws Exception {
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
	protected Map<String, Object> getModelMensajes(TipoPlan command, String mensajeError, String mensajeExito) {
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
	protected Map<String, Object> getModelMensajesError(TipoPlan command, String mensajeError) {
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
	protected boolean tieneErrores(TipoPlan command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}

	/**
	 * @param request
	 * @return
	 */
	protected Integer getId(HttpServletRequest request) throws Exception {
		TipoPlan command = getCommand(request);
		return command.getId();
	}

	/**
	 * @param command
	 * @return
	 */
	protected Map<String, Object> getModel(TipoPlan command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	/**
	 * @param id
	 * @return
	 */
	protected TipoPlan getCommand(Integer id) throws Exception {
		return (TipoPlan) getService().selectById(id);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected TipoPlan getCommand(HttpServletRequest request) throws Exception {
		TipoPlan command = getCommandInstance();
		bind(request, command);
		return command;
	}

	protected TipoPlan getCommandRequest(HttpServletRequest request) {
		return (TipoPlan) request.getAttribute(getCommandName());
	}

	protected void setCommandRequest(HttpServletRequest request, TipoPlan command) {
		request.setAttribute(getCommandName(), command);
	}

	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	protected final TipoPlan getSessionCommand(HttpServletRequest request) throws Exception {
		TipoPlan command = (TipoPlan) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());

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
	protected final void setSessionCommand(TipoPlan command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected TipoPlan getCommandInstance() throws Exception {
		TipoPlan command = new TipoPlan();
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
	public TipoPlanService getService() {
		return (TipoPlanService) service;
	}

	/**
	 * @param service
	 */
	public void setService(TipoPlanService service) {
		this.service = service;
	}

	public String getAddOpcionView() {
		return addOpcionView;
	}

	public void setAddOpcionView(String addOpcionView) {
		this.addOpcionView = addOpcionView;
	}

	public String getAddTopeConsumoView() {
		return addTopeConsumoView;
	}

	public void setAddTopeConsumoView(String addTopeConsumoView) {
		this.addTopeConsumoView = addTopeConsumoView;
	}

	public TopeConsumoService getServiceTopeConsumo() {
		return serviceTopeConsumo;
	}

	public void setServiceTopeConsumo(TopeConsumoService serviceTopeConsumo) {
		this.serviceTopeConsumo = serviceTopeConsumo;
	}

	public TopeConsumoTipoPlanOpcionService getServiceTopeConsumoxTipoPlan() {
		return serviceTopeConsumoxTipoPlan;
	}

	public void setServiceTopeConsumoxTipoPlan(TopeConsumoTipoPlanOpcionService serviceTopeConsumoxTipoPlan) {
		this.serviceTopeConsumoxTipoPlan = serviceTopeConsumoxTipoPlan;
	}

	public TipoPlanService getServiceTipoPLan() {
		return serviceTipoPLan;
	}

	public void setServiceTipoPLan(TipoPlanService serviceTipoPLan) {
		this.serviceTipoPLan = serviceTipoPLan;
	}
}
