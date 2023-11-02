package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int N;
	static int M;
	static Deque<Integer> out = new LinkedList<>();;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void bt(int idx, int cur) throws IOException {
		if (idx == M) {
			for (int i = 1; i <= M; i++) {
				bw.write(out.getFirst() + " ");
				out.addLast(out.pollFirst());
			}
			bw.write("\n");
			return;
		}

		for (int i = cur; i <= N; i++) {
			out.addLast(i);
			bt(idx + 1, i);
			out.pollLast();
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inp[] = br.readLine().split(" ");

		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);

		bt(0, 1);

		bw.flush();
		bw.close();

	}

}
