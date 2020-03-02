package pe.com.claro.website.app.web.servlet.mvc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.message.Constante;
import pe.com.claro.website.admin.util.Consola;
import pe.com.claro.website.app.domain.DetalleOrden;
import pe.com.claro.website.app.domain.Orden;
import pe.com.claro.website.app.domain.service.MostrarSendEventStatusType;
import pe.com.claro.website.app.domain.service.ObtenerSendEventStatusType;
import pe.com.claro.website.app.enums.MensajePortabilidadEnum;
import pe.com.claro.website.app.service.ClaroServiceSyncOrderService;
import pe.com.claro.website.app.service.DetalleOrdenService;
import pe.com.claro.website.app.service.OrdenesService;
import pe.com.claro.website.app.service.ParametroService;
import pe.com.claro.website.app.web.servlet.mvc.editor.DetalleOrdenEditor;

public class OrdenesController extends MultiActionController{
	
	private static Log logger = LogFactory.getLog(OrdenesController.class);
	
	private String commandName;
	private String listarOrdenesView;
	private String actualizarOrdenesView;
	private String historialOrdenesView;
	private OrdenesService service;
	
	public static final String LISTA_CAMPOS = "listaCampos";
	public static final String LISTA = "lista";
	public static final String LISTA_SIZE = "listaSize";
	private static final String PREFIX_SESSION_ = "SessionScope";
	private static final String COMENTARIO_PRUEBA = "Comentario prueba para orden";
	private ParametroService parametroService;
	private ClaroServiceSyncOrderService serviceSync;
	
	//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - INICIO
	private DetalleOrdenService serviceDetalleOrdenService;
	private String listarDetalleOrdenView;
	//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - FIN

	protected OrdenesController() {
		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		resolver.setDefaultMethodName("doListarOrdenes");
		setMethodNameResolver(resolver);
	}
	
	public ModelAndView doListarOrdenes(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
		Orden command = getSessionCommand(request);
		return listarInternal(request, command);
	}
	
	private ModelAndView listarInternal(HttpServletRequest request, Orden command) throws Exception {
		Map<String, Object> model = doListar(command);
		model.putAll(getModel(command));
		return new ModelAndView(getListarOrdenesView(), model);
	}
	
	protected Map<String, Object> getModel(Orden command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}
	
	protected Map<String, Object> doListar(Orden command) throws Exception {
		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}
	
	protected Map<String, Object> getAdicionalModelListar(Orden command) throws Exception {
		return new HashMap<String, Object>();
	}

	@SuppressWarnings("rawtypes")
	protected Map<String, Object> doListarInternal(Orden orden) throws Exception {
		List lista = getService().listarTodo(orden);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		return model;
	}
	
	protected final Orden getSessionCommand(HttpServletRequest request) throws Exception {
		Orden command = (Orden) request.getSession().getAttribute(PREFIX_SESSION_ + getCommandName());
		if (command == null) {
			command = getCommandInstance();
		}
		return command;
	}
	
	public ModelAndView doEditView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// input
		Integer id = getId(request);
		Orden command = getCommand2(id);
		
		Map<String, Object> model = getModelMensajes(command, "", "");
		/*String estado = String.valueOf(command.getDetalleOrden().getEstadoPrinc());
		if(estado.length()>9)
		{
			estado = estado.substring(estado.length()-9);
		}
		model.put("Estados", Integer.parseInt(estado));*/
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelCrear());
		List<MensajePortabilidadEnum> msgPortabilidad = MensajePortabilidadEnum.listAll();
		model.put("msgPortabilidad", msgPortabilidad);
		
		return new ModelAndView(getActualizarOrdenesView(), model);
	}
	
	//lsoto: 30-01-20 : Implementación del historial de SyncOrder por orden - INICIO
	public ModelAndView doListarDetalleView(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Integer id = getId(request);
		
		Orden orden=getService().selectByIdOrdenDetalle(id);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), orden);
		return new ModelAndView(getListarDetalleOrdenView(), model);
	}
	//lsoto: 30-01-20 : Implementación del historial de SyncOrder por orden - FIN
	
	public ParametroService getParametroService() {
		return parametroService;
	}

	public void setParametroService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}

	public ModelAndView doUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MostrarSendEventStatusType mostrarSendEventStatusType = new MostrarSendEventStatusType();
		// input
		Orden command = getCommand(request);
		
		//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - INICIO
		java.sql.Date fechaSQL = new java.sql.Date(new Date().getTime());
		command.getDetalleOrden().setFechaRegistro(fechaSQL);
		
		getServiceDetalleOrdenService().registrar(command.getDetalleOrden());
		//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - FIN
		
		// output
		logger.info("obteniendo parametros ORDEN_USUARIO y ORDEN_PASSWORD");
		String usuario = parametroService.seleccionarPorNombre("ORDEN_USUARIO").getValor();
		String password = parametroService.seleccionarPorNombre("ORDEN_PASSWORD").getValor();
		String Comentario = parametroService.seleccionarPorNombre("ORDEN_COMMENT").getValor();
		String cantidadLineas = parametroService.seleccionarPorNombre("ORDEN_QTY_LINES").getValor();
		
		logger.info("seteando parametros al objeto ObtenerSendEventStatusType");
		
		ObtenerSendEventStatusType obtenerSendEventStatusType = new ObtenerSendEventStatusType();
		int estadoValue = Integer.parseInt(command.getDetalleOrden().getEstadoPrinc());
		obtenerSendEventStatusType.setEstado(estadoValue);
		obtenerSendEventStatusType.setOrdenNro(command.getIdPedido());
		obtenerSendEventStatusType.setUsuario(usuario);
		obtenerSendEventStatusType.setPassword(password);
		obtenerSendEventStatusType.setCantidadLineas(Integer.parseInt(cantidadLineas));
		
		//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO
		//obtenerSendEventStatusType.setEstado(command.getDetalleOrden().getEstadoPrinc());
		obtenerSendEventStatusType.setCodMssap(command.getDetalleOrden().getCodMssap());
		obtenerSendEventStatusType.setCodPvu(command.getDetalleOrden().getCodPvu());
		obtenerSendEventStatusType.setSerieChip(command.getDetalleOrden().getSerieChip());
		obtenerSendEventStatusType.setSerieEquipo(command.getDetalleOrden().getSerieEquipo());
		obtenerSendEventStatusType.setCodigoOficina(command.getDetalleOrden().getCodigoOficina());
		obtenerSendEventStatusType.setCodigoSolicitud(command.getDetalleOrden().getCodigoSolicitud());
		//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN

		if(Comentario.equals("1")){
			logger.info("setea comentario de prueba: " + COMENTARIO_PRUEBA);
			obtenerSendEventStatusType.setComentario(COMENTARIO_PRUEBA);
		}
		
		logger.info("*****************parametros que se envíaran*************************");
		logger.info("Estado principal: "+obtenerSendEventStatusType.getEstado());
		logger.info("Nro de Orden: "+obtenerSendEventStatusType.getOrdenNro());
		logger.info("Usuario: "+obtenerSendEventStatusType.getUsuario());
		logger.info("password: " +obtenerSendEventStatusType.getPassword());
		//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : INICIO
		logger.info("Código Mssap: "+obtenerSendEventStatusType.getCodMssap());
		logger.info("Código Pvu: "+obtenerSendEventStatusType.getCodPvu());
		logger.info("Serie Chip: "+obtenerSendEventStatusType.getSerieChip());
		logger.info("Serie Equipo: "+obtenerSendEventStatusType.getSerieEquipo());
		logger.info("Código Oficina: "+obtenerSendEventStatusType.getCodigoOficina());
		logger.info("Código Solicitud: "+obtenerSendEventStatusType.getCodigoSolicitud());
		//lsoto: 28-01-20 Incluir campos para el servicio del Sync Order : FIN
		
		if(Comentario.equals("1")){
			logger.info("password: " +obtenerSendEventStatusType.getComentario());
		}
		
		logger.info("llamando al servicio desde OrdenesController");
		
		mostrarSendEventStatusType = serviceSync.sendEventStatus(obtenerSendEventStatusType);
		
		if(mostrarSendEventStatusType!=null){
			// process
			getService().actualizar(command);
			
		}
		
		logger.info("********************Datos de respuesta de l SYNCORDER****************");
		logger.info("Codigo respuesta: "+mostrarSendEventStatusType.getCodigoRespuesta());
		logger.info("Descripción Respuesta: "+mostrarSendEventStatusType.getDescripciónRespuesta());
		logger.info("Estado: "+mostrarSendEventStatusType.getEstado());

		
		Map<String, Object> model = getModelMensajes(command, Constante.KEY_UPDATE_ERROR, Constante.KEY_UPDATE_SATISFACTORIO);
		logger.info("seteando la respuesta en el modelo para obtener los datos en el jsp");
		
		model.put("respuestaServicio",mostrarSendEventStatusType);
		model.putAll(getModel(command));
		model.putAll(getAdicionalModelModificar());
		
		//Regresa a listar
		return new ModelAndView(getHistorialOrdenesView(), model);
	}
	
	protected Map<String, Object> getAdicionalModelModificar() throws Exception {
		return new HashMap<String, Object>();
	}
	
	public ModelAndView doBuscar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Orden command = getCommand(request);
		setSessionCommand(command, request);
		return listarInternal(request, command);
	}
	
	protected final void setSessionCommand(Orden command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}
	
	protected Map<String, Object> getModelMensajes(Orden command, String mensajeError, String mensajeExito) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (tieneErrores(command)) {
			model.put(Constante.KEY_TIPO_MENSAJE_ERROR, mensajeError + " : " + command.getMensajeError());
		} else {
			model.put(Constante.KEY_TIPO_MENSAJE_EXITO, mensajeExito);
		}
		return model;
	}
	
	protected Integer getId(HttpServletRequest request) throws Exception {
		Orden command = getCommand(request);
		return command.getId();
	}
	
	protected boolean tieneErrores(Orden command) {
		return command.getCodigoError() < Constante.KEY_RETORNO_VALIDO;
		// return true;
	}
	
	protected Orden getCommand(HttpServletRequest request) throws Exception {
		Orden command = getCommandInstance();
		bind(request, command);
		return command;
	}
	
	protected Orden getCommand2( Integer id) throws Exception {
		return (Orden) getService().seleccionarPorId(id);
	}
	
	protected Orden getCommand( Integer id) throws Exception {
		return (Orden) getService().seleccionarPorPedidoId(id);
	}
	
	protected Orden getCommandInstance() throws Exception {
		Orden command = new Orden();
		return command;
	}
	
	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getListarOrdenesView() {
		return listarOrdenesView;
	}

	public void setListarOrdenesView(String listarOrdenesView) {
		this.listarOrdenesView = listarOrdenesView;
	}

	public String getActualizarOrdenesView() {
		return actualizarOrdenesView;
	}

	public void setActualizarOrdenesView(String actualizarOrdenesView) {
		this.actualizarOrdenesView = actualizarOrdenesView;
	}

	public OrdenesService getService() {
		return service;
	}

	public void setService(OrdenesService service) {
		this.service = service;
	}
	
	public ClaroServiceSyncOrderService getServiceSync() {
		return serviceSync;
	}

	public void setServiceSync(ClaroServiceSyncOrderService serviceSync) {
		this.serviceSync = serviceSync;
	}

	public String getHistorialOrdenesView() {
		return historialOrdenesView;
	}

	public void setHistorialOrdenesView(String historialOrdenesView) {
		this.historialOrdenesView = historialOrdenesView;
	}

	//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - INICIO
	public DetalleOrdenService getServiceDetalleOrdenService() {
		return serviceDetalleOrdenService;
	}

	public void setServiceDetalleOrdenService(DetalleOrdenService serviceDetalleOrdenService) {
		this.serviceDetalleOrdenService = serviceDetalleOrdenService;
	}
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {

		Consola.viewParametrosRequest(request);
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(DetalleOrden.class, new DetalleOrdenEditor());
		// now Spring knows how to handle multipart object and convert them
	}

	public String getListarDetalleOrdenView() {
		return listarDetalleOrdenView;
	}

	public void setListarDetalleOrdenView(String listarDetalleOrdenView) {
		this.listarDetalleOrdenView = listarDetalleOrdenView;
	}
	//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - FIN
}