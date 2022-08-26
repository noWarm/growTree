package app;

import algorithm.Node;
import algorithm.Utility;
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
		int canvas_width = 800;
		int canvas_height = 800;
		
		Canvas bubble_layer = new Canvas(canvas_width, canvas_height);
		GraphicsContext bubble_gc = bubble_layer.getGraphicsContext2D();
		
		Pane root = new Pane();
		Scene scene = new Scene(root, canvas_width, canvas_height);
		
		// generate the rule string
		String rule = Utility.makeString(2, "X");
		
		// test
		System.out.println(rule);
		
		// convert the rule string to a thread tree
		Node threadTreeRoot = Utility.stringToThreadTree(rule);
		
		//test
		Utility.bfsTraversal(threadTreeRoot);
		
		// draw by BFS the thread tree
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
