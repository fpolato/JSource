package com.vegasoft.jsource.core;

import java.io.IOException;

import com.vegasoft.jsource.MainApp;

import javafx.fxml.FXMLLoader;

/**
 * Extends the {@link FXMLLoader} standard class and handle the correct
 * {@link BaseController} initialization.
 * This class is fundamental to guarantee the correct {@link MainApp}s 
 * working as singleton.
 * @author fabio.polato
 *
 */
public class JSourceFXMLLoader extends FXMLLoader {
	
	@Override
	public <T> T load() throws IOException {
		T obj = super.load();
		BaseController controller = this.getController();
		if(controller != null) {
			controller.onControllerLoadEnd();
		}
		return obj;
	}
}
