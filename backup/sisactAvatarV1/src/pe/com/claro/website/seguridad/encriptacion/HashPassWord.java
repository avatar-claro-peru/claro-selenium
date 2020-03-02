/* 
 * Autor: Lucio Morales Ortega
 * 
 */

package pe.com.claro.website.seguridad.encriptacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import cryptix.util.core.Hex;

public class HashPassWord {
	
	SecureRandom _random;
	MessageDigest _digest;
	byte _salt[];

	public HashPassWord() throws NoSuchAlgorithmException {
		_random = SecureRandom.getInstance("SHA1PRNG");
		_digest = MessageDigest.getInstance("SHA-1");
		_salt = new byte[2];
	}

	String dumpHexString(byte hash[]) {
		StringBuffer ret = new StringBuffer();
		String temp = Hex.dumpString(hash);
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) != ' ' && temp.charAt(i) != '\n')
				ret.append(temp.charAt(i));
		}
		return ret.toString();
	}

	public String getSaltString() {
		synchronized (_random) {
			_random.nextBytes(_salt);
		}
		return dumpHexString(_salt);
	}

	/**
	 * Obtiene la semilla de la clave para encriptar.
	 * 
	 * @return String
	 * @param permiso
	 */
	public String obtainSaltString(String permiso) {
		int len = permiso.length();
		return permiso.substring(len - 4, len);
	}

	public String getSaltString(String hashedString) {
		return hashedString.substring(hashedString.length() - 4);
	}

	public String passWord(String pass, String salt) {
		String pw = String.valueOf(pass) + String.valueOf(salt);
		byte hash[] = null;
		synchronized (_digest) {
			_digest.reset();
			_digest.update(pw.getBytes());
			hash = _digest.digest();
		}
		return String.valueOf(dumpHexString(hash)) + String.valueOf(salt);
	}

	/**
	 * M�todo para comprobar el correcto funcionamiento del m�todo passWord(a,b)
	 * de la clase.
	 */
	public static void main(String args[]) throws NoSuchAlgorithmException {
		HashPassWord hashPWD = new HashPassWord();
		try {
			if (args[1] != null || args[1] == "")
				System.out.println(hashPWD.passWord(String.valueOf(args[0]),
						String.valueOf(args[1])));
			else
				System.out.println(hashPWD.passWord(String.valueOf(args[0]),
						hashPWD.getSaltString()));
		} catch (Exception e) {
			System.out.println(hashPWD.passWord(String.valueOf(args[0]),
					hashPWD.getSaltString()));
		}
	}
}