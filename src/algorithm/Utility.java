package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Utility {
	
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
	public static Node stringToThreadTree(String s, double rotateAngle, double initAngle) {
		char c;
		double currentAngle = initAngle;
		int currentNodeId = 0;
		Stack<MemorizedNode> stack = new Stack<MemorizedNode>();
		Node root = new Node(currentNodeId++, currentAngle);			// represents s[0]
		Node currentHead = root;
		MemorizedNode popNode;
				
		for (int i = 1; i < s.length(); i++) {	// begins at s[1] 
			c = s.charAt(i);
			switch(c) {
			case('F'):
				currentHead = currentHead.addNode(currentNodeId++, currentAngle);
				break;
			case('-'):
				currentAngle += rotateAngle;
				break;
			case('+'):
				currentAngle -= rotateAngle;
				break;
			case('['):
				stack.push(new MemorizedNode(currentHead, currentAngle));
				break;
			case(']'):
				popNode = stack.pop();
				currentHead = popNode.parent;
				currentAngle = popNode.angle;
				break;
			default:
				break;
			}
			System.out.format("i = %2d c= %c angle = %f ch_angle = %f\n", i, c, currentAngle, currentHead.angle);
		}
//		System.out.println("---------");
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
	
	public static int getRandomInt(double min, double max) {
		return  (int)Math.floor(Math.random()*(max-min+1)+min);
	}
	
	
}
