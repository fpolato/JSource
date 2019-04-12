package com.vegasoft.jsource;

import java.io.IOException;

import com.vegasoft.jsource.exceptions.JSourceIOException;
import com.vegasoft.jsource.utils.NodeUtils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private NodeUtils nodeUtils;

	/**
	 * Constructor
	 */
	public MainApp() {
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("JSource");
		this.nodeUtils = new NodeUtils(this);
		
		// Set the application icon.
	    //this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

		initRootLayout();
		
		try {
			// Inizializzo il TabPane principale
			BorderPane tabPane = (BorderPane) nodeUtils.initNode("TabPane");
			rootLayout.setCenter(tabPane);
		} catch(JSourceIOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public NodeUtils getNodeUtils() {
		return nodeUtils;
	}
	
	/**
	 * Returns the main stage.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}