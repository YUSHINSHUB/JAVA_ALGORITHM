package Binary_Search;

import java.io.*;
import java.util.*;

public class Q2110_Router_G4 {

	static int home[];

	protected static int get(int dist) {

		int cur = 0;
		int temp = 1;

		for (int i = 1; i < home.length; i++) {
			if (home[i] - home[cur] >= dist) {
				cur = i;
				temp++;
			}
		}

		return temp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");

		int n = Integer.parseInt(inp[0]);
		int c = Integer.parseInt(inp[1]);
		home = new int[n];

		for (int i = 0; i < n; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(home);

		int lo = 1;
		int hi = home[n - 1] - home[0] + 1;
		int md = (lo + hi) / 2;

		while (true) {

			if (get(md) < c) {
				hi = md;
				md = (hi + lo) / 2;
			} else {
				lo = md + 1;
				md = (hi + lo) / 2;
			}

			if (lo == hi)
				break;

		}

		bw.write((lo - 1) + "");

		bw.flush();
		bw.close();

	}
}