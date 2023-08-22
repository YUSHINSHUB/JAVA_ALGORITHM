package Bruteforcing;

//Commented by ChatGPT
//Summary: This Java program reads input test cases containing strings and determines the minimum number of character replacements needed for three strings (from each test case) to become identical.

import java.io.*;

public class Q20529_Psychological_Distance_S1 {

	public static void main(String[] args) throws IOException {
		// Set up buffered readers and writers for input and output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of test cases
		int t = Integer.parseInt(br.readLine());

		// Process each test case
		for (int i = 0; i < t; i++) {

			// Read the input size
			int n = Integer.parseInt(br.readLine());

			// Read the input strings into an array
			String inp[] = br.readLine().split(" ");

			// If the input size is 33 or greater, write 0 to output and continue to next
			// test case
			if (n >= 33) {
				bw.write("0\n");
				continue;
			}

			int cnt = 0; // Counter for the number of character replacements
			int res = Integer.MAX_VALUE; // Result for the minimum number of character replacements

			// Compare each combination of three strings from the input
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int l = k + 1; l < n; l++) {
						cnt = 0; // Reset counter for character replacements

						// Compare characters in positions 0 to 3 of the three strings
						for (int m = 0; m < 4; m++) {
							// If the characters are not equal, increment the counter for replacements
							if (inp[j].charAt(m) != inp[k].charAt(m))
								cnt++;
							if (inp[j].charAt(m) != inp[l].charAt(m))
								cnt++;
							if (inp[k].charAt(m) != inp[l].charAt(m))
								cnt++;
						}

						// Update the result with the minimum number of replacements found
						res = Math.min(res, cnt);
					}
				}
			}

			// Write the result to the output
			bw.write(res + "\n");

		}

		// Flush and close the output writer
		bw.flush();
		bw.close();
	}
}
