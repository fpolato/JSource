package com.vegasoft.jsource;

import java.io.IOException;

import com.vegasoft.jsource.view.TabPaneController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	/**
	 * Constructor
	 */
	public MainApp() {
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("JSource");
		
		// Set the application icon.
	    //this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

		initRootLayout();
		
		initTabPane();
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
	
	public void initTabPane() {
		try {
			// Load tab pane
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TabPane.fxml"));
			BorderPane tabPane = (BorderPane) loader.load();
			
			// Set tab pane into the center of root layoyt
			rootLayout.setCenter(tabPane);
			
			// Give the controller access to the main app.
			TabPaneController controller = loader.getController();
			controller.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Node initRepositoryInit() {
		Node repositoryInit = null;
		try {
			// Load repository init
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RepositoryInit.fxml"));
			repositoryInit = (Node) loader.load();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return repositoryInit;
	}

//	/**
//	 * Shows the person overview inside the root layout.
//	 */
//	public void showRepositoryOverview() {
//		try {
//			// Load person overview.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/RepositoryOverview.fxml"));
//			AnchorPane repositoryOverview = (AnchorPane) loader.load();
//
//			// Set person overview into the center of root layout.
//			rootLayout.setCenter(repositoryOverview);
//
//			// Give the controller access to the main app.
//			//PersonOverviewController controller = loader.getController();
//			//controller.setMainApp(this);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
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