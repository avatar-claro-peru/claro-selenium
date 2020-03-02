/**
 * 
 */
package pe.com.claro.website.seguridad.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lucio
 * 
 */
public class Perfil extends BaseCommandTO {

	private Integer id;

	private String nombre;

	private String estado;

	private String descripcion;

	private String idUsuario;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	private Set<Opcion> opciones;

	private Set<Usuario> usuarios;

	public Perfil() {
	}

	public Perfil(Integer codigo) {
		setId(codigo);
	}

	/**
	 * @return the usuarios
	 */
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the opciones
	 */
	public Set<Opcion> getOpciones() {
		return opciones;
	}

	/**
	 * @param opciones
	 *            the opciones to set
	 */
	public void setOpciones(Set<Opcion> opciones) {
		this.opciones = opciones;
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

	/**
	 * @param ids
	 */
	private void guardarOpciones(Integer[] ids) {
		Set<Opcion> opciones = new HashSet<Opcion>();

		for (Integer id : ids) {
			opciones.add(new Opcion(id));
		}
		setOpciones(opciones);
	}

	/**
	 * @param ids
	 */
	public void crear(Integer[] ids) {
		guardarOpciones(ids);
	}

	/**
	 * @param ids
	 */
	public void actualizar(Integer[] ids) {
		guardarOpciones(ids);
	}

	/**
	 * @return
	 */
	public List<Integer> getIdOpciones() {
		List<Integer> ids = new ArrayList<Integer>();

		for (Opcion opcion : getOpciones()) {
			ids.add(opcion.getId());
		}

		return ids;
	}

	public String getEstadoDescripcion() {

		switch (new Integer(estado)) {
		case 1:
			return "Activo";
		default:
			return "Inactivo";
		}
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
}
