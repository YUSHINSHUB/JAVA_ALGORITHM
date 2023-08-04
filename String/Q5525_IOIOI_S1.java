package String;

/* 
Commented by ChatGPT
Summary: This Java program identifies and counts occurrences of a specific pattern (IO...OI) in an input string. The number of 'O's in the pattern is specified by the input 'n'.
*/

import java.io.*;

public class Q5525_IOIOI_S1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Buffer to read input from the
																					// console.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Buffer to write output to the
																					// console.

		int res = 0; // Stores the total number of matched patterns.
		int n = Integer.parseInt(br.readLine()); // Reading the number of 'O's in the pattern.

		int cnt = 0; // Counter variable to track the pattern.
		n *= 2;
		n++; // Incrementing n to match the number of 'I's and 'O's in the pattern.

		int m = Integer.parseInt(br.readLine()); // Reading the length of the string to be checked.
		String s = br.readLine(); // Reading the string to be checked.

		// Looping through the string.
		for (int i = 0; i < m; i++) {
			if (cnt % 2 == 0 && s.charAt(i) == 'I') { // Checking for 'I' at even indices.
				cnt++;
				if (cnt == n) { // If the count equals n, we found a pattern.
					res++;
					cnt -= 2;
				}
			} else if (cnt % 2 == 1 && s.charAt(i) == 'O') { // Checking for 'O' at odd indices.
				cnt++;
			} else if (s.charAt(i) == 'I') {
				cnt = 1;
			} else {
				cnt = 0;
			}
		}

		bw.write(res + ""); // Writing the result to the console.
		bw.flush(); // Flushing the buffer.
		bw.close(); // Closing the buffer.
	}
}
