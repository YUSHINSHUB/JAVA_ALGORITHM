package Mathematics;

//Commented by ChatGPT
//This program calculates the factorial of a given number in Java.

import java.io.*;

public class Q10872_FACTORIAL_B5 {

	public static void main(String[] args) throws IOException {

		// Set up input and output stream readers/writers
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Parse the input number
		int n = Integer.parseInt(br.readLine());

		// Initialize the result as 1, which will hold the factorial value
		int res = 1;

		// Loop from 1 to the given number, multiplying each value to the result
		for (int i = 1; i <= n; i++) {
			res *= i;
		}

		// Write the computed factorial value to the output
		bw.write(String.valueOf(res));

		// Flush and close the BufferedWriter
		bw.flush();
		bw.close();
	}
}
