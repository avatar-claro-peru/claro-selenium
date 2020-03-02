package pe.com.claro.website.app.web.servlet.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

import pe.com.claro.website.app.service.ClaroServiceSyncOrderService;

public class ClaroServiceSyncOrderController extends MultiActionController{
	
	private static Log log = LogFactory.getLog(ClaroServiceSyncOrderController.class);
	
	private String claroServiceSyncOrderView;
	
	private String checkProcessSyncOrderStatusSuccessfullView;
	
	private String executeSyncOrderProcessSuccessfullView;
	
	private String checkProcessSyncOrderStatusErrorView;
	
	private String executeSyncOrderProcessErrorView;
	
	private ClaroServiceSyncOrderService service;
	
	private String commandName;
	
	
	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public ClaroServiceSyncOrderService getService() {
		return service;
	}

	public void setService(ClaroServiceSyncOrderService service) {
		this.service = service;
	}

	protected ClaroServiceSyncOrderController() {
		ParameterMethodNameResolver resolver = new ParameterMethodNameResolver();
		setMethodNameResolver(resolver);
	}
	
	public ModelAndView claroServiceStockLoadView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> model = getAdicionalModelCrear();
		return new ModelAndView(getClaroServiceSyncOrderView(), model);
	}
	
	
	
	protected Map<String, Object> getAdicionalModelCrear() throws Exception {
		return getAdicionalModelCrear(null);
	}

	protected Map<String, Object> getAdicionalModelCrear(HttpServletRequest request) throws Exception {
		return new HashMap<String, Object>();
	}

	public String getClaroServiceSyncOrderView() {
		return claroServiceSyncOrderView;
	}

	public void setClaroServiceSyncOrderView(String claroServiceSyncOrderView) {
		this.claroServiceSyncOrderView = claroServiceSyncOrderView;
	}

	public String getCheckProcessSyncOrderStatusSuccessfullView() {
		return checkProcessSyncOrderStatusSuccessfullView;
	}

	public void setCheckProcessSyncOrderStatusSuccessfullView(
			String checkProcessSyncOrderStatusSuccessfullView) {
		this.checkProcessSyncOrderStatusSuccessfullView = checkProcessSyncOrderStatusSuccessfullView;
	}

	public String getExecuteSyncOrderProcessSuccessfullView() {
		return executeSyncOrderProcessSuccessfullView;
	}

	public void setExecuteSyncOrderProcessSuccessfullView(
			String executeSyncOrderProcessSuccessfullView) {
		this.executeSyncOrderProcessSuccessfullView = executeSyncOrderProcessSuccessfullView;
	}

	public String getCheckProcessSyncOrderStatusErrorView() {
		return checkProcessSyncOrderStatusErrorView;
	}

	public void setCheckProcessSyncOrderStatusErrorView(
			String checkProcessSyncOrderStatusErrorView) {
		this.checkProcessSyncOrderStatusErrorView = checkProcessSyncOrderStatusErrorView;
	}

	public String getExecuteSyncOrderProcessErrorView() {
		return executeSyncOrderProcessErrorView;
	}

	public void setExecuteSyncOrderProcessErrorView(
			String executeSyncOrderProcessErrorView) {
		this.executeSyncOrderProcessErrorView = executeSyncOrderProcessErrorView;
	}
}
