package com.vegasoft.jsource.utils;

import java.io.IOException;

import com.vegasoft.jsource.JSourceFXMLLoader;
import com.vegasoft.jsource.MainApp;
import com.vegasoft.jsource.exceptions.JSourceIOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * A set of utilities to initialize a JavaFX node.
 * @author fabio.polato
 *
 */
public class NodeUtils {
	private static final String DEFAULT_NODE_LOCATION = "view";
	
	/**
	 * Initialize a Node and attach the corrisponding controller.
	 * @param nodeName
	 * @return
	 * @throws IOException
	 */
	public static Node initNode(String nodeName) throws JSourceIOException {
		Node node = null;

		try {
			// Load node from fxml
			FXMLLoader loader = new JSourceFXMLLoader();
			loader.setLocation(MainApp.class.getResource(DEFAULT_NODE_LOCATION + "/" + nodeName + ".fxml"));
			node = (Node) loader.load();
		} catch(IOException e) {
			throw (JSourceIOException) e;
		}
		
		return node;
	}
}
