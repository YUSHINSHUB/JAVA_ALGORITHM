//This Java program is intended to solve a variant of the dynamic programming problem 
//known as the "Wine Tasting Problem". 
//Here, instead of the wine's vintage or price, 
//we are interested in the volume or quantity of wine in each bottle. 
//The problem dictates that you cannot drink from three consecutive bottles.

//Here is a walkthrough of the program:

//1.Data Structures: We have two primary arrays - dp[] and w[]. 
//	The dp[] array stores the maximum volume of wine that can be drunk given n bottles, 
//	while w[] is used to store the volume of wine in each bottle.

//2.Recursive Function (recur): This function takes an integer n and uses a dynamic 
//	programming approach to calculate the maximum volume of wine that can be drunk. 
//	If dp[n] is not yet calculated (i.e., its value is still -1), 
//	the function computes it based on the maximum of three scenarios - drinking from the 
//	n-th and (n-1)-th bottle but skipping the (n-2)-th bottle, 
//	drinking from the n-th bottle but skipping the (n-1)-th and (n-2)-th bottles, 
//	or skipping the n-th bottle altogether.

//3.Main Function: The main() function reads the number of bottles n and the volume of 
//	wine in each bottle. 
//	It initializes the dp[] array to -1 and sets dp[0] to 0. 
//	If there are at least two bottles, 
//	it also sets dp[2] to the sum of the first two bottle's volumes. 
//	If there's only one bottle, dp[1] is set to the first bottle's volume.
//	It then calls recur(n) to compute the maximum volume that can be drunk from n 
//	bottles. Finally, it writes this result to the standard output.

package Dynamic_Programming;

import java.io.*;
import java.math.*;
import java.util.*;

public class Q2156_Tasting_Wine_S1 {

	// dp array to store the maximum volume that can be drunk for each number of
	// bottles
	static int dp[];

	// w array to store the volume of each bottle
	static int w[];

	// recursive function to calculate the maximum volume that can be drunk from n
	// bottles
	static int recur(int n) {

		// if dp[n] has not been calculated yet
		if (dp[n] < 0) {
			// calculate dp[n] as the maximum of three scenarios:
			// 1. Drink from n-th and (n-1)-th bottle, skip the (n-2)-th bottle
			// 2. Drink from the n-th bottle, skip the (n-1)-th and (n-2)-th bottles
			// 3. Skip the n-th bottle
			dp[n] = Math.max(Math.max(recur(n - 3) + w[n - 1] + w[n], recur(n - 2) + w[n]), recur(n - 1));
		}

		// return dp[n]
		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// read the total number of bottles
		int n = Integer.parseInt(br.readLine());

		// initialize the dp and w arrays
		dp = new int[n + 1];
		w = new int[n + 1];

		// fill the dp array with -1 initially
		Arrays.fill(dp, -1);

		// read the volume of each bottle
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}

		// no bottle, no wine to drink
		w[0] = 0;
		dp[0] = 0;

		// if there are at least two bottles, drink both
		if (n >= 2) {
			dp[2] = w[1] + w[2];
			dp[1] = w[1];
		}

		// if there is only one bottle, drink it
		else if (n == 1)
			dp[1] = w[1];

		// calculate the maximum volume of wine that can be drunk from n bottles
		int res = recur(n);

		// write the result to the standard output
		bw.write(res + "");
		bw.flush();
		bw.close();
	}
}
