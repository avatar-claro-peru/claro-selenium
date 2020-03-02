package pe.com.claro.website.admin.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Consola {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		for (int i = 0; i < 10; i++) {
			System.out.println(GeneradorClave.getPasswordNew());
		}
		String palabra="DIASD";
		String palabraMiniscula=palabra.toLowerCase();
		System.out.println(palabraMiniscula);
		*/
		String email="lmounifiis@yahoo.com.mx";
		System.out.println("Email Inicial:"+email);
		email=email.replace("@", "#");
		System.out.println("Email Cambiado:"+email);
		email=email.replace("#", "@");
		System.out.println("Email Cambiado 2:"+email);
		//System.out.println(Utilitario.getExtensionArchivo("ejemplo.docs"));
		//IdiomaSelector idiomaSelector=new IdiomaSelector();

	}

	public  static void viewParametrosRequest(HttpServletRequest request) {
		Enumeration<String> parametros = request.getParameterNames();
		while (parametros.hasMoreElements()) {
			String elem = (String) parametros.nextElement();
			System.out.println("parametos:" + elem + "   valor:"
					+ request.getParameter(elem));
		}

		Enumeration<String> atributos = request.getAttributeNames();
		while (atributos.hasMoreElements()) {
			String elem = (String) atributos.nextElement();
			System.out.println("atributo:" + elem + "   valor:"
					+ request.getAttribute(elem));
		}
	}

}
