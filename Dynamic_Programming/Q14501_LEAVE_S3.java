package Dynamic_Programming;

import java.io.*;
import java.math.*;

public class Q14501_LEAVE_S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int con[][] = new int[n][2];
		String inp[] = new String[2];
		int hi[] = new int[n];

		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			con[i][0] = Integer.parseInt(inp[0]);
			con[i][1] = Integer.parseInt(inp[1]);
			hi[i] = 0;
		}

		int max = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int z = i; z < n; z++) {
				if (z + con[z][0] <= n) {
					sum += con[z][1];
					z += con[z][0] - 1;
					for (int x = z; x < n; x++)
						hi[x] = Math.max(sum, hi[x]);
				}
			}
			max = Math.max(sum, max);
			sum = hi[i];
		}

		bw.write(max + "");

		bw.flush();
		bw.close();

	}
}