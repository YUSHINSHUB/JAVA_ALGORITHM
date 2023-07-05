package Data_Structures;

import java.io.*;
import java.util.*;

public class Q4949_Balanced_World_S4 {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String in;
		Stack<Character> stk = new Stack<>();

		while (true) {
			in = br.readLine();

			if (in.equals("."))
				break;

			while (!stk.isEmpty())
				stk.pop();

			for (int i = 0; i < in.length(); i++) {
				if (in.charAt(i) == '(' || in.charAt(i) == '[')
					stk.push(in.charAt(i));
				else if (in.charAt(i) == ')' && !stk.isEmpty()) {
					if (stk.peek() == '(')
						stk.pop();
					else {
						stk.push('0');
						break;
					}
				} else if (in.charAt(i) == ')' && stk.isEmpty()) {
					stk.push('0');
					break;
				} else if (in.charAt(i) == ']' && !stk.isEmpty()) {
					if (stk.peek() == '[')
						stk.pop();
					else {
						stk.push('0');
						break;
					}
				} else if (in.charAt(i) == ']' && stk.isEmpty()) {
					stk.push('0');
					break;
				}
			}

			if (stk.isEmpty())
				bw.write("yes\n");
			else
				bw.write("no\n");
		}

		bw.flush();
		bw.close();
	}
}
