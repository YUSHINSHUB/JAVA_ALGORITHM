package Dynamic_Programming;

import java.io.*;
import java.math.*;

public class Q9465_STICKER_S1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int st[][] = new int[2][n];

			// Read the scores of the stickers in the first row
			String inp[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				st[0][j] = Integer.parseInt(inp[j]);
			}

			// Read the scores of the stickers in the second row
			inp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				st[1][j] = Integer.parseInt(inp[j]);
			}

			// Special case handling for the first column
			// The score of the second sticker in the first column is increased by the score
			// of the first sticker in the second column
			st[0][1] += st[1][0];
			// Similarly, the score of the second sticker in the second column is increased
			// by the score of the first sticker in the first column
			st[1][1] += st[0][0];

			// Calculate the maximum score for each subsequent column
			for (int j = 2; j < n; j++) {
				// The maximum score of a sticker is either the sum of its score and the maximum
				// score of the sticker in the previous column of the other row,
				// or the sum of its score and the maximum score of the sticker in the second
				// previous column of the other row
				st[0][j] = Math.max(st[1][j - 1] + st[0][j], st[1][j - 2] + st[0][j]);
				st[1][j] = Math.max(st[0][j - 1] + st[1][j], st[0][j - 2] + st[1][j]);
			}

			// Output the maximum score
			bw.write(Math.max(st[0][n - 1], st[1][n - 1]) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
