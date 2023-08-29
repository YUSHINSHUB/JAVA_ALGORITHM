package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static HashMap<Integer, Integer> hm = new HashMap<>();

	static int findparent(int n) {

		while (hm.get(n) != n) {
			n = hm.get(n);
		}

		return n;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		for (int i = 0; i <= n; i++) {
			hm.put(i, i);
		}

		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int comm = Integer.parseInt(inp[0]);
			int a = Integer.parseInt(inp[1]);
			int b = Integer.parseInt(inp[2]);

			if (comm == 0) {
				if (findparent(a) != findparent(b)) {
					hm.put(b, findparent(a));
				}
			} else {
				if (findparent(a) == findparent(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
		}

		bw.flush();
		bw.close();

	}
}
