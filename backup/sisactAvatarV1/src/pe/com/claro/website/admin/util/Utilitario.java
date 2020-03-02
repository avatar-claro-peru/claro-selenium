package pe.com.claro.website.admin.util;

public class Utilitario {
	
	public static String getNombreArchivo(String path){
		// files/adminArchivos/archivos/12-01-2009-17-38-14CONVOCATORIA.doc
		String nombreArchivo=null;
		if (path!=null) {
			nombreArchivo=getParteString(path, "/");
		}
	
		return nombreArchivo;
	}
	
	public static String getExtensionArchivo(String nom){
		String exten=null;

		int can=nom.length();
		int pos=0;
		for (int i = 0; i < nom.length(); i++) {
			String parte=nom.substring(i, i+1);
			if (parte.compareTo(".")==0) {
				pos=i;
				break;
			}
		}
		exten=nom.substring(pos+1, can);
		return exten;
	}
	
	private static  String getParteString(String string,String separador){
		String parte=null;
		if (string!=null && separador!=null) {
				String partes[]=string.split(separador);
				parte=partes[partes.length-1];	
			}
		return parte;
	}

}
