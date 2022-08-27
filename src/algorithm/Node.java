package algorithm;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Node {
	public int id;
	public double angle;
	public ArrayList<Node> childNode;
	
	
	public Node(int id, double angle) {
		this.id = id;
		this.angle = angle;
		childNode = new ArrayList<Node>();
	}


	public Node addNode(int id, double angle) {
		Node child = new Node(id, angle);
		this.childNode.add(child);
		return child;
	}
	
	public void draw(GraphicsContext gc, double x, double y, double len, Color color) {
		double lengthChange = len;
		double branchRadius = 3;
		
		Thread thread = new Thread(() -> {
		System.out.format("id:%3d\tangle:%f\n",id, angle);
			double currentX = x;
			double currentY = y;
			double timeCount = 0;
			
			while (timeCount < len) {
				double drawX = currentX;
				double drawY = currentY;
				Platform.runLater(() -> {
					gc.setFill(color);
					gc.fillOval(drawX, drawY, branchRadius, branchRadius);	
				});
				currentX += lengthChange * Math.sin(angle);
				currentY -= lengthChange * Math.cos(angle);
			
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				timeCount += 0.05;
			}
			
			Color childColor;
			if (color == Color.GREEN) {
				childColor = color.RED;
			} else if (color == Color.RED){
				childColor = color.YELLOW;
			} else 
				childColor = color.GREEN;
			for (Node child: childNode) {
				child.draw(gc, currentX, currentY, len, childColor);
			}
		
		});
		
		thread.start();
		
		
	}

}
