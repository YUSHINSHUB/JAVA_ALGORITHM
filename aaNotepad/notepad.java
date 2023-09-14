package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;
		int idx = 0;
		StringBuilder res = new StringBuilder("");

		while (true) {

			s = br.readLine();
			if (s == null || s.isEmpty())
				break;

			String inp[] = s.split(" ");
			double x1, x2, x3, x4;
			double y1, y2, y3, y4;

			x1 = Double.parseDouble(inp[0]);
			y1 = Double.parseDouble(inp[1]);
			x2 = Double.parseDouble(inp[2]);
			y2 = Double.parseDouble(inp[3]);
			x3 = Double.parseDouble(inp[4]);
			y3 = Double.parseDouble(inp[5]);
			x4 = Double.parseDouble(inp[6]);
			y4 = Double.parseDouble(inp[7]);

			if (x1 == x2 && y1 == y2) {
				x3 += x4 - x1;
				y3 += y4 - y1;
				res.append(String.format("%.3f %.3f\n", x3, y3));
			} else if (x1 == x3 && y1 == y3) {
				x2 += x4 - x1;
				y2 += y4 - y1;
				res.append(String.format("%.3f %.3f\n", x2, y2));
			} else if (x1 == x4 && y1 == y4) {
				x3 += x2 - x1;
				y3 += y2 - y1;
				res.append(String.format("%.3f %.3f\n", x3, y3));
			} else if (x2 == x3 && y2 == y3) {
				x1 += x4 - x2;
				y1 += y4 - y2;
				res.append(String.format("%.3f %.3f\n", x1, y1));
			} else if (x2 == x4 && y2 == y4) {
				x1 += x3 - x2;
				y1 += y3 - y2;
				res.append(String.format("%.3f %.3f\n", x1, y1));
			} else {
				x1 += x2 - x3;
				y1 += y2 - y3;
				res.append(String.format("%.3f %.3f\n", x1, y1));
			}
			idx++;
			if (idx == 8)
				break;
		}

		bw.flush();
		bw.close();

	}
}
