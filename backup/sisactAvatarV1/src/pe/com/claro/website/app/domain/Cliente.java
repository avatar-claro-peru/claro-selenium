package pe.com.claro.website.app.domain;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Cliente extends BaseCommandTO{

	private String nombre;
	
	private Integer tipo_doc;

	private String num_doc;
	
	private String correo;
	
	private String estado;
	
	/* lsoto: 04-07-19: Agregamos el nuevo atributo para la pre-evaluación: INICIO */
	private int pre_evaluacion;
	/* lsoto: 04-07-19: Agregamos el nuevo atributo para la pre-evaluación: FIN */

	public Cliente() {
	}

	/* lsoto: 04-07-19: Agregamos el nuevo atributo para la pre-evaluación: INICIO */
	public Cliente(Integer id_cliente, String nombre, Integer tipo_doc,
			String num_doc, String correo, String estado, int pre_evaluacion) {
		super();
		this.setId(id_cliente);
		this.nombre = nombre;
		this.tipo_doc = tipo_doc;
		this.num_doc = num_doc;
		this.correo = correo;
		this.estado = estado;
		this.pre_evaluacion = pre_evaluacion;
	}
	/* lsoto: 04-07-19: Agregamos el nuevo atributo para la pre-evaluación: INICIO */
	
	/* lsoto: 04-07-19: Agregamos el nuevo atributo para la pre-evaluación: INICIO */
	public int getPre_evaluacion() {
		return pre_evaluacion;
	}
	
	public void setPre_evaluacion(int pre_evaluacion) {
		this.pre_evaluacion = pre_evaluacion;
	}
	
	public String getResultadoPre_evaluacion() {
		
		switch (new Integer(pre_evaluacion)) {
		case 1:
			return "Error en servicio de Pre-evaluación (1)";
		case 2:
			return "Pre-evaluación exitosa (2)";
		case 3:
			return "Pre-evaluación rechazada por deuda (3)";
		default:
			return "Pre-evaluación rechazada por otros motivos (4)";
			
		}
	}
	
	/* lsoto: 04-07-19: Agregamos el nuevo atributo para la pre-evaluación: FIN */
	
	public Cliente(String nombre) {
		setNombre(nombre);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(Integer tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public String getNum_doc() {
		return num_doc;
	}

	public void setNum_doc(String num_doc) {
		this.num_doc = num_doc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
	
	public String getTipoDocumentoDescripcion() {
		
		switch (new Integer(tipo_doc)) {
		case 2:
			return "DNI";
		case 3:
			return "CE";
		case 4:
			return "RUC";
		default:
			return "Pasaporte";
		}
	}

}