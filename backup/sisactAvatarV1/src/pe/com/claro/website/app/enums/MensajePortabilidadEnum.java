package pe.com.claro.website.app.enums;

import java.util.ArrayList;
import java.util.List;

public enum MensajePortabilidadEnum {

	ERROR0(0,"Otro."),
	ERROR1(1,"Tienes una solicitud de Portabilidad en tr�mite. "),
	ERROR2(2,"Tu n�mero ya ha sido portado."),
	ERROR3(3,"Tu n�mero no pertenece al operador actual indicado. "),
	ERROR4(4,"Deben pasar 60 d�as calendario desde tu �ltima Portabilidad. "),
	ERROR5(5,"Tu operador actual no responde. "),
	ERROR6(6,"Tu n�mero no coincide con el tipo de servicio indicado(m�vil, fijo)."),
	ERROR7(7,"Tu n�mero tiene su servicio suspendido."),
	ERROR8(8,"Tu n�mero no pertenece al operador indicado."),
	ERROR9(9,"Tu n�mero no coincide con el n�mero de documento de identidad o No eres el titular de la l�nea. "),
	ERROR10(10,"Tu n�mero no coincide con la modalidad indicada(prepago, postago)."),
	ERROR11(11,"Debes estar al d�a en los pagos con tu actual operador."),
	ERROR12(12,"Ups algo se rompi� , Vuelve a intentarlo en unos minutos.");
	
	private final Integer id;
	private final String descripcion;
	
	private MensajePortabilidadEnum(final Integer id,final String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
	}

	public Integer getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	public static List<MensajePortabilidadEnum> listAll(){
		List<MensajePortabilidadEnum> msgPorta = new ArrayList<MensajePortabilidadEnum>();
		msgPorta.add(MensajePortabilidadEnum.ERROR0);
		msgPorta.add(MensajePortabilidadEnum.ERROR1);
		msgPorta.add(MensajePortabilidadEnum.ERROR2);
		msgPorta.add(MensajePortabilidadEnum.ERROR3);
		msgPorta.add(MensajePortabilidadEnum.ERROR4);
		msgPorta.add(MensajePortabilidadEnum.ERROR5);
		msgPorta.add(MensajePortabilidadEnum.ERROR6);
		msgPorta.add(MensajePortabilidadEnum.ERROR7);
		msgPorta.add(MensajePortabilidadEnum.ERROR8);
		msgPorta.add(MensajePortabilidadEnum.ERROR9);
		msgPorta.add(MensajePortabilidadEnum.ERROR10);
		msgPorta.add(MensajePortabilidadEnum.ERROR11);
		msgPorta.add(MensajePortabilidadEnum.ERROR12);
		return msgPorta;
	}

}
