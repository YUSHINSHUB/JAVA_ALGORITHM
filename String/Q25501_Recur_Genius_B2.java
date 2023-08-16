package String;

/*
Commented by ChatGPT
Summary: This Java program checks if each string in a list of strings is a palindrome using a recursive approach.

*/
import java.io.*;

public class Q25501_Recur_Genius_B2 {

	static int cnt; // Declare a static variable cnt to track the number of recursive calls

	// Recursive function to check if a string is a palindrome
	protected static int recursion(String s, int l, int r) {
		cnt++; // Increment the cnt variable
		if (l >= r) // If left pointer is greater than or equal to the right pointer, return 1
			return 1;
		else if (s.charAt(l) != s.charAt(r)) // If the characters at left and right pointers are not equal, return 0
			return 0;
		else
			return recursion(s, l + 1, r - 1); // Otherwise, continue checking with the next characters
	}

	// Function that calls the recursive function and returns 1 if the string is a
	// palindrome and 0 otherwise
	protected static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // Read the number of strings
		String inp;

		for (int i = 0; i < n; i++) { // Loop through each string
			inp = br.readLine(); // Read the input string
			cnt = 0; // Reset cnt to 0
			bw.write(isPalindrome(inp) + " " + cnt + "\n"); // Write the result and the number of recursive calls
		}

		bw.flush(); // Flush the buffer
		bw.close(); // Close the BufferedWriter

	}
}
