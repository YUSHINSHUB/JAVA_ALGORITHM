package aaNotepad;

import java.io.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int y1, m1, d1, y2, m2, d2;
		int res = 0;
		int mon[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		String inp[] = br.readLine().split(" ");
		y1 = Integer.parseInt(inp[0]);
		m1 = Integer.parseInt(inp[1]);
		d1 = Integer.parseInt(inp[2]);
		inp = br.readLine().split(" ");
		y2 = Integer.parseInt(inp[0]);
		m2 = Integer.parseInt(inp[1]);
		d2 = Integer.parseInt(inp[2]);

		if (y2 > y1 + 1000) {
			bw.write("gg");
		} else if (y2 == y1 + 1000 && m2 > m1) {
			bw.write("gg");
		} else if (y2 == y1 + 1000 && m2 == m1 && d2 >= d1) {
			bw.write("gg");
		} else {
			while (true) {
				res += mon[m1];
				if (m1 == 2) {
					if (y1 % 400 == 0)
						res++;
					else if (y1 % 100 != 0 && y1 % 4 == 0)
						res++;
				}
				m1++;
				if (m1 == 13) {
					m1 = 1;
					y1++;
				}
				if (y1 == y2 && m1 == m2)
					break;
			}
			res += d2 - d1;
			bw.write("D-" + res);
		}

		bw.flush();
		bw.close();

	}

}
