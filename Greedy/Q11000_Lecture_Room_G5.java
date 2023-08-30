package Greedy;

/*
commented by ChatGPT
Summary:
This program determines the number of rooms required to accommodate a set of lectures. Lectures are first 
sorted based on their start times and end times. The program then assesses which lecture can fit into 
which room without a time conflict. Each room's end time is kept in a priority queue.
*/

import java.io.*;
import java.util.*;

//Class representing each lecture with start and end times.
class lec {
	int s; // Start time of the lecture.
	int t; // End time of the lecture.

	lec(int s, int t) {
		this.s = s;
		this.t = t;
	}
}

public class Q11000_Lecture_Room_G5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Priority Queue to hold the end times of lectures in each room.
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine()); // Number of lectures.
		lec list[] = new lec[n]; // Array to hold all the lectures.

		// Reading the details of each lecture and adding them to the list.
		for (int i = 0; i < n; i++) {
			String inp[] = br.readLine().split(" ");
			int s = Integer.parseInt(inp[0]);
			int t = Integer.parseInt(inp[1]);

			list[i] = new lec(s, t);
		}

		// Sorting the lectures primarily by start time and secondarily by end time.
		Arrays.sort(list, new Comparator<lec>() {
			public int compare(lec o1, lec o2) {
				if (o1.s != o2.s)
					return o1.s - o2.s; // Primary sorting by start time.
				else
					return o1.t - o2.t; // Secondary sorting by end time.
			}
		});

		// Adding the end time of the first lecture to the priority queue.
		pq.add(list[0].t);

		// For each subsequent lecture in the sorted list.
		for (int i = 1; i < n; i++) {
			// If the lecture can start after the earliest finishing room, remove that
			// room's end time.
			if (pq.peek() <= list[i].s) {
				pq.poll();
			}
			// Add the end time of the current lecture to the priority queue.
			pq.add(list[i].t);
		}

		// Write the total number of rooms used.
		bw.write(pq.size() + "");

		bw.flush();
		bw.close();
	}
}
