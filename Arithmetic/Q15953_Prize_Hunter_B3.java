package Arithmetic;

import java.io.*;

public class Q15953_Prize_Hunter_B3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		int res = 0;
		int a, b;

		for (int i = 0; i < t; i++) {
			String inp[] = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			res = 0;

			if (a != 0) {
				if (a - 1 <= 0)
					res += 5000000;
				else if (a - 3 <= 0)
					res += 3000000;
				else if (a - 6 <= 0)
					res += 2000000;
				else if (a - 10 <= 0)
					res += 500000;
				else if (a - 15 <= 0)
					res += 300000;
				else if (a - 21 <= 0)
					res += 100000;
			}

			if (b != 0) {
				if (b - 1 <= 0)
					res += 5120000;
				else if (b - 3 <= 0)
					res += 2560000;
				else if (b - 7 <= 0)
					res += 1280000;
				else if (b - 15 <= 0)
					res += 640000;
				else if (b - 31 <= 0)
					res += 320000;
			}

			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}
}