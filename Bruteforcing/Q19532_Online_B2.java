package Bruteforcing;

import java.io.*;
import java.util.*;

public class Q19532_Online_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());
		int e = Integer.parseInt(stk.nextToken());
		int f = Integer.parseInt(stk.nextToken());

		int x = 1000, y = 1000;
		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if ((a * i) + (b * j) == c && (d * i) + (e * j) == f) {
					x = i;
					y = j;
					break;
				}
			}
			if (x != 1000 && y != 1000)
				break;
		}

		bw.write(x + " " + y);

		bw.flush();
		bw.close();

	}
}