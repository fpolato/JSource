package com.vegasoft.jsource.view;

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
	protected void onControllerLoadEnd() {
		toolbar.prefWidthProperty().bind(getMainApp().getPrimaryStage().widthProperty());
	}
	
}
