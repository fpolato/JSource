package com.vegasoft.jsource.view;

import com.vegasoft.jsource.MainApp;

public abstract class BaseController {
	// Reference to the main application
	private MainApp mainApp;
	
	public BaseController() { }
	
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        onControllerLoadEnd();
    }
    
    /**
     * Return the MainApp reference
     * @return
     */
    public MainApp getMainApp() {
    	return mainApp;
    }
    
    protected abstract void onControllerLoadEnd();
}
