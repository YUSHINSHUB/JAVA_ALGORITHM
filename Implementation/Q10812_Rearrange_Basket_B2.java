package Implementation;

import java.io.*;

public class Q10812_Rearrange_Basket_B2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int bas[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			bas[i] = i;
		}

		for (int l = 0; l < m; l++) {
			inp = br.readLine().split(" ");
			int i = Integer.parseInt(inp[0]);
			int j = Integer.parseInt(inp[1]);
			int k = Integer.parseInt(inp[2]);

			int temp[] = new int[n + 1];
			for (int o = 1; o <= n; o++)
				temp[o] = bas[o];
			int idx = i;

			for (int o = k; o <= j; o++) {
				bas[idx] = temp[o];
				idx++;
			}

			for (int o = i; o < k; o++) {
				bas[idx] = temp[o];
				idx++;
			}

		}

		for (int i = 1; i <= n; i++) {
			bw.write(bas[i] + " ");
		}

		bw.flush();
		bw.close();
	}
}
