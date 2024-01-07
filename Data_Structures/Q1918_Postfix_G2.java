package Data_Structures;

import java.io.*;
import java.util.*;

public class Q1918_Postfix_G2 {

	public static int check(char c) {
		if (c == '/' || c == '*') {
			return 3;
		} else if (c == '+' || c == '-') {
			return 2;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		StringBuilder sb = new StringBuilder("");

		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == '(') {
				stk.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				while (stk.peek() != '(') {
					sb.append(stk.pop());
				}
				stk.pop();
			} else {
				while (!stk.isEmpty() && check(stk.peek()) >= check(s.charAt(i))) {
					sb.append(stk.pop());
				}
				stk.push(s.charAt(i));
			}
		}
		while (!stk.isEmpty()) {
			sb.append(stk.pop());
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
