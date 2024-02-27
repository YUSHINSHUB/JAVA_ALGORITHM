package Dynamic_Programming;

/*
commented by ChatGPT
Summary: This code reads an input string representing a sequence of numbers. It calculates the number of ways the sequence can be decoded into alphabets where '1' is 'A', '2' is 'B', ..., '26' is 'Z'. 

For instance:
"111" can be decoded as "AAA", "KA", or "AK", so the output is 3.
*/

import java.io.*;

public class Q2011_Password_G5 {

	public static void main(String[] args) throws IOException {

		// Initialize input and output streams for reading and writing.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read input string of numbers.
		String s = br.readLine();
		int len = s.length();

		// Variables 'y' and 'n' will be used to store intermediate decoding counts.
		int y = 0, n = 0;
		int res = 0; // 'res' will store the final count of possible decodings.

		// Boolean flag to detect invalid number sequences in the string.
		boolean pass = false;

		// If the sequence starts with '0', it's invalid.
		if (s.charAt(0) == '0')
			bw.write("0");
		else if (len == 1) // If only one number, there's only one way to decode.
			bw.write("1");
		else {
			int temp = Integer.parseInt(s.substring(0, 2));

			// Sequences like 30, 40, 50... are invalid as they don't map to any alphabet.
			if (temp % 10 == 0 && temp >= 30) {
				pass = true;
				res = 0;
			}

			if (!pass) {
				// For numbers <= 26, consider multiple possible decodings.
				if (temp <= 26) {
					res = 2;
					y = 1;
					n = 1;

					// Numbers 10 and 20 have a unique decoding (J and T respectively).
					if (temp == 10 || temp == 20) {
						res = 1;
						y = 1;
						n = 0;
					}
				} else { // Numbers > 26 can only be decoded in one way.
					res = 1;
					y = 0;
					n = 1;
				}

				// Iterate through the sequence to count possible decodings.
				for (int i = 1; i < s.length() - 1; i++) {
					temp = Integer.parseInt(s.substring(i, i + 2));

					// Invalid sequences like 30, 40, 50 or 00 are checked.
					if ((temp % 10 == 0 && temp >= 30) || temp == 0) {
						pass = true;
						res = 0;
						break;
					}

					// For numbers between 10 and 26, consider multiple decodings.
					if (temp <= 26 && temp >= 10) {
						if (temp == 10 || temp == 20) {
							res = ((res + 1000000) - y) % 1000000; // Adjusting count to ensure it's non-negative.
							y = res;
							n = 0;
						} else {
							y = n;
							n = res;
							res = (y + n) % 1000000; // Count the decodings modulo 1000000 to handle large values.
						}
					} else {
						y = 0;
						n = res;
					}
				}
			}

			// If the result is zero and the sequence was not flagged as invalid, set result
			// to 1.
			if (res == 0 && !pass)
				res = 1;

			// Write the final result.
			bw.write(res + "");
		}

		// Flush and close the output stream.
		bw.flush();
		bw.close();
	}
}
