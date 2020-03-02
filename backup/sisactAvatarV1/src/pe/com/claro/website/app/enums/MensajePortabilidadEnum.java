package pe.com.claro.website.app.enums;

import java.util.ArrayList;
import java.util.List;

public enum MensajePortabilidadEnum {

	ERROR0(0,"Otro."),
	ERROR1(1,"Tienes una solicitud de Portabilidad en trámite. "),
	ERROR2(2,"Tu número ya ha sido portado."),
	ERROR3(3,"Tu número no pertenece al operador actual indicado. "),
	ERROR4(4,"Deben pasar 60 días calendario desde tu última Portabilidad. "),
	ERROR5(5,"Tu operador actual no responde. "),
	ERROR6(6,"Tu número no coincide con el tipo de servicio indicado(móvil, fijo)."),
	ERROR7(7,"Tu número tiene su servicio suspendido."),
	ERROR8(8,"Tu número no pertenece al operador indicado."),
	ERROR9(9,"Tu número no coincide con el número de documento de identidad o No eres el titular de la línea. "),
	ERROR10(10,"Tu número no coincide con la modalidad indicada(prepago, postago)."),
	ERROR11(11,"Debes estar al día en los pagos con tu actual operador."),
	ERROR12(12,"Ups algo se rompió , Vuelve a intentarlo en unos minutos.");
	
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
