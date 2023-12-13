package Binary_Search;

/*
commented by ChatGPT
Summary: A program to find the pair of numbers in an array whose sum is closest to zero. 
After sorting the array, the program utilizes a two-pointer approach to find the pair with a sum closest to zero.
*/

import java.io.*;
import java.util.*;

public class Q2470_Two_Solution_G5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of elements in the array.
		int n = Integer.parseInt(br.readLine());
		int sol[] = new int[n];

		// Read the array elements and store them in the 'sol' array.
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			sol[i] = Integer.parseInt(inp[i]);
		}

		// Sort the array in ascending order.
		Arrays.sort(sol);

		// Initialize pointers and variables.
		int low = 0;
		int hig = n - 1;
		int clow = 0;
		int chig = n - 1;
		// 'cur' stores the absolute value of the sum of the current pair.
		int cur = Math.abs(sol[0] + sol[n - 1]);

		// Iterate using two pointers until the desired conditions are met.
		while (true) {
			// Breaking conditions: if pointers overlap or sum is zero.
			if (clow >= chig || clow == chig - 1)
				break;
			if (cur == 0)
				break;

			// Determine which pointer to move to get closer to zero.
			if (Math.abs(sol[clow + 1] + sol[chig]) > Math.abs(sol[clow] + sol[chig - 1])) {
				chig--;
			} else {
				clow++;
			}

			// If the new sum is closer to zero than the previous, update the best result.
			if (cur > Math.abs(sol[clow] + sol[chig])) {
				low = clow;
				hig = chig;
				cur = Math.abs(sol[clow] + sol[chig]);
			}
		}

		// Write the result to the output.
		bw.write(sol[low] + " " + sol[hig]);
		bw.flush();
		bw.close();
	}
}
