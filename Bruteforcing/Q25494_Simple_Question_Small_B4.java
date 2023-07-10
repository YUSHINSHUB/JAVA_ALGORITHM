package Bruteforcing;

import java.io.*;

public class Q25494_Simple_Question_Small_B4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int a, b, c;

		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			a = Integer.parseInt(inp[0]);
			b = Integer.parseInt(inp[1]);
			c = Integer.parseInt(inp[2]);
			int res = 0;

			for (int j = 1; j <= a; j++) {
				for (int k = 1; k <= b; k++) {
					for (int l = 1; l <= c; l++)
						if (j % k == k % l && k % l == l % j)
							res++;
				}
			}

			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}
}