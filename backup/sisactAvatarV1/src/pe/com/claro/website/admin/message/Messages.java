package pe.com.claro.website.admin.message;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "pe.com.claro.website.admin.message.messages";//$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static Integer getInteger(String key) {

		try {
			return Integer.parseInt(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException e) {
			return 0;
		}
	}

	public static String getString(String key) {

		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
