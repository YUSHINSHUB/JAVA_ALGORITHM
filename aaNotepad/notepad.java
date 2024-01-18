package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static Queue<Integer> input = new LinkedList<>();
	static StringBuilder sb = new StringBuilder("");

	static void recur(int node, int hig, int low) {

		if (input.isEmpty()) {
			sb.append(node + "\n");
			return;
		}

		int cur = input.peek();
		if (cur < hig && cur > low) {
			if (cur < node) {
				input.poll();
				recur(cur, node, low);
			}
		}

		if (input.isEmpty()) {
			sb.append(node + "\n");
			return;
		}

		cur = input.peek();
		if (cur < hig && cur > low) {
			if (cur > node) {
				input.poll();
				recur(cur, hig, node);
			}
		}

		sb.append(node + "\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp;

		while ((inp = br.readLine()) != null) {
			input.add(Integer.parseInt(inp));
		}

		int top = input.poll();

		recur(top, 1000000, -1);

		bw.write(sb.toString() + "");

		bw.flush();
		bw.close();
	}
}