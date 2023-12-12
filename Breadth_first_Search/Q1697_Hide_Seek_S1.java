package Breadth_first_Search;

/*
Short Summary: 
This Java program takes two integers n and k, and calculates a minimum distance based on various rules. If n >= k, 
it outputs n - k. If n < k, 
it uses dynamic programming to calculate an array of distances and outputs the kth element of the distance array.

Commented by ChatGPT
*/

import java.io.*;
import java.math.*;
import java.util.*;

public class Q1697_Hide_Seek_S1 {

	public static void main(String[] args) throws IOException {

		// BufferedReader and BufferedWriter for IO operations
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reading two integers from user input
		String inp[] = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);

		// If n is greater or equal to k, write n - k to output
		if (n >= k)
			bw.write(n - k + "");

		else {
			// Initialize distance array with maximum integer value
			int dis[] = new int[k + 2];
			Arrays.fill(dis, Integer.MAX_VALUE - 1);

			// For each number from 0 to n, set the corresponding index in the distance
			// array to n - i
			for (int i = 0; i <= n; i++) {
				dis[i] = n - i;
			}

			// For each number from n to 1, calculate a minimum distance for each of its
			// multiples of 2 up to k + 1
			for (int i = n; i >= 1; i--) {
				if (i != 0) {
					for (int j = i * 2; j <= k + 1; j *= 2) {
						if (dis[j] > dis[j / 2] + 1)
							dis[j] = dis[j / 2] + 1;
						else
							break;
					}
				}
			}

			// For each number from n + 1 to k, calculate the minimum distance considering
			// the previous and next elements and their half
			for (int i = n + 1; i <= k; i++) {
				if (i % 2 == 0)
					dis[i] = Math.min(Math.min(Math.min(dis[i], dis[i - 1] + 1), dis[i + 1] + 1), dis[i / 2] + 1);
				else
					dis[i] = Math.min(Math.min(dis[i], dis[i - 1] + 1), dis[i + 1] + 1);

				for (int j = i * 2; j <= k + 1; j *= 2) {
					if (dis[j] > dis[j / 2] + 1)
						dis[j] = dis[j / 2] + 1;
					else
						break;
				}
			}

			// Write the kth element of the distance array to output
			bw.write(dis[k] + "");
		}

		// Flush and close BufferedWriter
		bw.flush();
		bw.close();
	}
}
