package Mathematics;

import java.io.*;

public class Q2738_Matrix_B5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		int mat1[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			String temp[] = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				mat1[i][j] = Integer.parseInt(temp[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			String temp[] = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				mat1[i][j] += Integer.parseInt(temp[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(mat1[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}
}
