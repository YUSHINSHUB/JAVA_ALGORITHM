package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static HashMap<Integer, Integer> hm = new HashMap<>();
	static int grp[] = new int[101];

	static void search(int idx) {

		for (int i = idx; i <= 100; i++) {

			if (hm.getOrDefault(i, -1) == -1) {
				for (int j = i; j <= i + 6; j++) {
					if (j > 100)
						break;
					grp[j] = Math.min(grp[i] + 1, grp[j]);
				}
			}

			if (hm.getOrDefault(i, -1) != -1) {
				int s = hm.get(i);
				if (grp[s] > grp[i]) {
					grp[s] = grp[i];
					search(s);
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int x, y;

		Arrays.fill(grp, 100);
		grp[1] = 0;

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			hm.put(x, y);
		}

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			x = Integer.parseInt(inp[0]);
			y = Integer.parseInt(inp[1]);
			hm.put(x, y);
		}

		search(1);

		bw.write(grp[100] + "");

		bw.flush();
		bw.close();

	}
}
