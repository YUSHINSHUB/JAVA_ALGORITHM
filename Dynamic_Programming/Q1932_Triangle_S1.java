package Dynamic_Programming;

//Commented by ChatGPT
//This Java program solves the problem of finding the maximum total from top to bottom in a triangle of integers.
//It employs a bottom-up dynamic programming approach, calculating the maximum sums row-by-row from the bottom of the triangle.
//The program handles single-row cases separately for efficiency and outputs the maximum total to the standard output.
import java.io.*;
import java.math.*;
import java.util.*;

public class Q1932_Triangle_S1 {
	// 2D array to store the given triangle of integers
	static int tri[][];
	// 2D array to store the maximum sums calculated for each sub-problem
	static int dp[][];

	// Recursive function to calculate maximum sum for each row, starting from the
	// bottom
	static void recur(int n) {
		// If the maximum sum for the next row is not yet calculated, calculate it first
		if (dp[n + 1][1] < 0)
			recur(n + 1);

		// For each element in the current row, calculate and store the maximum sum
		for (int i = 1; i <= n; i++) {
			// Maximum sum is the current element plus the maximum of the two possible
			// elements in the next row
			dp[n][i] = Math.max(dp[n + 1][i], dp[n + 1][i + 1]) + tri[n][i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		tri = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];

		// Read the given triangle of integers
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], -1); // Initialize the maximum sums as -1
			String inp[] = br.readLine().split(" ");
			for (int j = 1; j <= i; j++) {
				tri[i][j] = Integer.parseInt(inp[j - 1]);
			}
		}

		// The maximum sums for the last row are the elements themselves
		for (int i = 1; i <= n; i++) {
			dp[n][i] = tri[n][i];
		}

		// If there is only one row, output its maximum sum
		if (n == 1)
			bw.write(dp[1][1] + "");
		else {
			// Otherwise, calculate the maximum sum starting from the first row
			recur(1);
			bw.write(dp[1][1] + "");
		}
		bw.flush();
		bw.close();
	}
}
