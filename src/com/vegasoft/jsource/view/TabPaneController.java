package com.vegasoft.jsource.view;

import com.vegasoft.jsource.core.BaseController;
import com.vegasoft.jsource.exceptions.JSourceIOException;
import com.vegasoft.jsource.utils.NodeUtils;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;

public class TabPaneController extends BaseController {
	@FXML private TabPane tabPane;
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public TabPaneController() {
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
		initTabs();
	}
	
	private void initTabs() {
		// Create a new tab where RepositoryInit is loaded
		Tab repositoryInitTab = new Tab();
		repositoryInitTab.setText("New Repository");
		
//		FlowPane repositoryInit = (FlowPane) getMainApp().initRepositoryInit();
		try {
			FlowPane repositoryInit = (FlowPane) NodeUtils.initNode("RepositoryInit");
			repositoryInitTab.setContent(repositoryInit);
		} catch(JSourceIOException e) {
			e.printStackTrace();
		}
		
		tabPane.getTabs().add(repositoryInitTab);
	}
}
