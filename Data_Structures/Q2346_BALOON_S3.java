// Commented by ChatGPT
// Summary: This program uses a deque to handle a sequence of commands given as input. 
//It continually shifts the deque based on the commands until the deque is empty.
package Data_Structures;

import java.io.*;
import java.util.*;

public class Q2346_BALOON_S3 {

	public static void main(String[] args) throws IOException {

		// For reading input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// For writing output
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Initialize a deque to store numbers
		Deque<Integer> dq = new ArrayDeque<Integer>();

		// Read the total number of commands
		int n = Integer.parseInt(br.readLine());

		// Array to store the commands
		int cod[] = new int[n];
		String inp[] = br.readLine().split(" ");

		// Populate the deque with initial sequence
		for (int i = 0; i < n; i++) {
			cod[i] = Integer.parseInt(inp[i]);
			dq.addLast(i + 1);
		}

		// Position and index variables for deque manipulation
		int idx = 0;
		int pos = 0;

		// Main loop to process commands and manipulate deque
		while (true) {

			pos = dq.pollFirst(); // Remove and get the first element
			bw.write(pos + " "); // Write to output
			idx = cod[pos - 1]; // Get the corresponding command

			if (dq.isEmpty())
				break; // If deque is empty, end the process
			else {
				if (idx > 0) { // If command is positive, rotate to right
					for (int i = 0; i < idx - 1; i++) {
						dq.addLast(dq.pollFirst());
					}
				} else { // If command is negative, rotate to left
					idx *= (-1);
					for (int i = 0; i < idx; i++) {
						dq.addFirst(dq.pollLast());
					}
				}
			}
		}

		// Output results
		bw.flush();
		bw.close();

	}
}
