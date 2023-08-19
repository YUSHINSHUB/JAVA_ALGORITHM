package Data_Structures;

//Commented by ChatGPT
//Summary: This Java program calculates the number of possible outfit combinations based on the given clothes' categories and their count.

import java.io.*;
import java.util.*;

public class Q9375_Fashion_King_S3 {

	public static void main(String[] args) throws IOException {
		// Create a BufferedReader object to read input from standard input.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Create a BufferedWriter object to write output to standard output.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of test cases (t) from the input.
		int t = Integer.parseInt(br.readLine());
		// Initialize the variable 'res' to store the final result for each test case.
		int res;
		// Create a HashMap to store the count of clothes in each category.
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// Process each test case.
		for (int i = 0; i < t; i++) {
			// Read the number of clothes (c) in this test case.
			int c = Integer.parseInt(br.readLine());
			// Initialize 'res' to 1 for this test case.
			res = 1;
			// Clear the HashMap to remove data from previous test cases.
			hm.clear();
			// Process each clothing item.
			for (int z = 0; z < c; z++) {
				// Read the clothing item's name and category.
				String inp[] = br.readLine().split(" ");
				// Increment the count of clothes in the given category.
				hm.put(inp[1], hm.getOrDefault(inp[1], 0) + 1);
			}

			// Calculate the number of possible outfit combinations.
			for (int temp : hm.values()) {
				// Multiply the result by (category count + 1) to consider each item in the
				// category and the possibility of not wearing any item from the category.
				res *= temp + 1;
			}

			// Subtract 1 to exclude the possibility of not wearing any clothes.
			res--;
			// Write the result for this test case to the output.
			bw.write(res + "\n");
		}

		// Flush the BufferedWriter and close it to finish writing the output.
		bw.flush();
		bw.close();
	}
}
