package pe.com.claro.website.app.domain;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Sms extends BaseCommandTO {
	
	private int idLinea;
	private String dateRegister;
	private String codeSms;
	private int state;
	
	
	public Sms(int numberSms, int numberLine, String dateRegister,
			String codeSms, int state) {
		super();
		this.dateRegister = dateRegister;
		this.codeSms = codeSms;
		this.state = state;
	}
	
	public Sms(){}


	public String getDateRegister() {
		return dateRegister;
	}


	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}


	public String getCodeSms() {
		return codeSms;
	}


	public void setCodeSms(String codeSms) {
		this.codeSms = codeSms;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	
}
