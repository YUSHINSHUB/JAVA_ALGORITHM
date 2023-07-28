//This Java program solves the RGB Street problem. 
//Given a list of houses and the cost of painting each house with one of the three 
//colors (red, green, or blue), 
//the program calculates the minimum total cost of painting all houses with the 
//constraint that no two adjacent houses can have the same color. 
//The program applies dynamic programming to achieve this, 
//storing and reusing the minimum cost values for painting each house with a specific 
//color at every step.

package Dynamic_Programming;

import java.io.*;

public class Q1149_RGB_Street_S1 {

	// dp array will hold the minimum cost to paint each house with a specific color
	static int dp[] = new int[3001];

	// This function iteratively computes the minimum cost to paint each house
	static int recur(int fee[], int houseNum) {

		while (houseNum >= 0) {
			// The cost to paint a specific house with a certain color is the cost of that
			// color
			// plus the minimum cost of painting the next house with a different color
			dp[houseNum * 3] = fee[houseNum * 3] + Math.min(dp[(houseNum + 1) * 3 + 1], dp[(houseNum + 1) * 3 + 2]);
			dp[houseNum * 3 + 1] = fee[houseNum * 3 + 1]
					+ Math.min(dp[(houseNum + 1) * 3 + 0], dp[(houseNum + 1) * 3 + 2]);
			dp[houseNum * 3 + 2] = fee[houseNum * 3 + 2]
					+ Math.min(dp[(houseNum + 1) * 3 + 0], dp[(houseNum + 1) * 3 + 1]);
			houseNum--;
		}

		// Return the minimum cost of painting the first house with any color
		return Math.min(dp[0], Math.min(dp[1], dp[2]));

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of houses
		int n = Integer.parseInt(br.readLine());
		// Create an array to hold the cost of painting each house with each color
		int fee[] = new int[n * 3];

		for (int i = 0; i < n; i++) {
			// Read the costs of painting each house with each color
			String temp[] = br.readLine().split(" ");
			for (int z = 0; z < 3; z++) {
				fee[i * 3 + z] = Integer.parseInt(temp[z]);
			}
		}

		// Set the cost of painting the last house with each color as the cost itself
		dp[(n - 1) * 3 + 0] = fee[(n - 1) * 3 + 0];
		dp[(n - 1) * 3 + 1] = fee[(n - 1) * 3 + 1];
		dp[(n - 1) * 3 + 2] = fee[(n - 1) * 3 + 2];

		// Start from the second last house
		int houseNum = (n - 2);

		// Compute the minimum cost
		int res = recur(fee, houseNum);

		// Output the result
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}