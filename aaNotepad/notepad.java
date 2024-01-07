package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	static StringBuilder sb = new StringBuilder("");
	static ArrayList<Integer> out = new ArrayList<>();
	static int list[];
	static int N, M;

	static void bt() {

		if (out.size() == M) {
			for (int i = 0; i < M; i++)
				sb.append(out.get(i) + " ");
			sb.append("\n");
		} else {
			for (int i = 0; i < N; i++) {
				out.add(list[i]);
				bt();
				out.remove(out.size() - 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		list = new int[N];
		inp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(inp[i]);
		}
		Arrays.sort(list);

		bt();
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
