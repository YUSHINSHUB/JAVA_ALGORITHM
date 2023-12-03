package Implementation;

import java.io.*;
import java.util.*;

public class Q1268_Temp_Leader_B1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int cls[][] = new int[n][5];
		boolean chk[][] = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(chk[i], false);
			String temp[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				cls[i][j] = Integer.parseInt(temp[j]);
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (cls[j][i] == cls[k][i]) {
						chk[j][k] = true;
						chk[k][j] = true;
					}
				}
			}
		}

		int max = 0;
		int res = 1;

		for (int i = 0; i < n; i++) {
			int temp = 0;
			for (int j = 0; j < n; j++) {
				if (chk[i][j])
					temp++;
			}
			if (max < temp) {
				max = temp;
				res = i + 1;
			}
		}

		bw.write(res + "");

		bw.flush();
		bw.close();
	}
}