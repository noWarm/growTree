package controller;

import algorithm.Node;
import algorithm.Utility;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIController {
	
	static int canvas_width = 800;
	static int canvas_height = 800;
	
	static double groundOffset = 200;
	static double branchLength = 2.5;
	
	static Canvas canvas;
	
	public static void setUpStage(Stage stage) {
		canvas = new Canvas(canvas_width, canvas_height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		StackPane root = new StackPane();
		root.getChildren().add(canvas);
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0, canvas_height-groundOffset, canvas_width, canvas_height);
		
		Button btn = new Button("SEED");
		root.setAlignment(btn, Pos.BOTTOM_CENTER);
		root.setPadding(new Insets(12));
		btn.setOnAction((e) -> {
			int level = Utility.getRandomInt(3, 6);
			double beginX = (double) Utility.getRandomInt(30, canvas_width/1.2);
			double rotateAngle = Math.toRadians(Utility.getRandomInt(10, 30));
			double initAngle = Math.toRadians(Utility.getRandomInt(-60, 60) / 10);
			growTree(level, beginX, rotateAngle, initAngle);
		});
		
		
		root.getChildren().add(btn);
		Scene scene = new Scene(root, canvas_width, canvas_height);
		stage.setScene(scene);
	}
	
	
	public static void growTree(
			int level,
			double x,
			double rotateAngle,
			double initAngle) 
	{
		// generate the rule string
		String rule = Utility.makeString(level, "X");
		
		//override for test
//		rule = "FF-[[F-[+]+F";
		System.out.println(rule);
		
		
		
		// convert the rule string to a thread tree
		Node threadTreeRoot = Utility.stringToThreadTree(rule, rotateAngle, initAngle);
		//////	Utility.bfsTraversal(threadTreeRoot);
		
		// draw by BFS the thread tree
		double adjustedLength = branchLength/level;
		threadTreeRoot.draw(canvas.getGraphicsContext2D(), x, canvas_height - groundOffset, adjustedLength, Color.GREEN);
				
		//canvas_width/3 looks cool
	
		
	}
}
