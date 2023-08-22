package Bruteforcing;

//Commented by ChatGPT
//Summary: This Java program reads an integer input and determines the minimum number of perfect squares needed to sum up to the given integer. 
//The result will be a number between 1 and 4.

import java.io.*;

public class Q17626_Four_Squares_S3 {
	public static void main(String[] args) throws IOException {
		// Set up buffered readers and writers for input and output
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Read the input number n
		int n = Integer.parseInt(br.readLine());
		int rag[] = new int[n];
		int cnt = 1;
		int temp = 0;
		int res = 4; // Initialize result with 4, as it is the maximum possible result
		boolean end = false;

		// Populate rag array with perfect squares less than or equal to n
		while (true) {
			temp = (int) Math.pow(cnt, 2); // Compute square of cnt
			if (temp <= n) {
				rag[cnt - 1] = temp; // Store perfect square in rag array
				cnt++;
			} else {
				break;
			}
		}

		// Check if n is a perfect square
		for (int i = 0; i < cnt; i++) {
			if (n == rag[i]) {
				res = 1; // If n is a perfect square, result is 1
				end = true;
				break;
			}
		}

		// Check if n is a sum of two perfect squares
		if (!end) {
			for (int i = 0; i < cnt; i++) {
				for (int j = i; j < cnt; j++) {
					if (n == rag[i] + rag[j]) {
						res = 2; // If n is a sum of two perfect squares, result is 2
						end = true;
						break;
					}
				}
				if (end)
					break;
			}
		}

		// Check if n is a sum of three perfect squares
		if (!end) {
			for (int i = 0; i < cnt; i++) {
				for (int j = i; j < cnt; j++) {
					for (int k = j; k < cnt; k++) {
						if (n == rag[i] + rag[j] + rag[k]) {
							res = 3; // If n is a sum of three perfect squares, result is 3
							end = true;
							break;
						}
					}
					if (end)
						break;
				}
				if (end)
					break;
			}
		}

		// Write the result to the output
		bw.write(res + "");

		// Flush and close the output writer
		bw.flush();
		bw.close();
	}
}
