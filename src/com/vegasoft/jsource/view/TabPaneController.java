package com.vegasoft.jsource.view;

import com.vegasoft.jsource.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPaneController {
	@FXML private TabPane tabPane;
	
	// Reference to the main application
	private MainApp mainApp;
	
	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public TabPaneController() { }
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
	@FXML
	private void initialize() { }
	
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        initTabs();
    }
    
    private void initTabs() {
    	// Create a new tab where RepositoryInit is loaded
    	Tab repositoryInitTab = new Tab();
    	repositoryInitTab.setText("New Repository");
    	
    	SplitPane repositoryInit = mainApp.initRepositoryInit();
		repositoryInitTab.setContent(repositoryInit);
		
		tabPane.getTabs().add(repositoryInitTab);
    }
}
