package algorithm;

import java.util.ArrayList;

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

}
