package pe.com.claro.website.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;


@SuppressWarnings("serial")
public class LoadServlet extends HttpServlet {
	
	private static Log log = LogFactory.getLog(LoadServlet.class);
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * Process the HTTP service request.
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Ingreso info LoadSisactAvatarServlet");
		log.debug("Ingreso debug LoadSisactAvatarServlet");
		String mimetype = "";
		String accept = request.getHeader("accept");
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		if (accept == null)
			accept = "*/*";
		boolean wml = accept.indexOf("text/vnd.wap.wml") != -1;
		boolean blackberry = userAgent.indexOf("blackberry") != -1;
		boolean html = accept.indexOf("text/html") != -1
				|| accept.indexOf("*/*") != -1;
		boolean isWap = false;
		boolean isBlackBerry = false;
		if (wml && !html) {
			mimetype = "text/vnd.wap.wml";
			isWap = true;
		} else if (blackberry) {
			mimetype = "application/xhtml+xml";
			isBlackBerry = true;

		} else if (html) {
			mimetype = "text/html; charset=iso-8859-1";
		}
		response.setContentType(mimetype);

		
		try {

			request.setAttribute("item", "1");
			request.setAttribute("tipoOferta", "detalle");
			ModelAndView modelAndView=new ModelAndView();
			getServletContext().getRequestDispatcher("/inicio.jsp")
					.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("item", "1");
			getServletContext().getRequestDispatcher("/index.jsp").forward(
					request, response);
		}

	}

}

