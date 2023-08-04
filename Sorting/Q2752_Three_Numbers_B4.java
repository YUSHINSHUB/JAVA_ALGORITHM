package Sorting;

/*
Commented by ChatGPT
Summary: The Java program reads a space-separated line of integers from the console, 
sorts them in ascending order, and then outputs the sorted list to the console.
*/

import java.io.*;
import java.util.*;

public class Q2752_Three_Numbers_B4 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Reads a line of numbers
		String numbers = br.readLine();

		// Tokenizes the line into individual numbers
		StringTokenizer stk = new StringTokenizer(numbers, " ");

		// Gets the count of numbers
		int index = stk.countTokens();

		// Creates an array to hold the numbers
		int[] num = new int[index];

		// Parses the numbers and stores them in the array
		for (int i = 0; i < index; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}

		// Sorts the array in ascending order
		Arrays.sort(num);

		// Writes the sorted numbers to the console
		for (int i = 0; i < index; i++) {
			bw.write(String.valueOf(num[i]) + " ");
		}

		bw.flush();
		bw.close();
	}
}
