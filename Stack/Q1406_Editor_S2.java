package Stack;

import java.util.*;
import java.io.*;

class Q1406_Editor_S2 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			left.push(s.charAt(i));
		}
		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			String[] line = br.readLine().split(" ");
			char cmd = line[0].charAt(0);

			if (cmd == 'L') {
				if (!left.empty()) {
					right.push(left.pop());
				}
			} else if (cmd == 'D') {
				if (!right.empty()) {
					left.push(right.pop());
				}
			} else if (cmd == 'P') {
				char c = line[1].charAt(0);
				left.push(c);
			} else if (cmd == 'B') {
				if (!left.empty()) {
					left.pop();
				}
			}
		}
		while (!left.empty()) {
			right.push(left.pop());
		}
		while (!right.empty()) {
			System.out.print(right.pop());
		}
	}
}