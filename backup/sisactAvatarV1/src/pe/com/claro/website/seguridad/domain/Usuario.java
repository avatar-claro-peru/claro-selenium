/**
 * 
 */
package pe.com.claro.website.seguridad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;

/**
 * @author lucio
 * 
 */
public class Usuario extends BaseCommandTO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;
	
	private String estado;

	private Set<Perfil> perfiles;

	public Usuario() {
	}

	public Usuario(String username) {
		setUsername(username);
	}

	/**
	 * @return the perfiles
	 */
	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	/**
	 * @param perfiles
	 *            the perfiles to set
	 */
	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.edu.uni.base.domain.BaseDomain#getId()
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pe.edu.uni.base.domain.BaseDomain#setId(java.lang.Integer)
	 */
	public void setId(Integer codigo) {
		this.id = codigo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.acegisecurity.userdetails.UserDetails#getUsername()
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public List<Integer> getIdPerfiles() {
		List<Integer> ids = new ArrayList<Integer>();

		for (Perfil perfil : getPerfiles()) {
			ids.add(perfil.getId());
		}

		return ids;
	}

	public GrantedAuthority[] getAuthorities() {
		List<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();

		grantedAuthority.add(new GrantedAuthorityImpl("SYSTEM_USER"));
		for (Perfil perfil : getPerfiles()) {
			for (Opcion opcion : perfil.getOpciones()) {
				grantedAuthority.add(new GrantedAuthorityImpl(opcion.getAuthority()));
			}
		}

		return (GrantedAuthority[]) grantedAuthority.toArray(new GrantedAuthority[0]);

	}

	public boolean isAlumno() {
		for (Perfil perfil : getPerfiles())
			if (perfil.getNombre().equals("ALUMNO"))
				return true;

		return false;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public String getPerfilUsuario() {
		String perfil = "PERFIL :";
		Set<Perfil> perfiles = getPerfiles();
		for (Perfil perfil2 : perfiles) {
			perfil = perfil + " " + perfil2.getNombre();
		}

		return perfil;
	}

	/**
	 * @return
	 */
	public String getNameCompleto() {

		return this.username;
	}

	public String getEstado() {
		return estado;
	}
	
	public String getEstadoDescripcion() {
		
		switch (new Integer(estado)) {
		case 1:
			return "Activo";
		default:
			return "Inactivo";
		}
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
