package String;

/* 
commented by ChatGPT
This code finds the length of the Longest Common Subsequence (LCS) between two strings.
*/

import java.io.*;
import java.util.*;

public class Q9251_LCS_G5 {

	// Declare a 2D array to store the characters of the two input strings.
	static char str[][] = new char[2][1001];
	// Declare a 2D array to store the results of LCS for different substrings
	// (Memoization).
	static int lcs[][] = new int[1001][1001];
	// Declare two integers to store the lengths of the input strings.
	static int alen, blen;

	// Recursive function to calculate the LCS using top-down dynamic programming.
	static int dp(int i, int j) {

		// Base condition: If any of the strings is empty, the LCS is 0.
		if (i == 0 || j == 0)
			return 0;

		// If the result is already computed for the given substring, return it.
		if (lcs[i][j] >= 0) {
			return lcs[i][j];
		}

		// If characters at current position are equal, consider them in LCS.
		if (str[0][i] == str[1][j]) {
			lcs[i][j] = dp(i - 1, j - 1) + 1;
		} else {
			// If characters are different, take the maximum of LCS values when ignoring
			// either character.
			lcs[i][j] = Math.max(dp(i - 1, j), dp(i, j - 1));
		}

		return lcs[i][j];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the first string and calculate its length.
		String s = br.readLine();
		alen = s.length();
		// Convert the string to a character array.
		for (int i = 1; i <= alen; i++) {
			str[0][i] = s.charAt(i - 1);
			// Initialize the memoization array for this index.
			Arrays.fill(lcs[i], -1);
		}

		// Read the second string and calculate its length.
		s = br.readLine();
		blen = s.length();
		// Convert the string to a character array.
		for (int i = 1; i <= s.length(); i++) {
			str[1][i] = s.charAt(i - 1);
			// Initialize the memoization array for this index.
			Arrays.fill(lcs[i], -1);
		}

		// Write the result to the output.
		bw.write(dp(alen, blen) + "");

		// Flush and close the BufferedWriter.
		bw.flush();
		bw.close();
	}
}
