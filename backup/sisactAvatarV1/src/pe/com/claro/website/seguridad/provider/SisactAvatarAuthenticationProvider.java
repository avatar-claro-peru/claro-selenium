package pe.com.claro.website.seguridad.provider;

import java.security.NoSuchAlgorithmException;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.claro.website.seguridad.domain.Usuario;
import pe.com.claro.website.seguridad.encriptacion.HashPassWord;
import pe.com.claro.website.seguridad.service.UsuarioService;

public class SisactAvatarAuthenticationProvider extends DaoAuthenticationProvider {
	private static Log log = LogFactory.getLog(SisactAvatarAuthenticationProvider.class);

	private UsuarioService serviceUsuario;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

		log.info(authentication.getPrincipal().toString());
		Usuario usuario = (Usuario) userDetails;
		log.info("usuario" + usuario);

		if (!validarUsuarioAlumno(userDetails, authentication)) {
			throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), isIncludeDetailsObject() ? userDetails : null);
		} else {
			// si tiene las credenciales adecuadas no hay problema no se
			// hace nada ;)
		}
	}

	/**
	 * Método que va a validar si el usuario tiene las credenciales adecuadas
	 * 
	 * @param userDetails
	 *            : usuario que viene de la bbdd local
	 * @param authentication
	 *            : usuario que viene del formulario
	 * @return
	 */
	private boolean validarUsuarioAlumno(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) {

		boolean res = false;
		try {
			res = findByUsuario(authentication.getPrincipal().toString(), authentication.getCredentials().toString());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (res) {
			log.info("entro");
			return true;
		} else {
			log.info("no entro");
			return false;
		}

		/*
		 * if(authentication.getPrincipal().toString().equals("jorge") &&
		 * authentication.getCredentials().toString().equals("admin")){ return
		 * true; } else { return false; }
		 */
	}

	private boolean findByUsuario(String username, String passwordInput) throws NoSuchAlgorithmException {
		HashPassWord hashPWD = new HashPassWord();
		Usuario usuario = getServiceUsuario().findByNombre(new Usuario(username));

		if (usuario != null) {
			String claveMd5 = usuario.getPassword();
			String permisoHash = "";
			String dos = hashPWD.obtainSaltString(claveMd5);
			log.info("hashPWD.obtainSaltString(claveMd5): " + dos);
			permisoHash = hashPWD.passWord(passwordInput, dos);
			log.info("Persmiso Hash:" + permisoHash);
			if (permisoHash.equals(claveMd5)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public UsuarioService getServiceUsuario() {
		return serviceUsuario;
	}

	public void setServiceUsuario(UsuarioService serviceUsuario) {
		this.serviceUsuario = serviceUsuario;
	}

}
