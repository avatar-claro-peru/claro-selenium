package pe.com.claro.website.app.domain;

import java.util.Date;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Line extends BaseCommandTO {

	private String numberLine;
	private int idClient;
	private Date dateRegister;
	private Date dateUpdate;
	private int state;
	/* lsoto: 28-06-19: Agregar el atributo que guardará el tipo de venta: INICIO */
	private String selltype;
	/* lsoto: 28-06-19: Agregar el atributo que guardará el tipo de venta: FIN */
	private String modality;

	private String numberLineNew;

	public String getNumberLineNew() {
		return numberLineNew;
	}

	public void setNumberLineNew(String numberLineNew) {
		this.numberLineNew = numberLineNew;
	}
	
	/* lsoto: 28-06-19: Agregar el atributo que guardará el tipo de venta: INICIO */
	public Line(String numberLine, int idClient, Date dateRegister, Date dateUpdate, int state, String modality, String selltype) {
		super();
		this.numberLine = numberLine;
		this.idClient = idClient;
		// this.cliente = cliente;
		this.dateRegister = dateRegister;
		this.dateUpdate = dateUpdate;
		this.state = state;
		this.modality = modality;
		this.selltype = selltype;
	}
	/* lsoto: 28-06-19: Agregar el atributo que guardará el tipo de venta: FIN */
	
	public Line() {

	};	

	public String getNumberLine() {
		return numberLine;
	}

	public void setNumberLine(String numberLine) {
		this.numberLine = numberLine;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getModality() {
		return modality;
	}
	
	public void setModality(String modality) {
		this.modality = modality;
	}
	
	/* lsoto: 28-06-19: Agregar el atributo que guardará el tipo de venta: INICIO */
	
	public String getSelltype() {
		return selltype;
	}
	
	public void setSelltype(String selltype) {
		this.selltype = selltype;
	}	
	
	
	public String getTipoVenta() {
		
		if(getSelltype().equals("P")){
			return "Prepago";
		}else{			
			return "Postpago";
		}
	}

	/* lsoto: 28-06-19: Agregar el atributo que guardará el tipo de venta: FIN */

	public String getEstadoDescripcion() {
		
		switch (new Integer(getState())) {
		case 1:
			return "Activado";
		default:
			return "Bloqueado";
		}
	}
	
	public String getEstadoRenovacion() {
	
		if(getModality().equals("S")){
			return "Renovable";
		}else{			
			return "No Renovable";
		}
	}
}
