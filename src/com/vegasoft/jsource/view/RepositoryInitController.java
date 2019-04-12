package com.vegasoft.jsource.view;

import com.vegasoft.jsource.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.ToolBar;

public class RepositoryInitController extends BaseController {
	@FXML private ToolBar toolbar;
	
	public RepositoryInitController() {
		super();
	}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	@FXML
	private void initialize() { }

	@Override
	public void onControllerLoadEnd() {
		toolbar.prefWidthProperty().bind(MainApp.getInstance().getPrimaryStage().widthProperty());
	}
	
}
