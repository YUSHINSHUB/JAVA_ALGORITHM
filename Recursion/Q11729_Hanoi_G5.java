package Recursion;

/*
Commented by ChatGPT
Summary: This Java program solves the Tower of Hanoi problem using recursion. 
Given the number of disks (n), it calculates the minimum number of moves required to solve the problem and prints the moves step-by-step.
*/

import java.io.*;
import java.math.*;

public class Q11729_Hanoi_G5 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	// Recursive function to solve the Tower of Hanoi problem
	public static void hanoi(int n, int s, int m, int e) throws IOException {
		if (n == 1) { // Base case: if only one disk, move it from source to destination
			bw.write(s + " " + e + "\n");
			return;
		}

		// Move n-1 disks from source to auxiliary peg, using destination peg as
		// auxiliary
		hanoi(n - 1, s, e, m);

		// Move the nth disk from source to destination peg
		bw.write(s + " " + e + "\n");

		// Move the n-1 disks from auxiliary peg to destination peg, using source peg as
		// auxiliary
		hanoi(n - 1, m, s, e);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// Print the minimum number of moves required to solve the problem
		bw.write((int) Math.pow(2, n) - 1 + "\n");

		// Print the moves step-by-step
		hanoi(n, 1, 2, 3);

		bw.flush();
		bw.close();
	}
}
