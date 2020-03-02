/**
 * 
 */
package pe.com.claro.website.seguridad.domain;

import java.util.Set;

import org.acegisecurity.GrantedAuthority;


/**
 * @author lucio
 *
 */
public class Opcion extends BaseCommandTO implements  GrantedAuthority  {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;
	
	private String estado;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private String descripcion;

	private Set<Perfil> perfiles;

	public Opcion() {
	}

	public Opcion(Integer codigo) {
		setId(codigo);
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	/* (non-Javadoc)
	 * @see pe.edu.uni.base.domain.BaseDomain#getId()
	 */
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see pe.edu.uni.base.domain.BaseDomain#setId(java.lang.Integer)
	 */
	public void setId(Integer codigo) {
		this.id = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.acegisecurity.GrantedAuthority#getAuthority()
	 */
	public String getAuthority() {
		return this.nombre;
	}
	
	public String getEstadoDescripcion() {

		switch (new Integer(estado)) {
		case 1:
			return "Activo";
		default:
			return "Inactivo";
		}
	}
}
