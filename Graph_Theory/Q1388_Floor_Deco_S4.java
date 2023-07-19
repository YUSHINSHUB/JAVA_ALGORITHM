package Graph_Theory;

import java.io.*;

public class Q1388_Floor_Deco_S4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		int blc = 0;
		int res = 0;

		char grp[][] = new char[n][m];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			blc = 0;
			for (int j = 0; j < m; j++) {
				grp[i][j] = temp.charAt(j);
				if (grp[i][j] == '-') {
					if (blc == 0) {
						blc = 1;
						res++;
					}
				} else
					blc = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			blc = 0;
			for (int j = 0; j < n; j++) {
				if (grp[j][i] == '|') {
					if (blc == 0) {
						blc = 1;
						res++;
					}
				} else
					blc = 0;
			}
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}