package pe.com.claro.framework.common;

import java.util.StringTokenizer;

public class General {

	public static String getNombreClase(String nombre) {

		StringTokenizer tokenizer = new StringTokenizer(nombre, ".");
		String parte=null;
		while (tokenizer.hasMoreTokens()) {
			parte= tokenizer.nextToken();
		}
		return parte;
	}
}
