package app;

import algorithm.Node;
import algorithm.Utility;
import controller.GUIController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GUIController.setUpStage(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
