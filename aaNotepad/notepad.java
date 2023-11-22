package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder("");
		String inp[] = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int K = Integer.parseInt(inp[1]);

		String num = br.readLine();
		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < N - 1; i++) {

			stk.add(num.charAt(i));
			while (!stk.isEmpty() && K > 0) {
				if (stk.peek() < num.charAt(i + 1)) {
					stk.pop();
					K--;
				} else
					break;
			}
		}
		stk.add(num.charAt(N - 1));

		while (K != 0) {
			stk.pop();
			K--;
		}

		while (!stk.isEmpty()) {
			sb.append(stk.pop());
		}

		bw.write(sb.reverse().toString());

		bw.flush();
		bw.close();

	}

}
