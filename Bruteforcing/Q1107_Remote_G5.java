package Bruteforcing;

//commented by ChatGPT
//Summary: The program calculates the minimum number of operations to change the channel of a broken remote. 
//The remote can either increase/decrease the channel by 1 or directly input the desired channel. 
//However, some buttons might be broken.

import java.io.*;
import java.util.*;

public class Q1107_Remote_G5 {

	public static void main(String[] args) throws IOException {

		// For reading the input and writing the output.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the desired channel and number of broken buttons.
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		// Using HashMap to track the functionality of buttons, 1 if it's working and 0
		// otherwise.
		HashMap<Integer, Integer> hm = new HashMap<>();

		// Initially, all buttons (0 to 9) are considered working.
		for (int i = 0; i <= 9; i++) {
			hm.put(i, 1);
		}

		// Read and process the list of broken buttons.
		String inp[] = new String[10];
		if (m > 0)
			inp = br.readLine().split(" ");

		for (int i = 0; i < m; i++) {
			hm.put(Integer.parseInt(inp[i]), 0); // Update the functionality status of buttons in the HashMap.
		}

		// Initialize the result with the difference between the current channel (100)
		// and the desired channel.
		int res;
		if (n > 100)
			res = n - 100;
		else
			res = 100 - n;

		// Loop to test each possible channel (up to 1000000) using the working buttons.
		for (int i = 0; i <= 1000000; i++) {
			String t = i + "";
			// Check each digit of the current channel.
			for (int j = 0; j < t.length(); j++) {
				// If the digit corresponds to a broken button, break out of the loop.
				if (hm.get(Integer.parseInt(Character.toString(t.charAt(j)))) != 1) {
					break;
				}
				// If we reach the end of the channel number without encountering a broken
				// button.
				if (j == t.length() - 1) {
					// Update the result with the minimum between the current result and the sum of
					// the length of the channel number and the difference between the desired and
					// current channel.
					res = Math.min(res, t.length() + Math.abs(n - i));
				}
			}
		}

		// Write the final result.
		bw.write(res + "");

		// Flush and close the BufferedWriter.
		bw.flush();
		bw.close();
	}
}