package app;

import algorithm.Node;
import algorithm.Utility;
import controller.MainController;
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
		int canvas_width = 1200;
		int canvas_height = 1000;
		
		double groundOffset = 50;
		double branchLength = 0.8;
		
		Canvas canvas = new Canvas(canvas_width, canvas_height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Pane root = new Pane();
		root.getChildren().add(canvas);
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0, canvas_height-groundOffset, canvas_width, canvas_height);
		
		// generate the rule string
		String rule = Utility.makeString(6, "X");
		System.out.println(rule);
		
//		String rule = "F[F[F[F]-F]+F]+F";
		
		// convert the rule string to a thread tree
		Node threadTreeRoot = Utility.stringToThreadTree(rule);
		//////	Utility.bfsTraversal(threadTreeRoot);
		
		// draw by BFS the thread tree
		threadTreeRoot.draw(gc, canvas_width/5, canvas_height - groundOffset, branchLength, Color.BLACK);
		

		Scene scene = new Scene(root, canvas_width, canvas_height);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
