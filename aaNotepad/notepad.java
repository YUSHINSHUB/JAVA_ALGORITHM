package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int sol[] = new int[n];

		String inp[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			sol[i] = Integer.parseInt(inp[i]);
		}

		Arrays.sort(sol);

		int low = 0;
		int hig = n - 1;
		int clow = 0;
		int chig = n - 1;

		int cur = Math.abs(sol[0] + sol[n - 1]);

		while (true) {
			if (clow >= chig || clow == chig-1)
				break;

			if (cur == 0)
				break;

			if (Math.abs(sol[clow + 1] + sol[chig]) > Math.abs(sol[clow] + sol[chig - 1])) {
				chig--;
			} else {
				clow++;
			}

			if (cur > Math.abs(sol[clow] + sol[chig])) {
				low = clow;
				hig = chig;
				cur = Math.abs(sol[clow] + sol[chig]);
			}

		}

		bw.write(sol[low] + " " + sol[hig]);

		bw.flush();
		bw.close();

	}
}
