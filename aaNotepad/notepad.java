package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int r1 = Integer.parseInt(inp[2]);
			int x2 = Integer.parseInt(inp[3]);
			int y2 = Integer.parseInt(inp[4]);
			int r2 = Integer.parseInt(inp[5]);
			int res = 0;
			int pos[][] = new int[40002][40002];
			for (int j = 0; j < 40002; j++)
				Arrays.fill(pos[j], 0);

			for (int j = 0; j <= r1; j++) {
				int temp = r1 - j;
				if (Math.sqrt(Math.pow(r1, 2) - Math.pow(j, 2)) == temp) {
					pos[j + 20001 + y1][temp + 20001 + x1] = 1;
					pos[j + 20001 + y1][20001 - temp + x1] = 1;
					pos[20001 - j + y1][temp + 20001 + x1] = 1;
					pos[20001 - j + y1][20001 - temp + x1] = 1;
				}
			}

			for (int j = 0; j <= r2; j++) {
				int temp = r2 - j;
				if (Math.sqrt(Math.pow(r2, 2) - Math.pow(j, 2)) == temp) {
					if (pos[j + 20001 + y2][temp + 20001 + x2] == 1) {
						pos[j + 20001 + y2][temp + 20001 + x2] = 0;
						res++;
					}
					if (pos[j + 20001 + y2][20001 - temp + x2] == 1) {
						pos[j + 20001 + y2][20001 - temp + x2] = 0;
						res++;
					}
					if (pos[20001 - j + y2][temp + 20001 + x2] == 1) {
						pos[20001 - j + y2][temp + 20001 + x2] = 1;
						res++;
					}
					if (pos[20001 - j + y2][20001 - temp + x2] == 1) {
						pos[20001 - j + y2][20001 - temp + x2] = 0;
						res++;
					}
				}
			}

			bw.write(res + "\n");

		}

		bw.flush();
		bw.close();

	}
}