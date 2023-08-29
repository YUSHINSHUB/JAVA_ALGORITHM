package Divide_and_Conquer;

/*
Commented by ChatGPT
Summary: This Java program generates the Cantor set pattern (fractal) up to iteration 12, and prints the pattern corresponding to the iteration number entered by the user. 
The Cantor set pattern is generated by iteratively splitting each segment into three equal parts and removing the middle part.
*/

import java.io.*;

public class Q4779_Cantor_Set_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder cnt[] = new StringBuilder[13]; // Initialize an array of StringBuilder to hold the patterns for
														// each iteration

		for (int i = 0; i <= 12; i++)
			cnt[i] = new StringBuilder(""); // Initialize each StringBuilder

		cnt[0].append("-"); // The base pattern

		for (int i = 1; i <= 12; i++) { // Generate the pattern for iterations 1 to 12
			int bl = cnt[i - 1].length(); // Get the length of the previous iteration's pattern
			for (int j = 0; j < bl; j++) {
				cnt[i].append(cnt[i - 1].charAt(j)); // Copy the previous pattern
			}
			for (int j = 0; j < bl; j++) {
				cnt[i].append(" "); // Add a space for the removed middle part
			}
			for (int j = 0; j < bl; j++) {
				cnt[i].append(cnt[i - 1].charAt(j)); // Copy the previous pattern again
			}
		}

		String inp = "";
		while ((inp = br.readLine()) != null) { // Read the iteration number from the user
			bw.write(cnt[Integer.parseInt(inp)] + "\n"); // Print the pattern corresponding to the entered iteration
		}

		bw.flush();
		bw.close();
	}
}