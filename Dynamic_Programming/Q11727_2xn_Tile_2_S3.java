package Dynamic_Programming;

//Commented by ChatGPT
//This Java program calculates the nth term of a sequence using dynamic programming. 
//The program uses memoization to store previously calculated values of the sequence to avoid redundant calculations.

import java.io.*;

public class Q11727_2xn_Tile_2_S3 {

	// Create an array to store the memoized values of the sequence
	static int mem[] = new int[1001];

	// Dynamic programming function to calculate the nth term of the sequence
	static int dp(int a) {
		// If the value is already calculated and stored in mem[], return it
		if (mem[a] > 0)
			return mem[a];
		else {
			// Otherwise, calculate the nth term using the recurrence relation
			// The nth term is the sum of the (n-1)th term and 2 times the (n-2)th term
			// The result is stored in mem[] and returned
			mem[a] = (dp(a - 1) + (dp(a - 2) * 2)) % 10007;
			return mem[a];
		}
	}

	public static void main(String[] args) throws IOException {

		// Create BufferedReader and BufferedWriter for input and output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the value of n (term to calculate)
		int n = Integer.parseInt(br.readLine());
		// Initialize the base cases of the sequence
		mem[0] = 1;
		mem[1] = 1;

		// Write the nth term of the sequence to the output
		bw.write(dp(n) + "");

		// Flush and close the BufferedWriter
		bw.flush();
		bw.close();
	}
}
