package Stack;

//Commented by ChatGPT
//Summary: Java program that simulates a queuing system, using two deques to determine if an 
//intended order is achievable.

import java.io.*;
import java.util.*;

public class Q12789_DOKIDOKI_S3 {

	public static void main(String[] args) throws IOException {

		// Initializing BufferedReader and BufferedWriter for input and output
		// respectively
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of people in the line
		int n = Integer.parseInt(br.readLine());
		int idx = 1; // Index variable to track the desired order

		// Create the main queue (line) and an alternate queue (alt) to temporarily
		// store people
		Deque<Integer> line = new LinkedList<Integer>();
		Deque<Integer> alt = new LinkedList<Integer>();

		// Populate the main queue 'line' with the given input
		String inp[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			line.addLast(Integer.parseInt(inp[i]));
		}

		// Dequeue from the main queue as long as the order is correct
		while (!line.isEmpty() && line.getFirst() == idx) {
			line.pollFirst();
			idx++;
		}

		// This string will store our final result - "Nice" if the intended order is
		// achievable, "Sad" otherwise
		String res = "Nice";

		// Try to achieve the correct order by rearranging between the main and
		// alternate queues
		while (idx <= n) {

			if (!line.isEmpty()) {
				if (alt.isEmpty()) {
					// Move people from main queue to alternate queue until we find the person we're
					// looking for
					while (!line.isEmpty() && line.getFirst() != idx) {
						alt.addFirst(line.pollFirst());
					}
				} else {
					// If alt is not empty, move people around while searching for the right order
					while (!line.isEmpty() && line.getFirst() != idx && alt.getFirst() != idx) {
						alt.addFirst(line.pollFirst());
					}
				}
			}

			// If the desired person is not in the front of either queues, then the order
			// isn't achievable
			if (line.isEmpty() && (alt.isEmpty() || alt.getFirst() != idx)) {
				res = "Sad";
				break;
			} else if (!alt.isEmpty() && alt.getFirst() == idx) {
				// If the desired person is in front of the alternate queue, dequeue from there
				alt.pollFirst();
				idx++;
			} else {
				// If the desired person is in front of the main queue, dequeue from there
				line.pollFirst();
				idx++;
			}
		}

		// Write the result to the output
		bw.write(res);
		bw.flush();
		bw.close();
	}
}
