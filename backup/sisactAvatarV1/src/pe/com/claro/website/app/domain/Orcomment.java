package pe.com.claro.website.app.domain;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Orcomment extends BaseCommandTO {

	private Integer id;
	private String idOrden;
	private String keyComment;
	private String valueComment;

	public Orcomment(Integer id, String idOrden, String keyComment, String valueComment) {
		super();
		this.id = id;
		this.idOrden = idOrden;
		this.keyComment = keyComment;
		this.valueComment = valueComment;
	}

	public Orcomment() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the idOrden
	 */
	public String getIdOrden() {
		return idOrden;
	}

	/**
	 * @param idOrden
	 *            the idOrden to set
	 */
	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	/**
	 * @return the keyComment
	 */
	public String getKeyComment() {
		return keyComment;
	}

	/**
	 * @param keyComment
	 *            the keyComment to set
	 */
	public void setKeyComment(String keyComment) {
		this.keyComment = keyComment;
	}

	/**
	 * @return the valueComment
	 */
	public String getValueComment() {
		return valueComment;
	}

	/**
	 * @param valueComment
	 *            the valueComment to set
	 */
	public void setValueComment(String valueComment) {
		this.valueComment = valueComment;
	}

}
