package Two_Pointer;

//commented by ChatGPT
//Summary: For each test case, it outputs 0 if the string is already a palindrome, 1 if a single character removal can make it a palindrome, and 2 otherwise.

import java.io.*;

public class Q17609_PALINDROME_G5 {

	public static void main(String[] args) throws IOException {
		// Initialization of input and output streams.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading the number of test cases.
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			// Initial result set to 0, indicating the string might already be a palindrome.
			String res = "0\n";

			// Reading the current string to be checked.
			String s = br.readLine();
			int beg = 0; // starting index of the string.
			int end = s.length() - 1; // ending index of the string.
			int sbeg = -1; // saved starting index when two possibilities exist.
			int send = -1; // saved ending index when two possibilities exist.

			while (beg < end) {
				if (s.charAt(beg) != s.charAt(end)) {
					if (res.equals("0\n")) {
						if (s.charAt(beg + 1) == s.charAt(end) && s.charAt(beg) == s.charAt(end - 1)) {
							// Two potential removals, saving current indices for backtracking.
							sbeg = beg;
							send = end;
							res = "1\n";
							beg++;
						} else if (s.charAt(beg + 1) == s.charAt(end)) {
							// Possible to create palindrome by removing character from the beginning.
							res = "1\n";
							beg++;
						} else if (s.charAt(beg) == s.charAt(end - 1)) {
							// Possible to create palindrome by removing character from the end.
							res = "1\n";
							end--;
						} else {
							// Removing a single character won't make the string palindrome.
							res = "2\n";
							break;
						}
					} else {
						if (sbeg != -1) {
							// Going back to saved indices to explore the other possibility.
							beg = sbeg;
							end = send - 1;
							sbeg = -1;
						} else {
							// Removing a single character won't make the string palindrome.
							res = "2\n";
							break;
						}
					}
				}
				beg++;
				end--;
			}

			bw.write(res); // Writing the result for the current test case.
		}

		bw.flush(); // Flushing the output stream.
		bw.close(); // Closing the output stream.
	}
}