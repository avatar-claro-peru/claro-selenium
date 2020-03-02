package pe.com.claro.framework.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericUtil {

	/**
	 * Devuelve el primer generico de la clase
	 * 
	 * @param clazz
	 *            La clase donde se buscaran los genericos
	 * @return El primer generico, o <code>null</code> si no puede ser
	 *         determinado
	 */
	public static Class getGenericClass(Class clazz) {
		return getGenericClass(clazz, 0);
	}

	/**
	 * Devuelve la clase generica segun el indice indicado
	 * 
	 * @param clazz
	 *            La clase donde se buscaran los genericos
	 * @param index
	 *            El indice del generico que estamos buscando
	 * @return
	 */
	public static Class getGenericClass(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType)
					.getActualTypeArguments();

			if ((params != null) && (params.length >= (index - 1))) {
				return (Class) params[index];
			}
		}
		return null;
	}
	
	/**
	 * Instancia una clase generica, devuelve null si la clase no se 
	 * puede instanciar e.j. si es una interface
	 * 
	 * @param clazz
	 * @return
	 */
	public static Object instanciarGenericClass(Class clazz){
		try {
			return getGenericClass(clazz).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
