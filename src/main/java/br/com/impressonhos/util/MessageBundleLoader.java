package br.com.impressonhos.util;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Classe utilitária para realizar o carregamento do ResourceBundle carregado de acordo
 * com o Locale geral do sistema.
 * @author riccardof
 *
 */
public class MessageBundleLoader implements Serializable{
	
	private static final long serialVersionUID = 7928007027299438953L;

	public String MESSAGE_PATH = "br.com.impressonhos.resources.messages";

    private static ResourceBundle messages;

    private void init() throws Exception {
        Locale locale = Services.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        messages = ResourceBundle.getBundle(MESSAGE_PATH, locale);
    }

    /**
     * Retorna o valor internacionalizado de acordo com a chave informada.
     * @param key
     * @return
     */
    public String getMessage(String key){
        try {
        	init();
            return messages.getString(key);
        }
        catch (Exception e) {
            return key;
        }
    }
}
