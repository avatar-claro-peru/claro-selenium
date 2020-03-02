package pe.com.claro.website.app.web.servlet.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.admin.util.Consola;
import pe.com.claro.website.app.domain.Cliente;
import pe.com.claro.website.app.domain.Solicitud;
import pe.com.claro.website.app.service.SolicitudService;
import pe.com.claro.website.app.web.servlet.mvc.editor.ClienteEditor;

public class SolicitudController extends MultiActionController {

	private static Log logger = LogFactory.getLog(SolicitudController.class);

	private String commandName;
	private String listarSolicitudesView;
	private String actualizarSolicitudesView;
	private String historialSolicitudesView;
	private SolicitudService service;

	public static final String LISTA = "lista";
	public static final String LISTA_SIZE = "listaSize";
	private static final String PREFIX_SESSION_ = "SessionScope";

	protected SolicitudController() {
		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		resolver.setDefaultMethodName("doListarSolicitudes");
		setMethodNameResolver(resolver);
	}

	public ModelAndView doListarSolicitudes(HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
		Solicitud command = getSessionCommand(request);
		return listarInternal(request, command);
	}

	private ModelAndView listarInternal(HttpServletRequest request, Solicitud command) throws Exception {
		Map<String, Object> model = doListar(command);
		model.putAll(getModel(command));
		return new ModelAndView(getListarSolicitudesView(), model);
	}

	protected Map<String, Object> doListar(Solicitud command) throws Exception {
		Map<String, Object> model = doListarInternal(command);
		model.putAll(getAdicionalModelListar(command));
		return model;
	}

	protected final Solicitud getSessionCommand(HttpServletRequest request) throws Exception {
		
		Solicitud command = getCommandInstance();
		return command;
	}

	protected Map<String, Object> getModel(Solicitud command) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(getCommandName(), command);
		return model;
	}

	protected Map<String, Object> getAdicionalModelListar(Solicitud command) throws Exception {
		return new HashMap<String, Object>();
	}

	protected Solicitud getCommandInstance() throws Exception {
		Solicitud command = new Solicitud();
		return command;
	}

	@SuppressWarnings("rawtypes")
	protected Map<String, Object> doListarInternal(Solicitud solicitud) throws Exception {
		List lista = getService().listarTodo(solicitud);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(LISTA, lista);
		return model;
	}

	public ModelAndView doBuscar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Solicitud command = getCommand(request);
		setSessionCommand(command, request);
		return listarInternal(request, command);
	}

	protected Solicitud getCommand(HttpServletRequest request) throws Exception {
		Solicitud command = getCommandInstance();
		bind(request, command);
		return command;
	}

	protected final void setSessionCommand(Solicitud command, HttpServletRequest request) {
		request.getSession().setAttribute(PREFIX_SESSION_ + getCommandName(), command);
	}

	public String getListarSolicitudesView() {
		return listarSolicitudesView;
	}

	public void setListarSolicitudesView(String listarSolicitudesView) {
		this.listarSolicitudesView = listarSolicitudesView;
	}

	public String getActualizarSolicitudesView() {
		return actualizarSolicitudesView;
	}

	public void setActualizarSolicitudesView(String actualizarSolicitudesView) {
		this.actualizarSolicitudesView = actualizarSolicitudesView;
	}

	public String getHistorialSolicitudesView() {
		return historialSolicitudesView;
	}

	public void setHistorialSolicitudesView(String historialSolicitudesView) {
		this.historialSolicitudesView = historialSolicitudesView;
	}

	public SolicitudService getService() {
		return service;
	}

	public void setService(SolicitudService service) {
		this.service = service;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {

		Consola.viewParametrosRequest(request);
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Cliente.class, new ClienteEditor());
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
	}
}
