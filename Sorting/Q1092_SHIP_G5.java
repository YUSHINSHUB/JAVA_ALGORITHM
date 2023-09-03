package Sorting;

//commented by ChatGPT
//Summary: A program to determine the minimum number of trips ships need to make to carry all bags.

import java.io.*;
import java.util.*;

public class Q1092_SHIP_G5 {

	public static void main(String[] args) throws IOException {

		// Initialize readers and writers for input and output streams.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the number of ships and initialize a ship array to store their
		// capacities.
		int n = Integer.parseInt(br.readLine());
		String[] inp = br.readLine().split(" ");
		Integer[] ship = new Integer[n];

		// Parse ship capacities from the input and store them in the ship array.
		for (int i = 0; i < n; i++) {
			ship[i] = Integer.parseInt(inp[i]);
		}

		// Sort the ship capacities in descending order for efficient allocation.
		Arrays.sort(ship, Collections.reverseOrder());

		// Read the number of bags and initialize an ArrayList to store their weights.
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> bag = new ArrayList<>();
		inp = br.readLine().split(" ");

		// Parse bag weights from the input and store them in the bag ArrayList.
		for (int i = 0; i < m; i++) {
			bag.add(Integer.parseInt(inp[i]));
		}

		// Sort bag weights in descending order to match them with ship capacities.
		Collections.sort(bag, Collections.reverseOrder());

		// Check if the heaviest bag is heavier than the largest ship's capacity.
		if (bag.get(0) > ship[0]) {
			// If so, it's impossible to transport all bags; hence, output -1.
			bw.write("-1");
		} else {
			int res = 0; // Initialize counter for the number of trips.

			// While there are bags left to be transported.
			while (!bag.isEmpty()) {
				int idx = 0; // Index to keep track of the current ship being considered.

				// Iterate through the bags to allocate them to ships.
				for (int j = 0; j < m; j++) {
					// If current ship can carry the bag.
					if (ship[idx] >= bag.get(j)) {
						bag.remove(j); // Remove the bag as it's now allocated.
						j--;
						m--;
						idx++; // Move to the next available ship.
						if (idx == n) { // If all ships are used up.
							break;
						}
					}
				}

				// Update the count of available ships and increment the trip counter.
				n = idx;
				res++;
			}

			// Write the minimum number of trips required to transport all bags to the
			// output.
			bw.write(res + "");
		}

		// Flush and close the BufferedWriter to ensure all data gets written to the
		// output.
		bw.flush();
		bw.close();
	}
}
