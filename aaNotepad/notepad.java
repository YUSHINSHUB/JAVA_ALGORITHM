package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	static int n;
	static int idx = 0;
	static int in[] = new int[100001];
	static int post[] = new int[100001];
	static int inpos[] = new int[100001];
	static Boolean visited[] = new Boolean[100003];
	static int left[] = new int[100001];
	static int right[] = new int[100001];
	static StringBuilder sb = new StringBuilder("");

	static void make_tree() {

		if (idx == 0)
			return;

		int node = post[idx];
		visited[inpos[node]] = true;
		int next = post[idx - 1];

		for (int i = inpos[node] + 1; i < n; i++) {
			if (visited[i])
				break;
			if (in[i] == next) {
				right[node] = next;
				idx--;
				make_tree();
				break;
			}
			
		}

		if( idx == 0 ) return;
		next = post[idx - 1];

		for (int i = inpos[node] - 1; i >= 0; i--) {
			if (visited[i])
				break;
			if (in[i] == next) {
				left[node] = next;
				idx--;
				make_tree();
				break;
			}
		}

	}

	static void get_pre(int node) {

		sb.append(node + " ");
		if (left[node] > 0)
			get_pre(left[node]);
		if (right[node] > 0)
			get_pre(right[node]);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[];

		Arrays.fill(visited, false);
		Arrays.fill(left, 0);
		Arrays.fill(right, 0);

		n = Integer.parseInt(br.readLine());
		idx = n - 1;
		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(inp[i]);
			inpos[Integer.parseInt(inp[i])] = i;
		}
		inp = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			post[i] = Integer.parseInt(inp[i]);

		make_tree();
		get_pre(post[n-1]);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}