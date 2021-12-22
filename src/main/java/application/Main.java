package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Random;

import business.Account;
import business.Case;
import business.NGO;
import db.MySQLHandler;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
 
	
	 
	 
	@Override
	public void start(Stage arg0) throws Exception {
	//	Thread.setDefaultUncaughtExceptionHandler(Main::showError);
				
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("start.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 400);
        arg0.setScene(scene);
        arg0.show();
		arg0.setTitle("Charity Management System");

	
	}


	 public static void main(String[] args) {
		 
	        launch(args);
	    }

}
