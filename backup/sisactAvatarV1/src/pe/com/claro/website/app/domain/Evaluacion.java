package pe.com.claro.website.app.domain;

import pe.com.claro.website.seguridad.domain.BaseCommandTO;

public class Evaluacion extends BaseCommandTO {

	private Integer id;
	private String ordenId;
	private String secuencia;
	private String estado;
	private String flagErrorInterno;
	private String estadoCantidadLineas;
	private String estadoSecPendiente;
	private String estadoConsultaPrevia;
	private String msgConsultaPrevia;
	private String tipoOperacion;
	private String idPadre;
	private String estadoRenovacion;
	/* lsoto: 17-07-19: Incluir el campo tipo_venta en el objeto EvalucionTO: INICIO */
	private Integer tipo_venta;
	//lsoto: 18-07-19: Variables que se usan para guardar el resultado de la evaluación postapgo
	private Integer codeResponse;
	private Integer flagCambioCampana;
	private Integer codigoPreEval;
	private String codCampana;
	private String codigoLP;
	private Integer cantidadDeAplicacionesRenta;
	private String cuotaInicial;
	private String valorCuota;
	private String valorEquipo;
	/* lsoto: 17-07-19: Incluir el campo tipo_venta en el objeto EvalucionTO: FIN */
	//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO */
	private String cuotainicial_tv;
	private String valorcuota_tv;
	private String valorequipo_tv;
	private String modalidadventa;
	//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN */
	
	//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO
	private String listaprecios;
	private String campania;
	//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN	
	
	//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: INICIO
	private String codigoMaterialChip;
	private String codigoMaterialItem;
	//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: FIN
	
	//jcisneros_031219: Incluir el campo que soporte la descripcion del tope de consumo: INICIO
	private String descripcionTopeConsumo;
	//jcisneros_031219: Incluir el campo que soporte la descripcion del tope de consumo: FIN


	public Evaluacion(Integer id,
			String ordenId,
			String secuencia,
			String estado,
			String flagErrorInterno,
			String estadoCantidadLineas,
			String estadoSecPendiente,
			String estadoConsultaPrevia,
			String msgConsultaPrevia,
			String estadoRenovacion,
			String tipoOperacion,
			String idPadre,
			Integer tipo_venta,
			Integer codeResponse,
			Integer flagCambioCampana,
			Integer codigoPreEval,
			String codCampana,
			String codigoLP,
			Integer cantidadDeAplicacionesRenta,
			String cuotaInicial,
			String valorCuota,
			String valorEquipo,
			//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO */
			String cuotainicial_tv,
			String valorcuota_tv,
			String valorequipo_tv,
			String modalidadventa,
			//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN */
			
			//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO
			String listaprecios,
			String campania,
			//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN	
			
			//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: INICIO
			String codigoMaterialChip,
			String codigoMaterialItem
			//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: FIN
			) {
		super();
		this.id = id;
		this.ordenId = ordenId;
		this.secuencia = secuencia;
		this.estado = estado;
		this.flagErrorInterno = flagErrorInterno;
		this.estadoCantidadLineas = estadoCantidadLineas;
		this.estadoSecPendiente = estadoSecPendiente;
		this.estadoConsultaPrevia = estadoConsultaPrevia;
		this.msgConsultaPrevia = msgConsultaPrevia;
		this.estadoRenovacion = estadoRenovacion;
		this.tipoOperacion = tipoOperacion;
		this.idPadre = idPadre;
		/* lsoto: 19-07-19: Incluir el campo tipo_venta en el objeto Evalucion: INICIO */
		this.tipo_venta = tipo_venta;
		this.codeResponse = codeResponse;
		this.flagCambioCampana = flagCambioCampana;
		this.codigoPreEval = codigoPreEval;
		this.codCampana = codCampana;
		this.codigoLP = codigoLP;
		this.cantidadDeAplicacionesRenta = cantidadDeAplicacionesRenta;
		this.cuotaInicial = cuotaInicial;
		this.valorCuota = valorCuota;
		this.valorEquipo = valorEquipo;
		/* lsoto: 19-07-19: Incluir el campo tipo_venta en el objeto Evalucion: FIN */
		
		//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO */
		this.cuotainicial_tv = cuotainicial_tv;
		this.valorcuota_tv = valorcuota_tv;
		this.valorequipo_tv = valorequipo_tv;
		this.modalidadventa = modalidadventa;
		//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN */
		
		//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO
		this.listaprecios = listaprecios;
		this.campania = campania;
		//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN	
		
		//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: INICIO
		this.codigoMaterialChip = codigoMaterialChip;
		this.codigoMaterialItem = codigoMaterialItem;
		//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: FIN
	}



	public String getTipoOperacion() {
		return tipoOperacion;
	}



	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}



	public String getIdPadre() {
		return idPadre;
	}



	public void setIdPadre(String idPadre) {
		this.idPadre = idPadre;
	}



	public String getEstadoRenovacion() {
		return estadoRenovacion;
	}



	public void setEstadoRenovacion(String estadoRenovacion) {
		this.estadoRenovacion = estadoRenovacion;
	}



	public Evaluacion() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(String ordenId) {
		this.ordenId = ordenId;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
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

	public String getTipoOperacionDescripcion() {

		switch (new Integer(tipoOperacion)) {
		case 3:
			return "Renovacion";
		case 2:
			return "Portabilidad";
		default:
			return "Ninguno";
		}
	}
	
	
	public String getFlagErrorInterno() {
		return flagErrorInterno;
	}

	public void setFlagErrorInterno(String flagErrorInterno) {
		this.flagErrorInterno = flagErrorInterno;
	}

	public String getEstadoCantidadLineas() {
		return estadoCantidadLineas;
	}

	public void setEstadoCantidadLineas(String estadoCantidadLineas) {
		this.estadoCantidadLineas = estadoCantidadLineas;
	}

	public String getEstadoSecPendiente() {
		return estadoSecPendiente;
	}

	public void setEstadoSecPendiente(String estadoSecPendiente) {
		this.estadoSecPendiente = estadoSecPendiente;
	}

	public String getEstadoConsultaPrevia() {
		return estadoConsultaPrevia;
	}

	public void setEstadoConsultaPrevia(String estadoConsultaPrevia) {
		this.estadoConsultaPrevia = estadoConsultaPrevia;
	}

	public String getMsgConsultaPrevia() {
		return msgConsultaPrevia;
	}

	public void setMsgConsultaPrevia(String msgConsultaPrevia) {
		this.msgConsultaPrevia = msgConsultaPrevia;
	}

	public Integer getTipo_venta() {
		return tipo_venta;
	}

	public void setTipo_venta(Integer tipo_venta) {
		this.tipo_venta = tipo_venta;
	}

	/* lsoto: 18-07-19: Campos que se utilizarán para guardar la respuesta de la evaluación postpago del servicio dummie: INICIO */

	public Integer getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(Integer codeResponse) {
		this.codeResponse = codeResponse;
	}

	public Integer getFlagCambioCampana() {
		return flagCambioCampana;
	}

	public void setFlagCambioCampana(Integer flagCambioCampana) {
		this.flagCambioCampana = flagCambioCampana;
	}

	public Integer getCodigoPreEval() {
		return codigoPreEval;
	}

	public void setCodigoPreEval(Integer codigoPreEval) {
		this.codigoPreEval = codigoPreEval;
	}

	public String getCodCampana() {
		return codCampana;
	}

	public void setCodCampana(String codCampana) {
		this.codCampana = codCampana;
	}

	public String getCodigoLP() {
		return codigoLP;
	}

	public void setCodigoLP(String codigoLP) {
		this.codigoLP = codigoLP;
	}

	public Integer getCantidadDeAplicacionesRenta() {
		return cantidadDeAplicacionesRenta;
	}

	public void setCantidadDeAplicacionesRenta(Integer cantidadDeAplicacionesRenta) {
		this.cantidadDeAplicacionesRenta = cantidadDeAplicacionesRenta;
	}

	public String getCuotaInicial() {
		return cuotaInicial;
	}

	public void setCuotaInicial(String cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public String getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(String valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getValorEquipo() {
		return valorEquipo;
	}

	public void setValorEquipo(String valorEquipo) {
		this.valorEquipo = valorEquipo;
	}
	
	/* lsoto: 18-07-19: Campos que se utilizarán para guardar la respuesta de la evaluación postpago del servicio dummie: FIN */
	
	//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: INICIO */
	
	public String getCuotainicial_tv() {
		return cuotainicial_tv;
	}



	public void setCuotainicial_tv(String cuotainicial_tv) {
		this.cuotainicial_tv = cuotainicial_tv;
	}



	public String getValorcuota_tv() {
		return valorcuota_tv;
	}



	public void setValorcuota_tv(String valorcuota_tv) {
		this.valorcuota_tv = valorcuota_tv;
	}



	public String getValorequipo_tv() {
		return valorequipo_tv;
	}



	public void setValorequipo_tv(String valorequipo_tv) {
		this.valorequipo_tv = valorequipo_tv;
	}



	public String getModalidadventa() {
		return modalidadventa;
	}
	
	public String getModalidadVentaNombre(){
		
		if(getModalidadventa() == null){
			return "No definido";
		} else if(getModalidadventa().equals("1")){			
			return "Línea Nueva";
		}else if(getModalidadventa().equals("2")){
			return "Portabilidad";
		}else if(getModalidadventa().equals("3")){
			return "Renovación";
		}else {
			return "No definido";
		}
	}
	
	public String getNombreTipoVenta() {

		if(getTipo_venta() == 1){
			return "Prepago";
		} else{
			return "Postpago";
		}
	}
	
	public void setModalidadventa(String modalidadventa) {
		this.modalidadventa = modalidadventa;
	}
	//lsoto: 08-08-19: Incluir los campos que guardarán la cuota inicial, precio por cuota y precio total de tv: FIN */
	
	//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: INICIO
	public String getListaprecios() {
		return listaprecios;
	}

	public void setListaprecios(String listaprecios) {
		this.listaprecios = listaprecios;
	}

	public String getCampania() {
		return campania;
	}

	public void setCampania(String campania) {
		this.campania = campania;
	}

	//lsoto: 09-08-19: Inclusión de la visualización del la lista de precios y campaña en el formulario de edición de evaluaciones: FIN	
	
	//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: INICIO
	public String getCodigoMaterialChip() {
		return codigoMaterialChip;
	}
	
	public void setCodigoMaterialChip(String codigoMaterialChip) {
		this.codigoMaterialChip = codigoMaterialChip;
	}



	public String getCodigoMaterialItem() {
		return codigoMaterialItem;
	}



	public void setCodigoMaterialItem(String codigoMaterialItem) {
		this.codigoMaterialItem = codigoMaterialItem;
	}
	//lsoto: 23-09-19: Incluir el campo que soporte el número de chip en el servicio evaluar postpago: FIN


	/**jcisneros_031219: atributo para la descripcion de tope de consumo. Inicio*/
	/**
	 * @return the descripcionTopeConsumo
	 */
	public String getDescripcionTopeConsumo() {
		return descripcionTopeConsumo;
	}



	/**
	 * @param descripcionTopeConsumo the descripcionTopeConsumo to set
	 */
	public void setDescripcionTopeConsumo(String descripcionTopeConsumo) {
		this.descripcionTopeConsumo = descripcionTopeConsumo;
	}
	/**jcisneros_031219: atributo para la descripcion de tope de consumo. Fin*/
	
}
