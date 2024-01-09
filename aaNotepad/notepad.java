package aaNotepad;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class notepad {
	static StringBuilder sb = new StringBuilder(""); // StringBuilder to build output
	static ArrayList<Integer> out = new ArrayList<>(); // List to store current combination
	static int list[]; // Input array
	static int N, M; // N: Size of the array, M: Size of the combination

	static void bt(int idx) {
		if (out.size() == M) {
			// When the combination size equals M, add it to StringBuilder
			for (int i = 0; i < M; i++)
				sb.append(out.get(i)).append(" ");
			sb.append("\n");
		} else {
			// Recursively construct combinations
			for (int i = idx; i < N; i++) {
				out.add(list[i]);
				bt(i);
				out.remove(out.size() - 1); // Backtrack
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
		Arrays.sort(list); // Sort the input array

		bt(0); // Start backtracking
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}