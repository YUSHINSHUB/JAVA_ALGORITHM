package Stack;

/*
Commented by ChatGPT
Summary: This code reads two integer arrays and executes output based on specific conditions defined by the first array. 

*/

import java.io.*;
import java.util.*;

public class Q24511_QUEUESTACK_S3 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Reader for input
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Writer for output

		int n = Integer.parseInt(br.readLine()); // Read the size of the arrays
		ArrayList<Integer> qs = new ArrayList<>(); // ArrayList to store indices where values are 0
		int num[] = new int[n]; // Array to store the numbers

		String inp[] = br.readLine().split(" "); // Parse the first line of input
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(inp[i]);
			if (t == 0)
				qs.add(i); // If the value is 0, store the index in the ArrayList
		}

		inp = br.readLine().split(" "); // Parse the second line of input
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(inp[i]); // Store the numbers in the num array

		int m = Integer.parseInt(br.readLine()); // Read the number of output elements
		inp = br.readLine().split(" "); // Parse the last line of input

		Collections.reverse(qs); // Reverse the order of the ArrayList

		// Write the elements from the num array according to the order of the indices
		// in the ArrayList
		for (int i : qs) {
			bw.write(num[i] + " ");
			m--;
			if (m == 0)
				break;
		}

		// If there are still elements to output, write the elements from the last input
		// line
		if (m > 0) {
			for (String i : inp) {
				bw.write(i + " ");
				m--;
				if (m == 0)
					break;
			}
		}

		bw.flush(); // Flush the BufferedWriter
		bw.close(); // Close the BufferedWriter
	}
}
