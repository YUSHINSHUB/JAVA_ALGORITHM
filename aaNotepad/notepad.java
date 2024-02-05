package aaNotepad;

import java.io.*;
import java.util.*;
import java.math.*;

public class notepad {

	static int visited[] = new int[1000001];
	static ArrayList<Integer> seq = new ArrayList<>();
	static int X;

	static void dp(int cur, int idx) {

		if (cur == 1) {
			visited[1] = idx;
			return;
		}
		if (visited[cur] <= idx || idx >= visited[1])
			return;

		visited[cur] = idx;
		if (cur % 6 == 0) {
			dp(cur / 3, idx + 1);
			dp(cur / 2, idx + 1);
			dp(cur - 1, idx + 1);
		} else if (cur % 3 == 0) {
			dp(cur / 3, idx + 1);
			dp(cur - 1, idx + 1);
		} else if (cur % 2 == 0) {
			dp(cur / 2, idx + 1);
			dp(cur - 1, idx + 1);
		} else {
			dp(cur - 1, idx + 1);
		}

	}

	static void find(int cur) {
		seq.add(cur);
		if (cur == X)
			return;

		if (visited[cur + 1] == visited[cur] - 1)
			find(cur + 1);
		else if (visited[cur * 2] == visited[cur] - 1)
			find(cur * 2);
		else if (visited[cur * 3] == visited[cur] - 1)
			find(cur * 3);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Arrays.fill(visited, 1000001);

		X = Integer.parseInt(br.readLine());
		dp(X, 0);

		bw.write(visited[1] + "\n");
		find(1);
		for (int i = seq.size() - 1; i >= 0; i--)
			bw.write(seq.get(i) + " ");
		bw.flush();
		bw.close();
	}
}