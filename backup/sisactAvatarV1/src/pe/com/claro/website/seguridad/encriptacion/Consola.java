package pe.com.claro.website.seguridad.encriptacion;

import java.security.NoSuchAlgorithmException;

public class Consola {
	public static void main(String[] args) {
	
		try {
		HashPassWord hashPWD = new HashPassWord();
		
		for (int i = 0; i < 4; i++) {	
		
			System.out.println("PRUEBA "+(i+1));
			String claveInicial="aleon";
			
		    String claveMd5Inicial = hashPWD.passWord(claveInicial, hashPWD.getSaltString());
		    System.out.println("Clave ingresada: "+claveInicial+" Clave encriptada: "+claveMd5Inicial);
		    
		    
			String claveMd5=claveMd5Inicial;
			String permisoHash="";
			String dos=hashPWD.obtainSaltString(claveMd5);
			System.out.println("hashPWD.obtainSaltString(claveMd5): "+dos);
			permisoHash = hashPWD.passWord("aleon", dos);
			System.out.println("Persmiso Hash:"+permisoHash);
			
				if (permisoHash.equals(claveMd5)) {
					System.out.println("Clave Correcta");
				}
				else {
					System.out.println("Clave no correcta");
				}
			
		}
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
