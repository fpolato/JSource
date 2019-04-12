package com.vegasoft.jsource.utils;

import java.io.IOException;

import com.vegasoft.jsource.MainApp;
import com.vegasoft.jsource.exceptions.JSourceIOException;
import com.vegasoft.jsource.view.BaseController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * A set of utilities to initialize a JavaFX node.
 * @author fabio.polato
 *
 */
public class NodeUtils {
	private final String DEFAULT_NODE_LOCATION = "view";
	private MainApp mainApp;
	
	public NodeUtils(MainApp mainApp) {
		setMainApp(mainApp);
	}
	
	public MainApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Initialize a Node and attach the corrisponding controller.
	 * @param nodeName
	 * @return
	 * @throws IOException
	 */
	public Node initNode(String nodeName) throws JSourceIOException {
		return initNode(nodeName, Boolean.TRUE);
	}
	
	/**
	 * Initalize a Node and attach the corrisponding controller
	 * if the parameter {@code initController} is TRUE.
	 * @param nodeName
	 * @param initController
	 * @return
	 * @throws IOException
	 */
	public Node initNode(String nodeName, Boolean initController) throws JSourceIOException {
		Node node = null;

		try {
			// Load node from fxml
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(DEFAULT_NODE_LOCATION + "/" + nodeName + ".fxml"));
			node = (Node) loader.load();
			
			if(initController) {
				BaseController controller = loader.getController();
				controller.setMainApp(getMainApp());
			}
		} catch(IOException e) {
			throw (JSourceIOException) e;
		}
		
		return node;
	}
}
