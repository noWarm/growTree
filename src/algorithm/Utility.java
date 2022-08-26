package algorithm;

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
}
