package Backtracking;

/*
commented by ChatGPT
Summary: This program computes decreasing numbers using backtracking. It then finds the nth decreasing number in the list.
*/

import java.io.*;
import java.util.*;

public class Q1038_Decreasing_Numbers_G5 {

// Define a list to store the decreasing numbers.
	static ArrayList<Long> list = new ArrayList<>();

	/*
	 * The backtracking function that computes decreasing numbers. Given a number,
	 * it tries to append digits to its end which are smaller than the last digit of
	 * the current number.
	 */
	static void bt(long n) {
		for (int i = 0; i <= 9; i++) {
			if (i < n % 10) {
				list.add(n * 10 + i);
				bt(n * 10 + i);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		// Initialize BufferedReader and BufferedWriter for input and output
		// respectively.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the required nth position
		int n = Integer.parseInt(br.readLine());

		// Zero is the first decreasing number by definition
		list.add((long) 0);

		// Initialize the list with single digit numbers and then use backtracking to
		// compute the multi-digit decreasing numbers.
		for (int i = 1; i <= 9; i++) {
			list.add((long) i);
			bt(i);
		}

		// Sorting the list of decreasing numbers
		Collections.sort(list);

		// If n is greater than or equal to the size of the list, print -1. Otherwise,
		// print the nth decreasing number.
		if (n >= list.size())
			bw.write("-1");
		else
			bw.write(list.get(n) + "");

		bw.flush();
		bw.close();
	}
}
