package Dynamic_Programming;

/*
commented by ChatGPT
This Java code implements a dynamic programming approach to solve the matrix chain multiplication problem. 
It aims to find the minimum number of scalar multiplications required to compute the product of a sequence of matrices.

dp(int start, int end) function: A dynamic programming function to compute the minimum cost of multiplying a chain of matrices.

It uses memoization to store and reuse previously computed results, stored in mem[][].
Iteratively computes the minimum cost for all possible partitions of the matrix chain.
The cost is calculated as the sum of multiplying the two partitions and the cost of multiplying the resulting matrices.
main method:

Reads the number of matrices N.
Initializes mat[] to store the dimensions of matrices and mem[][] for memoization.
Fills mem[][] with Integer.MAX_VALUE as a placeholder for uncomputed values, and sets diagonal values to 0 (cost of multiplying one matrix is 0).
Calls dp(0, N - 1) to find the minimum multiplication cost for the entire chain.
Outputs the result.
The algorithm efficiently calculates the optimal order of matrix multiplications to minimize the total computational cost.
*/

import java.io.*;
import java.util.*;

public class Q11049_Matrix_G3 {

	static int mat[] = new int[501]; // Stores dimensions of matrices
	static int mem[][] = new int[500][500]; // Memoization table

// Dynamic programming function to compute minimum multiplication cost
	static int dp(int start, int end) {
		if (mem[start][end] < Integer.MAX_VALUE)
			return mem[start][end]; // Return already computed value

		// Compute cost for all partitions of the matrix chain
		for (int i = start; i < end; i++) {
			mem[start][end] = Math.min(mem[start][end],
					dp(start, i) + dp(i + 1, end) + (mat[start] * mat[i + 1] * mat[end + 1]));
		}

		return mem[start][end]; // Return minimum cost
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N; // Number of matrices
		N = Integer.parseInt(br.readLine());

		// Read matrix dimensions and initialize memoization table
		for (int i = 0; i < N; i++) {
			String inp[] = br.readLine().split(" ");
			mat[i] = Integer.parseInt(inp[0]);
			mat[i + 1] = Integer.parseInt(inp[1]);
			Arrays.fill(mem[i], Integer.MAX_VALUE);
			mem[i][i] = 0; // Cost of multiplying one matrix is 0
		}

		// Write the minimum cost to multiply the entire chain
		bw.write(dp(0, N - 1) + "");
		bw.flush();
		bw.close();
	}
}