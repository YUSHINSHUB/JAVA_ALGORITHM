package Bruteforcing;

import java.io.*;

public class Q27590_Sun_Moon_B4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ds, ys, dm, ym;
		int res = 0;

		String inp[] = br.readLine().split(" ");

		ds = Integer.parseInt(inp[0]);
		ys = Integer.parseInt(inp[1]);

		inp = br.readLine().split(" ");

		dm = Integer.parseInt(inp[0]);
		ym = Integer.parseInt(inp[1]);

		while (ds != ys || dm != ym) {
			if (ds == ys)
				ds = 1;
			else
				ds++;

			if (dm == ym)
				dm = 1;
			else
				dm++;

			res++;
		}

		bw.write(res + "");
		bw.flush();
		bw.close();

	}
}