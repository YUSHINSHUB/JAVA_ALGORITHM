package Parametric_Search;

//Commented by ChatGPT
//Summary: This program calculates the height at which to cut trees to achieve a target total height, given an array of initial tree heights.

import java.io.*;
import java.util.*;

public class Q2805_Cut_Tree_S2 {
	public static void main(String[] args) throws IOException {
		// Set up input and output stream readers and writers
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the first line of input and parse the number of trees (n) and the target
		// height (goal)
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		long goal = Long.parseLong(inp[1]);
		// Initialize variables for the current height, the total cut height, and the
		// index for iterating over unique tree heights
		long h = 0;
		long cut = 0;
		int idx = 0;

		// Read the second line of input and parse the heights of the trees
		inp = br.readLine().split(" ");
		int temp = 0;

		// Initialize a hashmap to store the frequency of each tree height, and a
		// hashset to store the unique heights
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		HashSet<Integer> hset = new HashSet<Integer>();

		// Populate the hashmap and hashset with the input tree heights
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(inp[i]);
			hset.add(temp);
			hm.put(temp, hm.getOrDefault(temp, 0) + 1);
		}

		// Convert the hashset to an array of unique tree heights and sort it in
		// descending order
		Integer trees[] = hset.toArray(new Integer[0]);
		Arrays.sort(trees, Collections.reverseOrder());

		// Iterate over the unique tree heights and calculate the height to cut
		for (int i = 0; i < trees.length - 1; i++) {
			idx += hm.get(trees[i]);
			// Calculate the potential cut height and check if it doesn't exceed the target
			// height
			if (cut + ((trees[i] - trees[i + 1]) * idx) <= goal) {
				cut += ((trees[i] - trees[i + 1]) * idx);
				h += trees[i] - trees[i + 1];
			} else {
				// Adjust the cut height and current height if the potential cut exceeds the
				// target height
				h += (goal - cut) / idx;
				cut += ((goal - cut) / idx) * idx;
				if (cut != goal) {
					h++;
				}
				cut = goal;
				break;
			}
		}

		// Special case for when there's only one unique tree height
		if (trees.length == 1) {
			h = (goal / n);
			if (goal % n != 0)
				h++;
		} else if (cut != goal) {
			// Adjust the current height and cut height based on the remaining cut needed
			h += (goal - cut) / n;
			cut += ((goal - cut) / n) * n;
			if (cut != goal)
				h++;
		}

		// Write the result to the output
		bw.write((trees[0] - h) + "");

		bw.flush();
		bw.close();
	}
}
