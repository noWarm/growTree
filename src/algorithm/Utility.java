package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Utility {
	public static double rotateAngle = 1;
	
	public static String makeString(int levels, String s) {
		String next = "";
		char c;
		if (levels > 0) { // Check if there are any levels left to render
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c == 'X')
					next += makeString(levels - 1, "F-[[X]+X]+F[+FX]-X");
				else if (c == 'F')
					next += makeString(levels - 1, "FF");
				else
					next = next + c;
			}
		} else {			
			next = s;
		}
		return next;
	}

	// each 'F' will be represented in a Node
	public static Node stringToThreadTree(String s) {
		char c;
		double angle = 0.0;
		int currentNodeId = 0;
		Stack<Node> stack = new Stack<Node>();
		Node root = new Node(currentNodeId++, angle);			// represents s[0]
		Node currentHead = root;
				
		for (int i = 1; i < s.length(); i++) {	// begins at s[1] 
			c = s.charAt(i);
			switch(c) {
			case('F'):
				currentHead = currentHead.addNode(currentNodeId++, angle);
				break;
			case('-'):
				angle -= rotateAngle;
				break;
			case('+'):
				angle += rotateAngle;
				break;
			case('['):
				stack.push(currentHead);
				break;
			case(']'):
				currentHead = stack.pop();
				break;
			default:
				break;
			}
		}
		return root;
	}
	
	public static void bfsTraversal(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (queue.isEmpty() == false) {
			Node node = queue.poll();
			System.out.format("id = %d angle = %f\n",node.id, node.angle);
			for (Node child: node.childNode) {
				queue.offer(child);
			}
		}
	}
}
