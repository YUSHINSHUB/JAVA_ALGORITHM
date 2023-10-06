package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static HashMap<Integer, Integer> hm = new HashMap<>();
	static int grp[] = new int[101];

	static void search(int idx) {

		for (int i = idx; i <= 100; i++) {

			for (int j = 1; j <= 6; j++) {
				int s = i - j;
				if( s < 1 ) s = 1;
				grp[i] = Math.min(grp[s] + 1, grp[i]);
			}

			if (hm.getOrDefault(i, -1) != -1) {
				int s = hm.get(i);
				if( grp[s] > grp[i] ) {
					grp[s] = grp[i];
					search(s+1);
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

		search(2);

		bw.write(grp[100] + "");

		bw.flush();
		bw.close();

	}
}
