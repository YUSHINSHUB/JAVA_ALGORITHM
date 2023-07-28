package Prefix_Sum;

//Commented by ChatGPT
//The problem asks for the sum of submatrix elements within a given matrix. 

import java.io.*;

public class Q11660_Prefix_Sum_5_S1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Take the size of matrix and number of sub-matrices as input
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);

		// Define the prefix sum matrix
		int ps[][] = new int[n + 1][n + 1];

		// Fill the prefix sum matrix
		for (int i = 1; i <= n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 1; j <= n; j++)
				ps[i][j] = Integer.parseInt(inp[j - 1]);
		}

		// Initialize the first row and column of prefix sum matrix to 0
		for (int i = 0; i <= n; i++) {
			ps[0][i] = 0;
			ps[i][0] = 0;
		}

		// Compute the prefix sum
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ps[i][j] += ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];
			}
		}

		// Handle each sub-matrix query
		for (int i = 0; i < m; i++) {
			inp = br.readLine().split(" ");
			int x1 = Integer.parseInt(inp[0]);
			int y1 = Integer.parseInt(inp[1]);
			int x2 = Integer.parseInt(inp[2]);
			int y2 = Integer.parseInt(inp[3]);

			// Compute the sum of elements in the sub-matrix using the prefix sum
			int res = ps[x2][y2] - ps[x1 - 1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
			bw.write(res + "\n");
		}

		bw.flush();
		bw.close();

	}
}
