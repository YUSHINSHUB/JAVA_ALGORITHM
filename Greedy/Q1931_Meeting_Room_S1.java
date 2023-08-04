package Greedy;

/* 
Commented by ChatGPT
Summary: This Java program counts the maximum number of meetings that can be attended 
given start and end times. 
It does so by sorting the meetings by end time and selecting those that don't conflict.
*/

import java.io.*;
import java.util.*;

public class Q1931_Meeting_Room_S1 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Buffer to read input from the
																					// console.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // Buffer to write output to the
																					// console.

		int n = Integer.parseInt(br.readLine()); // Reading the number of meetings.
		int ca[][] = new int[n][2]; // 2D array to store the start and end times of each meeting.

		// Loop to fill the array with start and end times.
		for (int i = 0; i < n; i++) {
			String[] c = br.readLine().split(" ");
			ca[i][0] = Integer.parseInt(c[0]); // Start time.
			ca[i][1] = Integer.parseInt(c[1]); // End time.
		}

		// Sort the meetings by end time. If end times are same, then by start time.
		Arrays.sort(ca, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0]; // Sorting by start time if end times are same.
			} else {
				return o1[1] - o2[1]; // Sorting by end time.
			}
		});

		int cnt = 1; // Count of meetings that can be attended.
		int stime = ca[0][1]; // The end time of the first meeting in the sorted list.

		// Loop to go through the sorted list of meetings.
		for (int i = 1; i < n; i++) {
			if (ca[i][0] >= stime) { // If the start time of the current meeting is after the end time of the
										// previous meeting.
				stime = ca[i][1]; // The end time of the current meeting.
				cnt++; // Increment the count of meetings that can be attended.
			}
		}

		bw.write(String.valueOf(cnt)); // Write the count to the console.
		bw.flush(); // Flush the buffer.
		bw.close(); // Close the buffer.
	}
}
