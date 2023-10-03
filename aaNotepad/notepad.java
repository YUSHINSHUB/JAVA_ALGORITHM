package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int n, m;
	static boolean visited[] = new boolean[9];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Deque<Integer> dq = new LinkedList<>();

	static void bt() throws IOException {

		if (dq.size() == m) {
			for (int i = 0; i < dq.size(); i++) {
				int t = dq.pollFirst();
				bw.write(t + " ");
				dq.addLast(t);
			}
			bw.write("\n");
		} else {
			for (int i = 1; i <= n; i++) {

				if (visited[i])
					continue;

				dq.addLast(i);
				visited[i] = true;
				bt();
				dq.pollLast();
				visited[i] = false;
				
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Arrays.fill(visited, false);
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		bt();

		bw.flush();
		bw.close();

	}
}
