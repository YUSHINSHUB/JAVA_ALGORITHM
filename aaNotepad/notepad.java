package aaNotepad;

import java.io.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int day[] = new int[366];
		int res = 0;
		boolean quit = false;
		Arrays.fill(day, 0);

		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			int bm = Integer.parseInt(inp[0]);
			int bd = Integer.parseInt(inp[1]);
			int wm = Integer.parseInt(inp[2]);
			int wd = Integer.parseInt(inp[3]);
			int start = 0;
			int end = 0;
			int len = 0;

			switch (bm) {
			case 1:
				start = bd;
				break;
			case 2:
				start = 31 + bd;
				break;
			case 3:
				start = 59 + bd;
				break;
			case 4:
				start = 90 + bd;
				break;
			case 5:
				start = 120 + bd;
				break;
			case 6:
				start = 151 + bd;
				break;
			case 7:
				start = 181 + bd;
				break;
			case 8:
				start = 212 + bd;
				break;
			case 9:
				start = 243 + bd;
				break;
			case 10:
				start = 273 + bd;
				break;
			case 11:
				start = 304 + bd;
				break;
			case 12:
				start = 334 + bd;
				break;
			}

			switch (wm) {
			case 1:
				end = wd;
				break;
			case 2:
				end = 31 + wd;
				break;
			case 3:
				end = 59 + wd;
				break;
			case 4:
				end = 90 + wd;
				break;
			case 5:
				end = 120 + wd;
				break;
			case 6:
				end = 151 + wd;
				break;
			case 7:
				end = 181 + wd;
				break;
			case 8:
				end = 212 + wd;
				break;
			case 9:
				end = 243 + wd;
				break;
			case 10:
				end = 273 + wd;
				break;
			case 11:
				end = 304 + wd;
				break;
			case 12:
				end = 334 + wd;
				break;
			}

			day[start] = Math.max(day[start], end - start);
		}

		int idx = 60;
		while (idx <= 334) {
			int hig = Integer.MIN_VALUE;
			for (int i = idx; i >= 1; i--) {
				hig = Math.max((i + day[i] - 1) - idx, hig);
			}
			if (hig < 0) {
				quit = true;
				break;
			}

			idx += hig + 1;
			res++;
		}

		if (quit)
			bw.write("0");
		else
			bw.write(res + "");

		bw.flush();
		bw.close();

	}

}
