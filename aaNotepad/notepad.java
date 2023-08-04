package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	static int n;
	static int num[];
	static int op[] = new int[4];
	static int hig = Integer.MIN_VALUE;
	static int low = Integer.MAX_VALUE;

	static void bt(int cur, int idx) {

		if (idx == n) {
			hig = Math.max(hig, cur);
			low = Math.min(low, cur);
		} else {
			for (int i = 0; i < 4; i++) {
				if (op[i] > 0) {
					op[i]--;
					switch (i) {
					case 0:
						bt(cur + num[idx], idx + 1);
						break;
					case 1:
						bt(cur - num[idx], idx + 1);
						break;
					case 2:
						bt(cur * num[idx], idx + 1);
						break;
					case 3:
						bt(cur / num[idx], idx + 1);
						break;
					}
					op[i]++;
				}
			}
		}

		return;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		num = new int[n];
		String inp[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(inp[i]);

		inp = br.readLine().split(" ");

		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(inp[i]);

		bt(num[0], 1);

		bw.write(hig + "\n" + low);

		bw.flush();
		bw.close();

	}
}