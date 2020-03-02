package pe.com.claro.website.admin.message;


/**
 * @author lucio
 *
 */
public class Constante {
	
	/*  GENERICOS SERVICE  */
	public static final String KEY_DELETE_SATISFACTORIO=Messages.getString("sussesDelete");
	public static final String KEY_DELETE_ERROR=Messages.getString("notSussesDelete");
	public static final String KEY_UPDATE_SATISFACTORIO=Messages.getString("sussesUpdate");
	public static final String KEY_UPDATE_ERROR=Messages.getString("notSussesUpdate");
	public static final String KEY_REGISTRAR_SATISFACTORIO=Messages.getString("sussesGuardar");
	public static final String KEY_REGISTRAR_ERROR=Messages.getString("notSussesGuardar");
	/*  lsoto:29-06-19: se incluye una variable en caso la validación de la existencia de la línea no se realice: INICIO  */
	public static final String KEY_VALIDAR_EXISTENCIA_LINEA_ERROR=Messages.getString("notSussesValidarExisteNumero");
	/*  lsoto:29-06-19: se incluye una variable en caso la validación de la existencia de la línea no se realice: INICIO  */
	/*  GENERICOS SERVICE  */
	public static final String KEY_LISTAR_ERROR=Messages.getString("notSussesListar");
	public static final String KEY_SELECT_BYID=Messages.getString("notSussesSelectById");
	
	
	public static final String KEY_TIPO_MENSAJE_ERROR=Messages.getString("mensajeError");
	public static final String KEY_TIPO_MENSAJE_EXITO=Messages.getString("mensajeExito");
	public static final Integer KEY_RETORNO_VALIDO=Messages.getInteger("retornoValido");
	
	/*PARA EL ENVIO DE CORREOS*/
	public static final String HOST_SMTP=Messages.getString("hostSmtp");
	public static final String SERDER_ADDRES=Messages.getString("senderAddres");
	public static final String TO_ADDRESS=Messages.getString("toAddress");
	public static final String CC_ADDRESS=Messages.getString("ccAddress");
	public static final String BCC_ADDRESS=Messages.getString("bccAddress");
	public static final String SUBJECT=Messages.getString("subject");
	public static final String SUBJECT_REGISTRAME=Messages.getString("subjectRegistrame");
	public static final String MENSAJE =Messages.getString("mensaje");
	public static final String MENSAJE_EXITO_ENVIOCORREO =Messages.getString("mensajeExitoEnvioCorreo");
	public static final String MENSAJE_CORREO_NOEXISTE =Messages.getString("mensajeCorreoNoExiste");
	public static final String MENSAJE_ENVIO_PASSWORD =Messages.getString("mensajeEnvioPassword");
	public static final String MENSAJE_ENVIO_USUARIO=Messages.getString("mensajeEnvioUsuario");
	
	/* PARA LA ELIMINACION DE UN FILE  */
	
	public static final String MENSAJE_BORRADO_SATISFACTORIO=Messages.getString("mensajeBorradoSatisfactorio");
	public static final String MENSAJE_NO_SE_PUEDE_BORRAR=Messages.getString("mensajeNoSePuedeBorrar");
	public static final String MENSAJE_NOSE_ENCUENTRA_ARCHIVO=Messages.getString("mensajeNoseEncuentraArchivo");
	
	/* PARA LA SIBIDA DE FILE */
	public static final String FILE_SERVER=Messages.getString("fileServer");
	public static final String NO_SUSSES_FILE=Messages.getString("noSussesFile");
	public static final String RUTA_IMAGE_LOGO_PERSONAL=Messages.getString("rutaFileFotoPersonal");
	
	/* PARA LOS MENSAJES */
	public static final String SUSSES_NEW_CLIENTE=Messages.getString("sussesClienteNew");
	public static final String SUSSES_UPDATE_CLIENTE=Messages.getString("sussesClienteUpdate");
	
	/*SERVICIO WEB*/
	public static final String SUCCESSFULL_PROCESS_LOAD_STOK_PRECIOS=Messages.getString("successfullLoadStockPrecios");
	public static final String ERROR_PROCESS_LOAD_STOK_PRECIOS=Messages.getString("errorLoadStockPrecios");
	public static final Object ERROR_CONEXION = Messages.getString("errorConexion");
	public static final String ERROR_PROCESS_SYNC_ORDER=Messages.getString("errorSyncOrder");
	
   
	public final static String SI = "1";
	
	public final static String NO = "0";

}
