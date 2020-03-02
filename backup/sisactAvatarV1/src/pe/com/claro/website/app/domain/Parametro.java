package pe.com.claro.website.app.domain;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Parametro extends BaseCommandTO {

	private Integer id;
	private String nombre;
	private String valor;
	private String estado;
	private String descripcion;

	
	public Parametro(Integer id, String nombre, String valor, String estado, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public Parametro() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoDescripcion() {

		switch (new Integer(estado)) {
		case 1:
			return "Activo";
		default:
			return "Inactivo";
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
