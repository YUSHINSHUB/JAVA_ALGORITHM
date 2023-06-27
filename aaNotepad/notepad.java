package aaNotepad;

import java.io.*;
import java.math.*;
import java.util.*;

public class notepad {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int p[][] = new int[n][n];
		int res[] = new int[3];
		Arrays.fill(res, 0);

		for (int i = 0; i < n; i++) {
			String in[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				p[i][j] = Integer.parseInt(in[j]);
			}
		}

		for (int i = n; i >= 1; i /= 3) {
			for (int j = 0; j < n; j += i) {
				for (int k = 0; k < n; k += i) {
					if (p[j][k] == -2)
						continue;
					int temp = p[j][k];
					boolean chk = true;
					for (int l = j; l < j + i; l++) {
						for (int m = k; m < k + i; m++) {
							if (p[l][m] != temp) {
								chk = false;
								break;
							}
						}
						if (!chk)
							break;
					}
					if (chk) {
						temp++;
						res[temp]++;
						for (int l = j; l < j + i; l++) {
							for (int m = k; m < k + i; m++) {
								p[l][m] = -2;
							}
						}
					}
				}
			}
		}

		bw.write(res[0] + "\n" + res[1] + "\n" + res[2]);

		bw.flush();
		bw.close();

	}
}
