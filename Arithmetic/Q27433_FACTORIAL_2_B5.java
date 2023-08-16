package Arithmetic;

/*
Commented by ChatGPT
Summary: This program calculates the factorial of a given number.
*/

import java.io.*;

public class Q27433_FACTORIAL_2_B5 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // Declare the integer variable n

		long res = 1; // Declare a long long variable to store the result of the factorial

		for (int i = 2; i <= n; i++) // Loop from 2 to n
			res *= i; // Multiply the result by the current number

		bw.write(res + ""); // Output the result

		bw.flush();
		bw.close();

	}
}