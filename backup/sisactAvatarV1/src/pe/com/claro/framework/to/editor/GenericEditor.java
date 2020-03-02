package pe.com.claro.framework.to.editor;

import java.beans.PropertyEditorSupport;

import pe.com.claro.framework.common.GenericUtil;

public class GenericEditor<T> extends PropertyEditorSupport {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(GenericUtil.instanciarGenericClass(getClass()));
	}

}