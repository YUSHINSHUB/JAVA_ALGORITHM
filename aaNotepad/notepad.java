package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, m;
		String inp[] = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);

		int x1 = -1;
		int x2 = -1;
		int y1 = -1;
		int y2 = -1;

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				if (inp[j].equals("1")) {
					if (x1 == -1) {
						x1 = j;
						y1 = i;
					} else {
						x2 = j;
						y2 = i;
						break;
					}
				}
			}
			if (x2 >= 0)
				break;
		}

		bw.write(Math.abs(x2 - x1) + Math.abs(y2 - y1) + "");

		bw.flush();
		bw.close();

	}
}
