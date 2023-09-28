package Recursion;

import java.io.*;

public class Q6603_LOTTO_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String inp[] = br.readLine().split(" ");
			int k = Integer.parseInt(inp[0]);
			if (k == 0)
				break;
			int num[] = new int[k];

			for (int i = 1; i <= k; i++) {
				num[i - 1] = Integer.parseInt(inp[i]);
			}

			for (int i = 0; i < k - 5; i++) {
				for (int j = i + 1; j < k - 4; j++) {
					for (int l = j + 1; l < k - 3; l++) {
						for (int m = l + 1; m < k - 2; m++) {
							for (int n = m + 1; n < k - 1; n++) {
								for (int o = n + 1; o < k; o++) {
									bw.write(num[i] + " " + num[j] + " " + num[l] + " " + num[m] + " " + num[n] + " "
											+ num[o] + "\n");
								}
							}
						}
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}
}