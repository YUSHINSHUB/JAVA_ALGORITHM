package Implementation;

import java.util.*;
import java.io.*;

class Q10828_Stack_S4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();
		for (int k = 0; k < n; k++) {
			String[] s = br.readLine().split(" ");
			String cmd = s[0];

			if (cmd.contentEquals("push")) {
				int num = Integer.parseInt(s[1]);
				stack.push(num);
			} else if (cmd.equals("top")) {
				if (stack.empty()) {
					bw.write("-1" + "\n");
				} else {
					bw.write(String.valueOf(stack.peek()) + "\n");
				}
			} else if (cmd.equals("size")) {
				bw.write(String.valueOf(stack.size()) + "\n");
			} else if (cmd.contentEquals("empty")) {
				if (stack.empty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
			} else if (cmd.equals("pop")) {
				if (stack.empty()) {
					bw.write("-1" + "\n");
				} else {
					bw.write(String.valueOf(stack.pop()) + "\n");
				}
			}
		}

		bw.flush();
		bw.close();

	}
}