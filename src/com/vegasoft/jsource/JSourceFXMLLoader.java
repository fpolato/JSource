package com.vegasoft.jsource;

import java.io.IOException;

import com.vegasoft.jsource.view.BaseController;

import javafx.fxml.FXMLLoader;

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
