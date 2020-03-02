package pe.com.claro.framework.common;

public class ConstantesSisactAvatarMap {

	/* MAPEO PARA LOS GENERICOS */
	public final static String LIST = "list";
	public final static String INSERT = "insert";
	public final static String DELETE = "delete";
	public final static String UPDATE = "update";
	public final static String SELECTBYID = "selectByID";
	public final static String SELECTBYNAME = "selectByName";
	public final static String SELECTBYPEDIDOID = "selectByPedidoId";
	
	//jcisneros_031219: se agrega metodo para buscar por campos. Inicio
	public final static String FINDBYFIELD = "findByField";
	public final static String LISTAR_BY_TOPE_CONSUMO_ID = "listarByTopeConsumoID";
	//jcisneros_031219: se agrega metodo para buscar por campos. FIn
	/* CLIENTE */
	public final static String LIST_FOR_NAME = "listForName";
	public final static String LIST_FOR_TIPO_NUMERO = "listForTipoNumero";
	public final static String LIST_FOR_NAME_PARAM = "listForNameParam";
	public final static String LIST_BY_ID_LINEA = "listByLineaId";

	public final static String DELETE_BY_USUARIO_ID = "deleteByUsuarioId";
	public final static String DELETE_BY_PERFIL_ID = "deleteByPerfilId";

	/* PERFILES */
	public final static String LIST_BY_ID_USUARIO = "selectUsuarioPerfil";

	public final static String LIST_BY_ID_PERFIL = "selectPerfilOpcion";
	
	//lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - INICIO
	public final static String LIST_BY_ID_TIPO_PLAN="selectTipoPLanTopeConsumo";
	public final static String DELETE_BY_TOPE_CONSUMO_ID="eliminarByTopeConsumoId";
	//lsoto: 23-11-19 : Implementación del mantenimiento de planes y asociación con los topes de consumo - FIN
	
	//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - INICIO
	public final static String LIST_DETALLE_ORDEN_BY_ID_ORDEN="selectDetalleOrdenxIDOrden";
	//lsoto: 29-01-20 : Implementación del historial de SyncOrder por orden - FIN 
	
	/* LINEAS */
	public final static String LIST_LINES_LINE = "listForName";
	public final static String LIST_LINES = "listLine";
	public final static String INSERT_LINES = "insertLine";
	public final static String UPDATE_LINES = "updateLine";
	public final static String DELETE_LINES = "deleteLine";
	/* lsoto: 29:06:19: query para validar si la línea existe: INICIO*/
	public final static String VALIDATE_LINE_EXISTENCE = "validateLine";
	/* lsoto: 29:06:19: query para validar si la línea existe: FIN*/

	public final static String SELECTBYIDORDENDETALLE = "selectByIdOrdenDetalle";
	
	/* Tipo Personal */
	public final static String SET_ADITIONAL_MODALIDAD = "Modalidad.selectByID";
	public final static String SET_SELECT_BYIDDOBLE = "selectByIdDoble";

	/* ParÃ¡metro */
	public final static String LIST_FIELDS_BY_PARAM = "listFieldsByParam";
	public final static String SELECT_ONE_FIELD = "selectOneField";
	public final static String INSERT_FIELD = "insertField";
	public final static String UPDATE_FIELD = "updateField";
	public final static String DELETE_FIELD = "deleteField";
	public final static String LIST_ALL = "listarTodo";
	/* ParÃ¡metro Detalle */
	public final static String SELECT_VALUES_FIELDS = "selectValuesFields";
	public final static String INSERT_VALUES = "insertValue";
	public static final String DELETE_VALUES = "deleteValues";
	
	/*Solicitud*/
	public final static String SELECTBYDNI = "selectByDNI";
	public final static String SELECTBYNROCEL = "selectByCell";
}