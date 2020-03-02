package pe.com.claro.website.app.domain;

import java.util.Set;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class TopeConsumo extends BaseCommandTO{
	private String topeEstado;
	private String servCodigo;
	private String servDesc;
	private String nombre;
	private String planesAsociados;
	private Set<TipoPlan> listaPlanesAsociados;
	
	public TopeConsumo() {
	}

	public TopeConsumo(	Integer idTopeConsumo,
						String topeEstado,
						String servCodigo,
						String servDesc
						) {
		super();
		this.setId(idTopeConsumo);
		this.topeEstado = topeEstado;
		this.servCodigo = servCodigo;
		this.servDesc = servDesc;
	}

	public String getTopeEstado() {
		return topeEstado;
	}

	public void setTopeEstado(String topeEstado) {
		this.topeEstado = topeEstado;
	}

	public String getServCodigo() {
		return servCodigo;
	}

	public void setServCodigo(String servCodigo) {
		this.servCodigo = servCodigo;
	}

	public String getServDesc() {
		return servDesc;
	}

	public void setServDesc(String servDesc) {
		this.servDesc = servDesc;
	}

	public String getDescriptionTopeEstado(){
		
		if(getTopeEstado().equals("1")){
			return "Tope de consumo seleccionable";
		} else if(getTopeEstado().equals("2")){			
			return "Otro";
		}else if(getTopeEstado().equals("3")){			
			return "Tope de consumo por defecto";
		}else {
			return "Código no válido";
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the planesAsociados
	 */
	public String getPlanesAsociados() {
		return planesAsociados;
	}

	/**
	 * @param planesAsociados the planesAsociados to set
	 */
	public void setPlanesAsociados(String planesAsociados) {
		this.planesAsociados = planesAsociados;
	}

	/**
	 * @return the listaPlanesAsociados
	 */
	public Set<TipoPlan> getListaPlanesAsociados() {
		return listaPlanesAsociados;
	}

	/**
	 * @param listaPlanesAsociados the listaPlanesAsociados to set
	 */
	public void setListaPlanesAsociados(Set<TipoPlan> listaPlanesAsociados) {
		this.listaPlanesAsociados = listaPlanesAsociados;
	}
		
}