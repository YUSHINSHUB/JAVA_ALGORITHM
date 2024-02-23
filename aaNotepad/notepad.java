package aaNotepad;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.math.*;

public class notepad {

	static int parent[] = new int[200000];
	static int groupcnt[] = new int[200000];

	static int find_parent(int no) {
		if (parent[no] == no) {
			return no;
		}
		return parent[no] = find_parent(parent[no]);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T;

		T = Integer.parseInt(br.readLine());

		for (int c = 0; c < T; c++) {
			Arrays.fill(parent, 0);
			Arrays.fill(groupcnt, 0);
			HashMap<String, Integer> hm = new HashMap<>();
			int F = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int i = 0; i < F; i++) {
				String inp[] = br.readLine().split(" ");
				if (!hm.containsKey(inp[0])) {
					hm.put(inp[0], cnt++);
					parent[hm.get(inp[0])] = hm.get(inp[0]);
					groupcnt[hm.get(inp[0])] = 1;
				}
				int a = hm.get(inp[0]);
				if (!hm.containsKey(inp[1])) {
					hm.put(inp[1], cnt++);
					parent[hm.get(inp[1])] = hm.get(inp[1]);
					groupcnt[hm.get(inp[1])] = 1;
				}
				int b = hm.get(inp[1]);
				if (find_parent(a) != find_parent(b)) {
					groupcnt[parent[a]] += groupcnt[parent[b]];
					groupcnt[parent[b]] = 0;
					parent[parent[b]] = parent[a];
				}
				bw.write(groupcnt[parent[a]] + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}